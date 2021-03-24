
// Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.

package chapter02;

public class question03
{
	public static void removeNode(LinkedListNode n)
	{
		if(n != null)
		{
			if(n.next == null)
				n = null;
			else
			{
				n.data = n.next.data;
				n.next = n.next.next;
			}
		}
	}

	public static void main(String[] args)
	{
		LinkedListNode list = new LinkedListNode(1, null, null);
		LinkedListNode prev = list;
		
		for(int i = 2; i < 6; i++)
		{
			LinkedListNode next = new LinkedListNode(i, null, null);
			prev.next = next;
			prev = next;
		}
		
		System.out.println(list.printForward() + "\n");

		removeNode(list.next.next);
		
		System.out.print(list.printForward());
	}
}
