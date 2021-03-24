package chapter04;
// CREATE BST WITH MINIMAL HEIGHT (i.e. height = log(n))

public class question02 {
	public static void main(String[] args)
	{
		int[] arr = new int[16];
		for(int i = 0 ; i < arr.length; i++)
			arr[i] = i + 1;
		
		Tree t = Tree.makeMinBST(arr);
		System.out.println(t.isBST());
	}
}