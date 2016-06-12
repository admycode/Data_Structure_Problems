//reverse a linked list

class Node{
	Node(int val){
		value = val;
		next = null;
	}
	public int value;
	public Node next;
}

public class reverseList{

	static Node reverse(Node head){
		
		if(head == null || head.next == null)
			return head;
		Node second = head.next;
		head.next = null;

		Node rest = reverse(second);
		second.next = head;

		return rest;
	}	
	
	static void print(Node head){
		Node temp;
		temp = head;
		while(temp.next != null){
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.print(temp.value);
		System.out.println();
	}
	public static void main(String[] args){
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		System.out.println("Before reversal");
		print(head);

		head = reverse(head);
		
		System.out.println("After reversal");
		print(head);
	}
}
