package chapter04;
// Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth

import java.util.LinkedList;
import java.util.ArrayList;

public class question03 {
	public static void buildList(Tree node, ArrayList<LinkedList<Tree>> list, int i)
	{
		if(node != null) { // base case
			list.get(i).add(node);
			buildList(node.left, list, i + 1);
			buildList(node.right, list, i + 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 7, 8, 6, 10, 9, 2, 1};
		Tree t = new Tree(arr[0]);
		
		for(int i = 1; i < arr.length; i++)
			t.insertInOrder(arr[i]);
		
		ArrayList<LinkedList<Tree>> list = new ArrayList<LinkedList<Tree>>();
		
		for(int i = 0; i < t.height(); i++) // set size of ArrayList...
			list.add(new LinkedList<Tree>());
		
		buildList(t, list, 0);
		
		for(int i = 0; i < t.height(); i++) {
			System.out.print("level " + (i + 1) + " -> ");
			while(list.get(i).size() != 0)
				System.out.print(list.get(i).removeFirst().data + " ");
			System.out.println();
		}
	}
}

