package chapter04;
// NODE FOR A BINARY TREE!

public class Tree
{
	public int data;
	// public BNode[] children;
	public Tree left;
	public Tree right;
	public Tree parent;
	public boolean visited = false;
	
	public Tree(int value) {
		data = value;
	}
	
	public void setLeft(Tree n) {
		left = n;
		if(n != null)
			n.parent = this;
	}
	
	public void setRight(Tree n) {
		right = n;
		if(n != null)
			n.parent = this;
	}
	
	public void insertInOrder(int d) {
		if(d <= data) // insert on left
		{
			if(left == null)
				setLeft(new Tree(d));
			else
				left.insertInOrder(d);
		}
		else // insert on right
		{
			if(right == null)
				setRight(new Tree(d));
			else
				right.insertInOrder(d);
		}
	}
	
	// overload to insert with node
	public void insertInOrder(Tree n) {
		if(n.data <= data) // insert on left
		{
			if(left == null)
				setLeft(n);
			else
				left.insertInOrder(n);
		}
		else // insert on right
		{
			if(right == null)
				setRight(n);
			else
				right.insertInOrder(n);
		}
	}
	
	public int height()
	{
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		
		return 1 + Math.max(leftHeight, rightHeight);
		
//		int lHeight = 0, rHeight = 0;
//		if(left != null)
//			lHeight = left.height();
//		if(right != null)
//			rHeight = right.height();
//		return 1 + Math.max(lHeight, rHeight);
	}
	
	public boolean isBalanced() { // question 4
		if((left == null && right.height() > 1) || (right == null && left.height() > 1)) // accounts for one side of tree being empty (can't call left.height() if left is null)
			return false;
		if(Math.abs(left.height() - right.height()) > 1)
			return false;
		return true;
	}
	
	
	public boolean isBST() { // question 5
		if(left != null && (data < left.data || !left.isBST())) // return false if data on left is larger, or left is not a BST...
			return false;
		if(right != null && (data >= right.data || !right.isBST())) // return false if data on right is smaller, or right is not a BST...
			return false;
		return true;
	}
	
	public Tree findSuccessor() { // question 6
		if(right == null) // CASE 1: no larger elements means no successor
			return null;
		
		if(right.left == null) // CASE 2: no left child of root's right child means there's no smaller nodes
			return right;
		
		Tree t = right.left; // CASE 3: iterate down the left children of root's right child (smallest node after root)
		while(t.left != null)
			t = t.left;
		return t;
	}
	
	public Tree find(int d) // only finds first instance of node with given value
	{
		if(data == d)
			return this;
		if(data < d && left != null) // <= not needed
			return left.find(d);
		if(data > d && right != null)
			return right.find(d);
		return null;
	}
	
	public static Tree makeTree(int[] arr, int start, int end)
	{
		if(end < start)
			return null;
		
		int mid = (start + end) / 2;
		
		Tree root = new Tree(arr[mid]);
		root.setLeft(makeTree(arr, start, mid - 1));
		root.setRight(makeTree(arr, mid + 1, end));
		
		return root;
	}
	
	public static Tree makeMinBST(int[] arr)
	{ return makeTree(arr, 0, arr.length - 1); }
}
