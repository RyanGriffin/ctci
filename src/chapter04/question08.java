// Design an algorithm and write code to find the first common ancestor
// of two nodes in a binary tree. Avoid storing additional nodes in a data structure.
// The first common ancestor is the deepest node such that p and q are both descendants.
// NOTE: This is not necessarily a binary search tree.

package chapter04;

public class question08 {
	
	public static Tree ancestor(Tree p, Tree q) {
		if(p.parent == q.parent)
			return p.parent;
		
		// THIS CODE HANDLES NODES AT UNEVEN DEPTHS
		if(p.depth() > q.depth()) {
			for(int i = 0; i < p.depth() - q.depth(); i++) // move p up to same depth as q
				p = p.parent;
			return ancestor(p, q);
		}
		if(p.depth() < q.depth()) {
			for(int i = 0; i < q.depth() - p.depth(); i++) // move q up to same depth as p
				q = q.parent;
			return ancestor(p, q);
		}
		
		// if both p and q aren't the root, we can just move up
		if(p.parent != null && q.parent != null)
			return ancestor(p.parent, q.parent);
		
		return null; // no parent found
	}

	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 8, 6, 10, 11, 12, 13};

		Tree t = new Tree(arr[0]);
		
		for(int i = 1; i < arr.length; i++)
			t.insertInOrder(arr[i]);
		
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(3);
		Tree t3 = new Tree(7);
		Tree t4 = new Tree(9);
		Tree t5 = new Tree(14);
		
		t.insertInOrder(t1);
		t.insertInOrder(t2);
		t.insertInOrder(t3);
		t.insertInOrder(t4);
		t.insertInOrder(t5);
		
		// test case 1: same depths, ancestor is root
		// test case 2: different depths, ancestor is root
		// test case 3: same depths, ancestor is not root
		// test case 4: different depths, ancestor is not root
		if(ancestor(t2, t4).data == 5 && ancestor(t1, t3).data == 5 && ancestor(t3, t4).data == 8 && ancestor(t4, t5).data == 10)
			System.out.println("test cases pass!");
		else
			System.out.println("error!");
	}
}
