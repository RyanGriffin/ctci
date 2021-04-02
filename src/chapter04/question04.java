// Q04: Implement a function to check if a binary tree is balanced. For the purposes
// of this question, a balanced tree is defined to be a tree such that the heights of the
// two subtrees of any node never differ by more than one.

// Q05: Implement a function to check if a binary tree is a binary search tree.

package chapter04;

public class question04 { // also includes question 5
	public static void main(String[] args) {
		int[] arr1 = {4, 2, 6, 1, 5, 3, 7}; // balanced (also a BST)
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7}; // unbalanced
		Tree t1 = new Tree(arr1[0]); // balanced and BST
		Tree t2 = new Tree(arr2[0]); // unbalanced and not BST
		t2.setLeft(new Tree(8)); // makes t2 not a BST
		
		for(int i = 1; i < 7; i++) {
			t1.insert(arr1[i]);
			t2.insert(arr2[i]);
		}
		
		if(t1.isBalanced() && t1.isBST() && !t2.isBalanced() && !t2.isBST())
			System.out.println("it works!");
	}
}
