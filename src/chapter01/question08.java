
// ASSUME: you have a method isSubstring which checks if one word is a substring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
// (i.e., “waterbottle” is a rotation of “erbottlewat”).

package chapter01;

public class question08
{
	public static boolean isSubstring(String big, String small) // returns true if small is substring of big
	{
		if (big.indexOf(small) >= 0)
			return true;
		return false;
	}
	
	public static boolean isRotation(String s1, String s2)
	{
		if(s1.length() > 0 && s1.length() == s2.length())
		{
			String dub = s1 + s1;
			return isSubstring(dub, s2);
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		String[][] pairs = { {"words", "dswor"}, {"words", "sword"}, {"apple", "orange"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for(String[] pair : pairs)
			System.out.println(pair[0] + "  " + pair[1] + ":\t" + isRotation(pair[0], pair[1]));
	}
}