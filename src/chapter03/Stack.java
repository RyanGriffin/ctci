package chapter03;
import java.util.EmptyStackException;

public class Stack
{
	private static class StackNode
	{
		private int data;
		private StackNode next;
		
		public StackNode(int value)
		{
			this.data = value;
		}
	}
	
	private StackNode top;
	private StackNode minNode;
	private int capacity;
	private int count;
	private int min = Integer.MAX_VALUE;
	
	public Stack()
	{
		count = 0;
	}
	
	public Stack(int cap)
	{
		capacity = cap;
		count = 0;
	}
	
	public void push(int value)
	{
		StackNode s = new StackNode(value);
		s.next = top;
		top = s;
		if(value < min)
		{
			// how do i maintain prev min value for minPop?
			// NOT TESTED
			
			min = value;
			StackNode oldMin = minNode;
			minNode = top;
			minNode.next = oldMin;
		}
		count++;
	}
	
	public int pop()
	{
		if(top == null)
			throw new EmptyStackException();
		int val = top.data;
		top = top.next;
		return val;
	}
	
	public int peek()
	{
		if(top == null)
			throw new EmptyStackException();
		return top.data;
	}
	
	public int min()
	{
		if(minNode == null)
			throw new EmptyStackException();
		
		return minNode.data;
	}
	
	public int getSize() { return count; }
	
	public boolean isEmpty() { return top == null; }
	
	public boolean isAtCapacity() { return count == capacity; }
}
