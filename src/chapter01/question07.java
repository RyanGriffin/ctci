
// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.

package chapter01;

public class question07
{
	public static void setZero(int[][] m)
	{
		boolean[] rows = new boolean[m.length], cols = new boolean[m[0].length];
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[0].length; j++)
			{
				if(m[i][j] == 0)
				{
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i = 0; i < m.length; i++) // set row to zero
		{
			for(int j = 0; j < m[0].length; j++)
			{
				if(rows[i] || cols[j])
					m[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = { {1, 2, 3, 4}, {5, 6, 0, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20} };
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println("\n");
		
		setZero(matrix);
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}
