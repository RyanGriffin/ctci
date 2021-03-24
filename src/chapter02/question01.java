
// Write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

package chapter02;

import java.util.*;

public class question01
{
	
	public static void removeDupes(LinkedListNode n)
	{
		Hashtable<Integer, Boolean> set = new Hashtable<Integer, Boolean>();
		LinkedListNode prev = null;
		
		while(n != null)
		{
			if(set.containsKey(n.data))
				prev.next = n.next;
			else
			{
				set.put(n.data, true);
				prev = n;
			}
			n = n.next;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedListNode list = new LinkedListNode(9, null, null);
		LinkedListNode prev = list;
		
		LinkedListNode next = new LinkedListNode(8, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(7, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(6, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(6, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(1, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(2, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(3, null, null);
		prev.setNext(next);
		prev = next;
		
		next = new LinkedListNode(4, null, null);
		prev.setNext(next);
		prev = next;
		
		// 9 8 7 6 6 1 2 3 4 4
		
//		next = new LinkedListNode(3, null, null);
//		prev.setNext(next);
//		prev = next;
		
//		next = new LinkedListNode(5, null, null);
//		prev.setNext(next);
//		prev = next;
		
//		for(int i = 2; i < 5; i++)
//		{
//			next = new LinkedListNode(i, null, null);
//			prev.setNext(next);
//			prev = next;
//		}
//		
//		next = new LinkedListNode(3, null, null);
//		prev.setNext(next);
//		prev = next;
//		next = new LinkedListNode(4, null, null);
//		prev.setNext(next);
//		prev = next;
//		
//		for(int i = 5; i < 8; i++)
//		{
//			next = new LinkedListNode(i, null, null);
//			prev.setNext(next);
//			prev = next;
//		}
		
		System.out.println(list.printForward());
		
		removeDupes(list);
		
		System.out.println("\n\n" + list.printForward());
	}
}
