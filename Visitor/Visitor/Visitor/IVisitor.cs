using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor
{
    public interface IVisitor
    {
		void VisitConcreteComponentA(ElectricalPart part);
        void VisitConcreteComponentB(SuspentionPart part);
        void VisitConcreteComponentC(BodyPart part);
    }

    class ConcreteVisitor1 : IVisitor
    {
        public void VisitConcreteComponentA(ElectricalPart element)
        {
            element.SpecialMethod();
            Console.WriteLine("ConcreteVisitor1");
        }

        public void VisitConcreteComponentB(SuspentionPart element)
        {
            element.SpecialMethod();
            Console.WriteLine("ConcreteVisitor1");
        }

        public void VisitConcreteComponentC(BodyPart element)
		{
            element.SpecialMethod();
            Console.WriteLine("ConcreteVisitor1");
        }
    }

    class ConcreteVisitor2 : IVisitor
    {
        public void VisitConcreteComponentA(ElectricalPart element)
        {
            element.SpecialMethod();
            Console.WriteLine("ConcreteVisitor2");
        }

        public void VisitConcreteComponentB(SuspentionPart element)
        {
            element.SpecialMethod();
            Console.WriteLine("ConcreteVisitor2");
        }

        public void VisitConcreteComponentC(BodyPart element)
        {
            element.SpecialMethod();
            Console.WriteLine("ConcreteVisitor2");
        }
    }
}
