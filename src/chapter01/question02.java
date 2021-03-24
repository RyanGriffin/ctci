
// Q: Write code to reverse a C-Style String. (C-String means that “abcde” is represented as six characters, including the null character.)

package chapter01;

public class question02
{
	public static char[] reverse(char[] c)
	{
		char[] ans = new char[c.length];
		
		for(int i = 0; i < c.length - 1; i++)
			ans[i] = c[c.length - 2 - i];
		
		return ans;
	}
	
	public static void main(String args[])
	{
		char[] c = {'a', 'b', 'c', 'd', 'e', 'n'};
		
		char[] rev = reverse(c);
		
		for(int i = 0; i < rev.length; i++)
			System.out.println(i + ": " + rev[i] + " ");
	}
}
