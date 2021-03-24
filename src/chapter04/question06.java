package chapter04;

public class question06 { // question 5 is included in question04.java
	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 7, 8, 6, 10, 9, 2, 1};
		Tree t = new Tree(arr[0]);
		
		for(int i = 1; i < arr.length; i++)
			t.insertInOrder(arr[i]);
		
		System.out.println(t.findSuccessor().data);
	}
}