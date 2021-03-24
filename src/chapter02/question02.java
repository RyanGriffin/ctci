
// Implement an algorithm to find the nth to last element of a singly linked list.
// ASSUME: elements are positive integers (for simplicity's sake)

package chapter02;

import java.util.*;

public class question02
{
	public static int nthToLast(LinkedListNode head, int n)
	{
		if(n < 1)
			return -1; // error code
		
		LinkedListNode p1 = head, p2 = head;

		for(int i = 0; i < n; i++) // move p1 forward n squares
		{
			if(p1 != null)
				p1 = p1.next;
			else
				return -1; // error code
		}
		
		while(p1 != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2.data;
	}
	
	public static void main(String[] args)
	{	
		LinkedListNode list = new LinkedListNode(1, null, null);
		LinkedListNode prev = list;
		
		for(int i = 2; i < 7; i++)
		{
			LinkedListNode next = new LinkedListNode(i, null, null);
			prev.next = next;
			prev = next;
		}
		
		System.out.println(list.printForward() + "\n");
		
		Scanner in = new Scanner(System.in);
		System.out.print("Which element are you looking for? (nth to last): ");
		int pos = in.nextInt();
		int ans = nthToLast(list, pos);
		if(ans > -1)
			System.out.println("\nYou've selected position " + pos + ": -> " + ans);
		else
			System.out.println("\nYou've selected position " + pos + ": -> NULL");
	}
}
