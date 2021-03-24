
// determine if the two lists intersect. Return the intersecting node.

package chapter02;

public class question07
{
	public static LinkedListNode intersection(LinkedListNode l1, LinkedListNode l2)
	{
		LinkedListNode list1 = l1, list2 = l2;
		
		while(list1 != null)
		{
			while(list2 != null)
			{
				if(list1 == list2)
					return list1;
				list2 = list2.next;
			}
			list2 = l2;
			list1 = list1.next;
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode[] inter = new LinkedListNode[3];
		LinkedListNode[] list1 = new LinkedListNode[5];
		LinkedListNode[] list2 = new LinkedListNode[5];
		
		for (int i = 0; i < 3; i++)
			inter[i] = new LinkedListNode(i + 5, null, i > 0 ? inter[i - 1] : null); // 5 -> 6 -> 7
		for(int i = 0; i < 5; i++)
		{
			list1[i] = new LinkedListNode(i, null, i > 0 ? list1[i - 1] : null); // 0 -> 1 -> 2 -> 3 -> 4
			list2[i] = new LinkedListNode(10 - i, null, i > 0 ? list2[i - 1] : null); // 10 -> 9 -> 8 -> 7 -> 6
		}
		
		list1[4].next = inter[0];
		list2[4].next = inter[0];
		
		if(intersection(list1[0], list2[0]) == inter[0])
			System.out.println("Intersection found at node with key: " + intersection(list1[0], list2[0]).data);
		else
			System.out.println("ERROR: Intersection not found!");
	}
}
