package chapter04;
public class GNode
{
	private int data;
	private GNode[] adjacent;
	private int adjacentCount;
	public State state;
	
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public GNode(int val, int adLength)
	{
		data = val;
		adjacentCount = 0;
		adjacent = new GNode[adLength];
	}
	
	public void addAdjacaent(GNode n)
	{
		if(adjacentCount < adjacent.length)
		{
			adjacent[adjacentCount] = n;
			adjacentCount++;
		}
		else
			System.out.println("No more adjacent can be added!");
	}
	
	public GNode[] getAdjacent()
	{ return adjacent; }
	
	public int getData()
	{ return data; }
}