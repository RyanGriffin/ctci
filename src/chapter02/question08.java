
// Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
// ASSUME: All elements are greater than or equal to zero --> -1 is error code

package chapter02;

public class question08
{
	
	public static LinkedListNode findLoop(LinkedListNode node)
	{
		LinkedListNode n1 = node.next, n2 = node.next.next;
		
		while(n2.next != null && n1 != n2) // find meeting point
		{
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		if(n2.next == null) // if n2.next is null, there is no loop
			return null;
		
		n1 = node; // move n1 to start, n2 stays at meeting point
		while(n1 != n2) // both pointers are equal distance away from loop root, so iterate until equal
		{
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n2;
	}
	
	public static void main(String[] args)
	{	
		LinkedListNode[] nodes = new LinkedListNode[10];
		
		for (int i = 0; i < 10; i++)
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		
		nodes[9].next = nodes[3];
		
		System.out.println("Loop found at node with key: " + findLoop(nodes[0]).data);
	}
}
