// Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
// projects, where the second project is dependent on the first project). All of a project's dependencies
// must be built before the project is. Find a build order that will allow the projects to be built. If
// there is no valid build order, return an error.

// expected output: 6 5 1 2 4 3

package chapter04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class question07 {
	public static void buildOrder(int[] p, int[][] d) {
		// GNode[] g = new GNode[p.length];
		ArrayList<GNode> g = new ArrayList<GNode>();
		ArrayList<GNode> order = new ArrayList<GNode>();
		PriorityQueue<GNode> pq = new PriorityQueue<GNode>(p.length, new NodeComparator()); // stores nodes in ascending order of adjacent list size
		
		for(int i = 0; i < p.length; i++) // initialize
			g.add(new GNode(p[i]));

		for(int i = 0; i < d.length; i++) // create dependencies 
			g.get(d[i][1] - 1).addAdjacaent(g.get(d[i][0] - 1));
		
		for(int i = 0; i < p.length; i++) // add to priority queue
			pq.add(g.get(i));
			
		while(!pq.isEmpty()) {
			GNode n = pq.poll();
			if(n.getAdjacent().size() != 0) { // not possible if there's no node with no dependencies
				System.out.println("error: not possible to build!\n");
				return;
			}

			// add node to build order
			order.add(n);
			
			// remove dependencies from other nodes!
			for(int i = 0; i < g.size(); i++) {
				if(g.get(i).getAdjacent().contains(n)) {
					g.get(i).getAdjacent().remove(n);
					
					// priority queue won't resort when an element is added or removed
					// remove & add is an easy way to reorder a priority queue
					pq.remove(g.get(i));
					pq.add(g.get(i));
				}
			}
		}
		
		for(int i = 0; i < order.size(); i++)
			System.out.print(order.get(i).getData() + " ");
	}
	
	public static void main(String args[]) {
		int[] projects = {1, 2, 3, 4, 5, 6};
		int[][] dependencies = { {1, 4}, {6, 2}, {2, 4}, {6, 1}, {4, 3} };
		
		buildOrder(projects, dependencies);
	}
}

class NodeComparator implements Comparator<GNode> {
	// Overriding compare() method of Comparator for ascending order of size of adjacent list
	public int compare(GNode n1, GNode n2) {
		if(n1.getAdjacent().size() > n2.getAdjacent().size())
			return 1;
		else if(n1.getAdjacent().size() < n2.getAdjacent().size())
			return -1;
		return 0;
	}
}