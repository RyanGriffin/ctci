package chapter04;

import java.util.ArrayList;

public class GNode
{
	private int data;
	// private GNode[] adjacent;
	private ArrayList<GNode> adjacent;
	public State state;
	
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public GNode(int val)
	{
		data = val;
		adjacent = new ArrayList<GNode>();
		// adjacentCount = 0;
		// adjacent = new GNode[adLength];
	}
	
	public void addAdjacaent(GNode n)
	{
		adjacent.add(n);
		
//		if(adjacentCount < adjacent.size())
//		{
//			adjacent.add(n);
//			adjacentCount++;
//		}
//		else
//			System.out.println("No more adjacent can be added!");
	}
	
	public void removeAdjacent(GNode n)
	{
		if(adjacent.remove(n))
			return;
		else
			System.out.println("error: node not present!");
	}
	
	public ArrayList<GNode> getAdjacent()
	{ return adjacent; }
	
	public int getData()
	{ return data; }
}