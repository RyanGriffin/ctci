// A binary search tree was created by traversing through an array from left to right
// and inserting each element. Given a binary search tree with distinct elements, print
// all possible arrays that could have led to this tree.

package chapter04;

import java.util.ArrayList;
import java.util.LinkedList;

public class question09 {
	public static ArrayList<LinkedList<Integer>> sequences(Tree t) {
		ArrayList<LinkedList<Integer>> seq = new ArrayList<LinkedList<Integer>>();
		
		if(t == null) { // base case
			seq.add(new LinkedList<Integer>());
			return seq;
		}
		
		// prefix has to be LinkedList for weave to work -> we add to prefix
		// initialized before left/right because they're declared using prefix
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(t.data);
		
		ArrayList<LinkedList<Integer>> left = sequences(t.left);
		ArrayList<LinkedList<Integer>> right = sequences(t.right);
		
		// "weave" lists together
		for(LinkedList<Integer> l : left) {
			for(LinkedList<Integer> r : right) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weave(l, r, prefix, weaved);
				seq.addAll(weaved);
			}
		}
		
		return seq;
	}
	
	// merges arrays in all possible ways, but keeps elements from each array in relative order
	// accounts for subtrees being built out of order (i.e. left node inserted, then right now, then child of left)
	public static void weave(LinkedList<Integer> l, LinkedList<Integer> r, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> lists) {
		if(l.size() == 0 || r.size() == 0) { // base case
			@SuppressWarnings("unchecked")
			LinkedList<Integer> p = (LinkedList<Integer>) prefix.clone(); // not sure why i have to type cast...
			p.addAll(l);
			p.addAll(r);
			lists.add(p);
		}
		else { // recursion -> remove first element and try again
			prefix.add(l.removeFirst());
			weave(l, r, prefix, lists);
			l.addFirst(prefix.removeLast()); // need to reset
			
			prefix.add(r.removeFirst());
			weave(l, r, prefix, lists);
			r.addFirst(prefix.removeLast()); // need to reset
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 2};
		
		ArrayList<LinkedList<Integer>> result = sequences(new Tree(arr));
		
		for(LinkedList<Integer> sequence : result) {
			for(int data : sequence)
				System.out.print(data + " ");
			System.out.println();
		}
	}
}