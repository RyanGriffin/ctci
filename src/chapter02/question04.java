
// Q: Write code to partition a linked list around a given value (smaller values before, larger values after)

package chapter02;

public class question04
{
	public static LinkedListNode partition(LinkedListNode node, int val)
	{
		LinkedListNode n = node, next, smallHead = null, smallTail = null, bigHead = null, bigTail = null;
		
		while(n != null) // look through list??? need to find the condition for this...
		{
			next = n.next;
			n.next = null;
			
			if(n.data < val) // add to left side
			{
				if(smallHead == null) // initialize smallHead
					smallHead = n;
				else if(smallTail == null) // initialize smallTail
				{
					smallTail = n;
					smallHead.next = smallTail;
				}
				else // add nodes to list while maintaining smallTail
				{
					LinkedListNode prev = smallTail;
					smallTail = n;
					prev.next = smallTail;
				}
				
			}
			
			else // add to right side
			{
				if(bigHead == null)
					bigHead = n;
				else if(bigTail == null)
				{
					bigTail = n;
					bigHead.next = bigTail;
				}
				else
				{
					LinkedListNode prev = bigTail;
					bigTail = n;
					prev.next = bigTail;
				}
			}
			
			n = next;
		}
		
		smallTail.next = bigHead;
		
		return smallHead;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode head = new LinkedListNode(3, null, null);
		LinkedListNode list = new LinkedListNode(5, null, head);
		list = new LinkedListNode(8, null, head.next);
		list = new LinkedListNode(5, null, head.next.next);
		list = new LinkedListNode(10, null, head.next.next.next);
		list = new LinkedListNode(2, null, head.next.next.next.next);
		list = new LinkedListNode(1, null, head.next.next.next.next.next);
		
		System.out.println(head.printForward() + "\n\n");
		
		head = partition(head, 5);
		
		System.out.println(head.printForward());
	}
}
