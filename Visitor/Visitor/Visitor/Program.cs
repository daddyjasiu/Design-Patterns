namespace Visitor
{
    class Program
    {
        static void Main(string[] args)
        {
            List<IAutoPart> components = new List<IAutoPart>
            {
                new ElectricalPart(),
                new SuspentionPart(),
                new BodyPart(),
            };

            var visitor1 = new ConcreteVisitor1();
            Client.ClientCode(components, visitor1);

            Console.WriteLine();

            var visitor2 = new ConcreteVisitor2();
            Client.ClientCode(components, visitor2);
        }
    }
}