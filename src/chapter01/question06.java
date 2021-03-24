
// Write a method to rotate an NxN martrix 90 degrees. Can you do it in place?
// flips the middle row and column when N is odd. Not sure why...

package chapter01;

public class question06
{
	public static void rotate(int[][] m)
	{
		int temp, last = m.length - 1, loopEnd = m.length/2; // last = last index
		
		if(m.length % 2 != 0)
			loopEnd++;
		
		for(int i = 0; i < loopEnd; i++)
		{
			for(int j = 0; j < loopEnd; j++)
			{
				temp = m[i][j];
				m[i][j] = m[j][last - i];
				m[j][last - i] = m[last - i][last - j];
				m[last - i][last - j] = m[last - j][i];
				m[last - j][i] = temp;
			}
		}
	}
	
	public static void main(String[] args)
	{
		// int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
		// int[][] matrix = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20} , {21, 22, 23, 24, 25} };
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println();
		
		rotate(matrix);
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}
