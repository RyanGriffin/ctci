
// Q: write a method to determine if a linked list is a palindrome

package chapter02;

import java.util.Stack;

public class question06
{
	public static boolean isPalindrome(LinkedListNode n)
	{
		LinkedListNode node = n;
		Stack<Integer> stack = new Stack<Integer>(); // used for reversing LinkedList
		
		while(node != null) // add elements to stack
		{
			stack.add(node.data);
			node = node.next;
		}
		
		node = n; // reset for comparisons
		
		while(node != null)
		{
			if(node.data != stack.pop())
				return false;
			node = node.next;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode list1 = new LinkedListNode(3, null, null); // palindrome (odd)
		LinkedListNode list2 = new LinkedListNode(2, null, null); // palindrome (even)
		LinkedListNode list3 = new LinkedListNode(1, null, null); // not a palindrome
		
		// initializing list 1
		LinkedListNode n = new LinkedListNode(1, null, list1);
		n = new LinkedListNode(5, null, list1.next);
		n = new LinkedListNode(7, null, list1.next.next);
		n = new LinkedListNode(5, null, list1.next.next.next);
		n = new LinkedListNode(1, null, list1.next.next.next.next);
		n = new LinkedListNode(3, null, list1.next.next.next.next.next);
		
		// initializing list 2
		n = new LinkedListNode(4, null, list2);
		n = new LinkedListNode(6, null, list2.next);
		n = new LinkedListNode(6, null, list2.next.next);
		n = new LinkedListNode(4, null, list2.next.next.next);
		n = new LinkedListNode(2, null, list2.next.next.next.next);
		
		// initializing list 3
		n = new LinkedListNode(2, null, list3);
		n = new LinkedListNode(3, null, list3.next);
		n = new LinkedListNode(4, null, list3.next.next);
		n = new LinkedListNode(5, null, list3.next.next.next);
		
		if(isPalindrome(list1) && isPalindrome(list2) && !isPalindrome(list3))
			System.out.println("SUCCESS");
		else
			System.out.println("ONE OF THE LISTS FAILED!\n\nlist #1: true\t" + isPalindrome(list1) + "\nlist #2: true\t" + isPalindrome(list2) + "\nlist #3: false\t" + isPalindrome(list3));
	}
}
