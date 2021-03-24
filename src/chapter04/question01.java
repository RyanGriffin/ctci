package chapter04;
import java.util.LinkedList;

public class question01 {	
	public static Graph createNewGraph(int n)
	{
		Graph g = new Graph(n);
		GNode[] temp = new GNode[n];
		
		temp[0] = new GNode(1, 3);
		temp[1] = new GNode(2, 0);
		temp[2] = new GNode(3, 0);
		temp[3] = new GNode(4, 1);
		temp[4] = new GNode(5, 1);
		temp[5] = new GNode(6, 0);
		
		temp[0].addAdjacaent(temp[1]);
		temp[0].addAdjacaent(temp[2]);
		temp[0].addAdjacaent(temp[3]);
		temp[3].addAdjacaent(temp[4]);
		temp[4].addAdjacaent(temp[5]);
		
		for(int i = 0; i < temp.length; i++)
			g.addNode(temp[i]);
		
		return g;
	}
	
	public static boolean search(Graph graph, GNode start, GNode end) {
		LinkedList<GNode> q = new LinkedList<GNode>(); // used as a queue
		
		for(GNode n : graph.getNodes())
			n.state = GNode.State.Unvisited;
		
		start.state = GNode.State.Visiting;
		q.add(start);
		GNode n;
		
		while(!q.isEmpty()) {
			n = q.removeFirst();
			if(n != null) {
				for(GNode g : n.getAdjacent()) {
					if(g.state == GNode.State.Unvisited) {
						if(g == end)
							return true;
						else {
							g.state = GNode.State.Visiting;
							q.add(g);
						}
					}
				}
				n.state = GNode.State.Visited;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = createNewGraph(6); // has to have 6 as input
		GNode[] nodes = g.getNodes();
		// GNode start = nodes[3], end = nodes[5];
		System.out.println(search(g, nodes[0], nodes[5])); // true
		System.out.println(search(g, nodes[2], nodes[5])); // false
	}
}