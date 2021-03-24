
/*
Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer. NOTE: One or two additional variables are fine.
An extra copy of the array is not.
FOLLOW UP
Write the test cases for this method. */



// CANT HANDLE NULL STRING!!!

package chapter01;

public class question03
{
	public static String removeDupes(String s)
	{
		String ans = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			ans += s.charAt(i);
			for(int j = i + 1; j < s.length(); j++)
			{
				if(s.charAt(i) == s.charAt(j)) // remove dupe at j
				{
					s = s.substring(0,j) + s.substring(j + 1);
					j--;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String args[])
	{
		String s = "helloiloveyoudude";
		System.out.println(s + ":\t" + removeDupes(s));
	}
}
