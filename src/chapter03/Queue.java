package chapter03;
import java.util.EmptyStackException;

public class Queue
{
	private static class QNode
	{
		private int data;
		private QNode next;
		
		public QNode(int value)
		{ data = value; }
	}
	
	private QNode first, last;
	
	public int pop()
	{
		if(first == null)
			throw new EmptyStackException();
		
		int val = first.data;
		first = first.next;
		
		if(first == null)
			last = null;
		
		return val;
	}
	
//	public String dequeueDog() // question 3.6!
//	{
//		if(first == null)
//			return "the pound is empty!";
//		
//		Node n = first; // use temp node to maintain front of queue
//		while(n.type != "DOG") n = n.next; // iterate until we find a dog...
//		{
//			n = n.next;
//		}
//		
//		if(n == null)
//			return "no dogs available";
//		
//		String name = n.data;
//		n = n.next;
//		
//		return name;
//	}
	
	public void push(int val)
	{
		QNode node = new QNode(val);
		
		if(last != null)
			last.next = node;
		
		last = node;
		
		if(first == null)
			first = last;
	}
	
	public int peek()
	{
		if(first == null)
			throw new EmptyStackException();
		return first.data;
	}
}
