// Design an algorithm and write code to find the first common ancestor
// of two nodes in a binary tree. Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree.

package chapter04;

public class question08 {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 7, 8, 6, 10, 9, 2, 1};
		Tree t = new Tree(arr[0]);
		
		for(int i = 1; i < arr.length; i++)
			t.insertInOrder(arr[i]);
	}

}
