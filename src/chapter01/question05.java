
// Write a method to replace all spaces in a string with "%20"

package chapter01;

public class question05
{
	public static String replace(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == ' ')
				s = s.substring(0,i) + "%20" + s.substring(i+1);
		}
		return s;
	}
	
	public static void main(String[] args)
	{
		String s = "yo yo yo whats up dawg?!";
		System.out.println(s + ":\t" + replace(s));
	}
}
