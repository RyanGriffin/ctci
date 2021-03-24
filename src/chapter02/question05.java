package chapter02;

public class question05
{
	public static LinkedListNode addition(LinkedListNode n1, LinkedListNode n2)
	{
		LinkedListNode ans = new LinkedListNode(0, null, null), prev = ans;
		int carried = 0;
		
		ans.data = (n1.data + n2.data + carried) % 10;
		carried = ans.data/10;
		n1 = n1.next;
		n2 = n2.next;
		
		while(n1 != null &&  n2 != null)
		{
			LinkedListNode next = new LinkedListNode((n1.data + n2.data + carried) % 10, null, null);
			carried = (n1.data + n2.data + carried) / 10;
			prev.next = next;
			prev = next;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		// EXCEPTION: list1 longer than list2
		if(n1 != null)
		{
			LinkedListNode next = new LinkedListNode((n1.data + carried) % 10, null, null);
			carried = 0;
			n2 = n1.next;
			
			while(n1 != null)
			{
				next = new LinkedListNode(n1.data, null, null);
				prev.next = next;
				prev = next;
				n1 = n1.next;
			}
		}
		
		// EXCEPTION: list2 longer than list1
		if(n2 != null)
		{
			LinkedListNode next = new LinkedListNode((n2.data + carried) % 10, null, null);
			carried = 0;
			n2 = n2.next;
			
			while(n2 != null)
			{
				next = new LinkedListNode(n2.data, null, null);
				prev.next = next;
				prev = next;
				n2 = n2.next;
			}
		}
		
		// EXCEPTION: lists finished, but number still carried
		if(n1 == null & n2 == null && carried > 0)
		{
			LinkedListNode next = new LinkedListNode(carried, null, null);
			prev.next = next;
			prev = next;
		}
		
		return ans;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode list1 = new LinkedListNode(3, null, null);
		LinkedListNode list2 = new LinkedListNode(5, null, null);
		
		// fill list 1
		LinkedListNode n = new LinkedListNode(1, null, list1);
		n = new LinkedListNode(5, null, list1.next);
		n = new LinkedListNode(5, null, list1.next.next);
		
		// fill list 2
		n = new LinkedListNode(9, null, list2);
		n = new LinkedListNode(2, null, list2.next);
		n = new LinkedListNode(5, null, list2.next.next);
		
		System.out.println("  " + list1.printForward() + "\n+ " + list2.printForward() + "\n----------------\n  " + addition(list1, list2).printForward());
	}

}
