package chapter03;
// import Stack;

// Describe how you can use a single array to implement three stacks

public class question01
{
	public static int[] tripleStack(Stack s1, Stack s2, Stack s3, int size)
	{
		int[] stack = new int[size * 3];
		
		for(int i = 0; i < size; i++)
		{
			if(s1 != null)
				stack[i] = s1.pop();
			if(s2 != null)
				stack[i + size] = s2.pop();
			if(s3 != null)
				stack[i + size*2] = s3.pop();
		}
		
		return stack;
	}
	
	public static void main(String[] args)
	{
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Stack stack3 = new Stack();                                                                       
		
		for(int i = 3; i > 0; i--)
		{
			
			stack1.push(i);
			stack2.push(i+3);
			stack3.push(i+6);
		}
		
		int[] combined = tripleStack(stack1, stack2, stack3, 3);
		
		for(int i = 0; i < combined.length; i++)
			System.out.print(combined[i] + " ");
	}
}