//Given a Binary Tree(BT), convert it to a Doubly Linked List(DLL) In-place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given binary tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL

class Node{
	int val;
	Node left;
	Node right;
	
	Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class TreeToList{

	public static Node tree_to_list(Node root){
		
		Node result = null;
		if(root != null && root.left == null && root.right == null)
			return root;
		if(root != null){
			//left and right are heads of left DLL and right DLL
			Node left = tree_to_list(root.left);	//tree to list for left subtree
			Node right = tree_to_list(root.right);	//tree to list for right subtree
			if(left != null && right != null){ 
				Node temp = left;
				while(temp.right != null)
					temp = temp.right;
				temp.right = root;
				root.left = temp;
				root.right = right;
				right.left = root;
				result = left;
				return result;
			}
			else if(left == null && right != null){
				root.right = right;
				right.left = root;
				result = root;
				return result;
			}
			else if(left != null && right == null){
				Node temp = left;
				while(temp.right != null)
					temp = temp.right;
				temp.right = root;
				root.left = temp;
				root.right = null;
				result = left;
				return result;
			}
		}
		return result;
	}
	public static void main(String[] args){

		//create the binary tree first
		Node root = new Node(10);
		root.left = new Node(12);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right = new Node(15);
		root.right.left = new Node(36);

		Node nroot = tree_to_list(root);

		Node temp = nroot;

		if(temp == null)
			System.out.println("null");

		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.right;
		}
	}
	
}
