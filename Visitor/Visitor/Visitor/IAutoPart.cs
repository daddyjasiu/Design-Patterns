using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor
{
	public interface IAutoPart
	{
		void FabricationCost();
		void FabricationTime();
		void AvgUsageTime();
		void YearlyCost();
		void Accept(IVisitor visitor);
	}

	public class ElectricalPart : IAutoPart
	{
		public void Accept(IVisitor visitor)
		{
			visitor.VisitConcreteComponentA(this);
		}
		public void SpecialMethod()
		{
			FabricationCost();
			FabricationTime();
			AvgUsageTime();
			YearlyCost();
		}
		public void AvgUsageTime()
		{
			Console.WriteLine("ElectricalPart AvgUsageTime: {0}", 1);
		}

		public void FabricationCost()
		{
			Console.WriteLine("ElectricalPart FabricationCost: {0}", 10);
		}

		public void FabricationTime()
		{
			Console.WriteLine("ElectricalPart FabricationTime: {0}", 100);
		}

		public void YearlyCost()
		{
			Console.WriteLine("ElectricalPart YearlyCost: {0}", 1000);
		}
	}

	public class SuspentionPart : IAutoPart
	{
		public void Accept(IVisitor visitor)
		{
			visitor.VisitConcreteComponentB(this);
		}
		public void SpecialMethod()
		{
			FabricationCost();
			FabricationTime();
			AvgUsageTime();
			YearlyCost();
		}
		public void AvgUsageTime()
		{
			Console.WriteLine("SuspentionPart AvgUsageTime: {0}", 2);
		}

		public void FabricationCost()
		{
			Console.WriteLine("SuspentionPart FabricationCost: {0}", 20);
		}

		public void FabricationTime()
		{
			Console.WriteLine("SuspentionPart FabricationTime: {0}", 200);
		}

		public void YearlyCost()
		{
			Console.WriteLine("SuspentionPart YearlyCost: {0}", 2000);
		}
	}

	public class BodyPart : IAutoPart
	{
		public void Accept(IVisitor visitor)
		{
			visitor.VisitConcreteComponentC(this);
		}
		public void SpecialMethod()
		{
			FabricationCost();
			FabricationTime();
			AvgUsageTime();
			YearlyCost();
		}
		public void AvgUsageTime()
		{
			Console.WriteLine("BodyPart AvgUsageTime: {0}", 3);
		}

		public void FabricationCost()
		{
			Console.WriteLine("BodyPart FabricationCost: {0}", 30);
		}

		public void FabricationTime()
		{
			Console.WriteLine("BodyPart FabricationTime: {0}", 300);
		}

		public void YearlyCost()
		{
			Console.WriteLine("BodyPart YearlyCost: {0}", 3000);
		}
	}
}
