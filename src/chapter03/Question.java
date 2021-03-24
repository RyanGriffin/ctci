package chapter03;

public class Question
{
	public static void main(String[] args)
	{
		SetOfStacks stack = new SetOfStacks(4);
		
		for(int i = 12; i > 0; i--)
			 stack.push(i);
		
		System.out.print(stack.popAt(1) + " ");
		
		for(int i = 0; i < 11; i++)
			System.out.print(stack.pop() + " ");
	}
}