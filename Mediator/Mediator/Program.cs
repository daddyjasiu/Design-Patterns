using System;
using System.Collections.Generic;

namespace Mediator
{
    interface Mediator
    {
        void Add(Colleague colleague);
        void Remove(Colleague colleague);
        void Notify(string msg, Colleague colleague);
    }

    class ConcreteMediator : Mediator
    {
        private List<Colleague> _colleagues = new();
        
        public void Add(Colleague colleague)
        {
            _colleagues.Add(colleague);
        }

        public void Remove(Colleague colleague)
        {
            _colleagues.Remove(colleague);
        }

        public void Notify(string msg, Colleague currColleague)
        {
            foreach (var colleague in _colleagues)
            {
                if(colleague != currColleague)
                    colleague.Notify(msg);
            }
        }
        
    }

    abstract class Colleague
    {
        protected Mediator _mediator;
        protected string _name;

        public Colleague(string name, Mediator mediator)
        {
            _mediator = mediator;
            _name = name;
        }

        public virtual void Notify(string msg)
        {
            Console.WriteLine(this._name + ": " + msg);
        }
        public virtual void Receive(string msg){}
        public virtual void Verify(string msg){}
        public virtual void Complete(string msg){}
        public virtual void FileLog(string msg){}
        public virtual void DBLog(string msg){}
    }

    class Received : Colleague
    {
        public Received(string name, Mediator mediator) : base(name, mediator){}
        public override void Receive(string msg)
        {
            Console.WriteLine(this._name + ": Order Received, msg: " + msg + "\n");
            _mediator.Notify(msg, this);        
        }
    }
    
    class Verifying : Colleague
    {
        public Verifying(string name, Mediator mediator) : base(name, mediator){}
        public override void Verify(string msg)
        {
            Console.WriteLine(this._name + ": Order Verified, msg: " + msg + "\n");
            _mediator.Notify(msg, this);        
        }
    }
    
    class Completed : Colleague
    {
        public Completed(string name, Mediator mediator) : base(name, mediator){}
        public override void Complete(string msg)
        {
            Console.WriteLine(this._name + ": Order Completed, msg: " + msg + "\n");
            _mediator.Notify(msg, this);        
        }
    }

    class FileLogger : Colleague
    {
        public FileLogger(string name, Mediator mediator) : base(name, mediator){}
        public override void FileLog(string msg)
        {
            Console.WriteLine(this._name + ": File Logged, msg: " + msg + "\n");
            _mediator.Notify(msg, this);        
        }
    }

    class DBLogger : Colleague
    {
        public DBLogger(string name, Mediator mediator) : base(name, mediator){}
        public override void DBLog(string msg)
        {
            Console.WriteLine(this._name + ": DB Logged, msg: " + msg + "\n");
            _mediator.Notify(msg, this);        
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Mediator mediator = new ConcreteMediator();
            
            Colleague receiver = new Received("Received Colleague", mediator);
            Colleague verifier = new Verifying("Verifying Colleague", mediator);
            Colleague completer = new Completed("Completed Colleague", mediator);
            Colleague fileLogger = new FileLogger("FileLogger Colleague", mediator);
            Colleague dbLogger = new DBLogger("DBLogger Colleague", mediator);
            
            mediator.Add(receiver);
            mediator.Add(verifier);
            mediator.Add(completer);
            mediator.Add(fileLogger);
            mediator.Add(dbLogger);
            
            receiver.Receive("rec_status");
        }
    }
}