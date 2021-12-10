using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualBasic;

namespace Command
{
     // The Command interface declares a method for executing a command.
    public interface ICommand
    {
        public void Execute();
    }

    // Some commands can implement simple operations on their own.
    class ExitClickedCommand : ICommand
    {
        private readonly string _payload;

        public ExitClickedCommand(string payload)
        {
            _payload = payload;
        }

        public void Execute()
        {
            Console.WriteLine($"System final operation: {_payload}");
        }
    }
    class CloseOpenWindows : ICommand
    {
        private readonly Receiver _receiver;
        private List<string> _windows = new();
        
        public CloseOpenWindows(Receiver receiver)
        {
            _receiver = receiver;
        }

        public void AddWindow(string window)
        {
            _windows.Add(window);
        }
        public void Execute()
        {
            //Complex ops done by receiver
            _receiver.CloseAllWindows(_windows);
        }
    }
    class LogOutAllUsers : ICommand
    {
        private readonly Receiver _receiver;
        private List<string> _users = new();
        
        public LogOutAllUsers(Receiver receiver)
        {
            _receiver = receiver;
        }

        public void AddUser(string user)
        {
            _users.Add(user);
        }
        public void Execute()
        {
            //Complex ops done by receiver
            _receiver.LogOutAllUsers(_users);
        }
    }
    class Receiver
    {
        public void CloseAllWindows(List<string> windows)
        {
            foreach (var window in windows)
            { 
                Console.WriteLine($"Receiver: Closing window: ({window})");
            }
        }
        public void LogOutAllUsers(List<string> users)
        {
            foreach (var user in users)
            {
                Console.WriteLine($"Receiver: Logging out user: ({user})");
            }
        }
    }
    class Invoker
    {
        private List<ICommand> _commands = new ();
        private string _state;

        public Invoker(string state)
        {
            _state = state;
        }
        public void AddCommand(ICommand command)
        {
            _commands.Add(command);
        }
        public void Invoke()
        {
            foreach (var command in _commands)
            {
                command.Execute();
                Console.WriteLine();
            }
        }
        
        public Memento Save()
        {
            return new Memento(_state);
        }

        public void Restore(IMemento memento)
        {
            if (!(memento is Memento))
            {
                throw new Exception("Unknown memento class " + memento);
            }

            this._state = memento.GetState();
            Console.Write($"Originator: My state has changed to: {_state}");
        }
    }

    interface IMemento
    {
        string GetState();
    }

    class Memento : IMemento
    {
        private string _state;

        public Memento(string state)
        {
            _state = state;
        }
        public string GetState()
        {
            return _state;
        }
    }

    class Caretaker
    {
        private List<Memento> _mementoes = new();
        
        private Invoker _originator = null;

        public Caretaker(Invoker originator)
        {
            this._originator = originator;
        }

        public void Backup()
        {
            Console.WriteLine("\nCaretaker: Saving Originator's state...");
            this._mementoes.Add(this._originator.Save());
        }

        public void Undo()
        {
            if (this._mementoes.Count == 0)
            {
                return;
            }

            var memento = this._mementoes.Last();
            this._mementoes.Remove(memento);

            Console.WriteLine("Caretaker: Restoring state to: " + memento);

            try
            {
                this._originator.Restore(memento);
            }
            catch (Exception)
            {
                this.Undo();
            }
        }
        public void ShowHistory()
        {
            Console.WriteLine("Caretaker: Here's the list of mementos:");

            foreach (var memento in this._mementoes)
            {
                Console.WriteLine(memento);
            }
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {            
            Receiver receiver = new Receiver();
            CloseOpenWindows closeOpenWindows = new CloseOpenWindows(receiver);
            closeOpenWindows.AddWindow("Chrome");
            closeOpenWindows.AddWindow("Jetbrains IDE");
            closeOpenWindows.AddWindow("File Explorer");
            closeOpenWindows.AddWindow("Discord");
            LogOutAllUsers logOutAllUsers = new LogOutAllUsers(receiver);
            logOutAllUsers.AddUser("Jasiu");
            logOutAllUsers.AddUser("Mama");
            ExitClickedCommand exitClickedCommand = new ExitClickedCommand("System closing.");
            
            Invoker invoker = new Invoker("Running program");
            Caretaker caretaker = new Caretaker(invoker);

            
            invoker.AddCommand(closeOpenWindows);
            invoker.AddCommand(logOutAllUsers);
            invoker.AddCommand(exitClickedCommand);
            
            invoker.Invoke();
        }
    }
}