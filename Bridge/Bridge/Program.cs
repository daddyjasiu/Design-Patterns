using System;
using System.Threading.Channels;

namespace Program
{
    class DateFormat
    {
        protected IOutputFile _implementation;
        
        public DateFormat(IOutputFile implementation)
        {
            _implementation = implementation;
        }

        public virtual void Operation() {}
    }
    class XMLDateFormat : DateFormat
    {
        public XMLDateFormat(IOutputFile implementation) : base(implementation){}

        public override void Operation()
        {
            base._implementation.writeXML();
        }
    }

    class CSVDateFormat : DateFormat
    {
        public CSVDateFormat(IOutputFile implementation) : base(implementation){}
        public override void Operation()
        {
            base._implementation.writeCSV();
        }
    }
    
    class FIXEDDateFormat : DateFormat
    {
        public FIXEDDateFormat(IOutputFile implementation) : base(implementation){}
        public override void Operation()
        {
            base._implementation.writeFIXED();
        }
    }
    public interface IOutputFile
    {
        void writeXML();
        void writeCSV();
        void writeFIXED();
    }
    class ConcreteImplementationA : IOutputFile
    {
        private string _y;
        private string _m;
        private string _d;
        public ConcreteImplementationA(string y, string m, string d)
        {
            _y = y;
            _m = m;
            _d = d;
        }
        public void writeXML()
        {
            Console.WriteLine("<XML> {0}/{1}/{2}", _d, _m, _y);
        }

        public void writeCSV()
        {
            Console.WriteLine("<CSV> {0}/{1}/{2}", _d, _m, _y);
        }

        public void writeFIXED()
        {
            Console.WriteLine("<FIXED> {0}/{1}/{2}", _d, _m, _y);
        }
    }
    class ConcreteImplementationB : IOutputFile
    {
        private string _y;
        private string _m;
        private string _d;
        public ConcreteImplementationB(string y, string m, string d)
        {
            _y = y;
            _m = m;
            _d = d;
        }
        public void writeXML()
        {
            Console.WriteLine("<XML> {0}/{1}/{2}", _y, _m, _d);
        }

        public void writeCSV()
        {
            Console.WriteLine("<CSV> {0}/{1}/{2}", _y, _m, _d);
        }

        public void writeFIXED()
        {
            Console.WriteLine("<FIXED> {0}/{1}/{2}", _y, _m, _d);
        }
    }
    class Client
    {
        public void ClientCode(DateFormat dateFormat)
        {
            dateFormat.Operation();
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Client client = new Client();

            client.ClientCode(new XMLDateFormat(
                new ConcreteImplementationB(
                    "2021", "11", "26"
                    )
                )
            );
        }
    }
}