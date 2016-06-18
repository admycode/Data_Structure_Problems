//Sum Two numbers represented by linked list. Assumed that each number has same number of digits

class Node{
	int val;
	Node next;

	Node(int val){
		this.val = val;
		this.next = null;
	}
}

public class LinkedListSum{

	public static Node add(Node h1, Node h2){
		Node result = null;
		if(h1.next == null && h2.next == null){
			int val = h1.val + h2.val;
			if(val < 10){
				Node temp = new Node(0);
				Node temp1 = new Node(val);
				temp.next = temp1;
				return temp;
			}
			else{
				int carry = val/10;
				int num = val%10;
				Node temp = new Node(carry);
				temp.next = new Node(num);
				return temp;
			}
		}
		else{
			int val = h1.val + h2.val;

			Node s = add(h1.next, h2.next);
			val = val + s.val;
			if(val < 10){
				result = new Node(val);
				result.next = s.next;
			}
			else{
				result = new Node(val/10);
				result.next = new Node(val%10);
				result.next.next = s.next;
			}
			
		}
		return result;
	}
	public static void main(String[] args){
	
		Node head1 = new Node(3);
		head1.next = new Node(4);
		head1.next.next = new Node(8);
		head1.next.next.next = new Node(5);

		Node head2 = new Node(5);
		head2.next = new Node(7);
		head2.next.next = new Node(9);
		head2.next.next.next = new Node(1);

		Node sum = add(head1, head2);

		Node temp = sum;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
	}

}
