package chapter03;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks
{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	private int cap; // capacity
	
	public SetOfStacks(int capacity)
	{ cap = capacity; }
	
	public Stack getLastStack()
	{
		if(stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(int value)
	{
		Stack last = getLastStack();
		if(last != null && !last.isAtCapacity())
			last.push(value);
		else 
		{
			Stack s = new Stack(cap);
			s.push(value);
			stacks.add(s);
		}
	}
	
	public int pop()
	{
		Stack last = getLastStack();
		if(last != null)
		{
			int val = last.pop();
			if(last.getSize() == 0)
				stacks.remove(stacks.size() - 1); // remove last stack if emptied
			return val;
		}
		throw new EmptyStackException();
	}
	
	public int popAt(int index)
	{
		Stack s = stacks.get(index);
		
		if(s != null)
		{
			int val = s.pop();
			if(s.getSize() == 0)
				stacks.remove(index);
			return val;
		}
		
		throw new EmptyStackException();
	}
}
