
// Q1.4: Write a method to decide if two strings are anagrams

package chapter01;

public class question04
{
	public static boolean anagram(String s1, String s2)
	{
		// easiest way to do it
		// return sort(s1) == sort(s2);
			
		if(s1.length() != s2.length())
			return false;
			
		int[] letters = new int[256];
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
			
		for(int i = 0; i < c1.length; i++)
			letters[c1[i]]++;
		
		for(int i = 0; i < c2.length; i++)
		{
			if(--letters[c2[i]] < 0)
				return false;
		}		
			return true;
	}

		public static void main(String[] args)
		{
			String[][] pairs = { {"been", "neeb"}, {"toy", "toy1"}, {"hello", "yello"}, {"carrot", "tarroc"} };
			for(String[] p : pairs)
				System.out.println(p[0] + "\t" + p[1] + "\t" + anagram(p[0],p[1]));
		}
}
