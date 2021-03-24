package chapter04;
//  GRAPH

public class Graph
{
	public int count;
	public GNode[] vertices;
	
	public Graph(int n)
	{
		vertices = new GNode[n];
		count = 0;
	}
	
	public void addNode(GNode n)
	{
		if(count < vertices.length)
		{
			vertices[count] = n;
			count++;
		}
		else
			System.out.println("Graph is full!");
	}
	
	public GNode[] getNodes()
	{ return vertices; }
}