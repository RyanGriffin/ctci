
// Q: Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?

package chapter01;

public class question01
{
	public static boolean isUnique(String s) // extra data
	{
		boolean[] letters = new boolean[256];
		
		for(int i = 0; i < s.length(); i++)
		{
			if(letters[s.charAt(i)])
				return false;
			letters[s.charAt(i)] = true;
		}
		
		return true;
	}
	
	public static boolean isUnique2(String s) // no extra data
	{
		for(int i = 0; i < s.length() - 1; i++)
		{
			for(int j = i + 1; j < s.length(); j++)
			{
				if(s.charAt(i) == s.charAt(j))
					return false;
			}
		}
		
		return true;
	}
	
	// change for github testing
	
	public static void main(String args[])
	{
		String Words[] = {"dawg", "dog", "doggo", "cat123", "cat122", "kitty"};
		for(int i = 0; i < Words.length; i++)
			System.out.println(Words[i] + ":\t" + isUnique(Words[i]) + "\t" + isUnique2(Words[i]));
	}
}
