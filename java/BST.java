//Complete implementation of Binary Search Tree (BST)

//Structure of a node in BST
class Node{
	int value;
	Node left;
	Node right;
	Node p;
	Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
		this.p = null;
	}
}

public class BST{
	private static Node root; 
	public BST(){
		root = null;
	}

	//Insert a node with input value in BST
	public void insert(int v){
		Node node = new Node(v);
		if(root == null){
			root = node;
		}
		else{
			Node x = root;
			Node y = null;
			while(x != null){
				y = x;
				if(v < x.value){
					x = x.left;
				}
				else if(v > x.value){
					x = x.right;
				}
			}
			node.p = y;
			if(v > y.value)
				y.right = node;
			else
				y.left = node;

		}
	}

	//Return a node in BST with given value	
	public Node getNode(int v){
		if(root == null)
			return null;
		else{
			Node x = root;
			while(x != null && x.value != v){
				if(v > x.value)
					x = x.right;
				else
					x = x.left;
			}
			return x;
		}
	}

	//Recursive inorder traversal
	public void inorder(Node root){
		
		if(root != null){
			inorder(root.left);
			System.out.print(root.value + " ");
			inorder(root.right);
		}
	}
	
	public void transplant(Node x, Node y){
		if(x.p == null)
			root = y;
		else if(x == x.p.right)
			x.p.right = y;
		else
			x.p.left = y;
		if(y != null)
			y.p = x.p;
	}

	//Minimum value node in tree rooted at r
	public Node tree_minimum(Node r){
		Node x = r;
		while(x.left != null){
			x = x.left;
		}
		return x;
	}

	//return successor of a node in BST
	public Node successor(Node x){

		if(x.right != null)
			return tree_minimum(x.right);
		Node y = x.p;
		while(y != null && x == y.right){
			x = y;
			y = y.p;
		}
		return y;
	}

	//Delete a node from BST
	public void delete(int v){
		
		Node z = getNode(v);
		if(z == null)
			System.out.println("Node does not exists");
		else if(z.left == null)
			transplant(z, z.right);
		else if(z.right == null)
			transplant(z, z.left);
		else{
			Node y = successor(z);
			if(z == y.p){
				transplant(z,y);
				y.left = z.left;
				z.left.p = y;
			}
			else if(z != y.p){
				transplant(y, y.right);
				y.right = z.right;
				y.right.p = y;
				transplant(z,y);
				y.left = z.left;
				y.left.p = y;
			}
		}
	}

	public static void main(String[] args){

		BST t = new BST();

		System.out.println("Inserting 15 6 18 3 7 17 20 2 4 13 9");
		t.insert(15);
		t.insert(6);
		t.insert(18);
		t.insert(3);
		t.insert(7);
		t.insert(17);
		t.insert(20);
		t.insert(2);
		t.insert(4);
		t.insert(13);
		t.insert(9);

		System.out.println("Inorder Traversal");
		t.inorder(root);
		System.out.println();

		System.out.println("Delete node 7");
		t.delete(7);

		System.out.println("Delete node 25");
		t.delete(25);

		System.out.println("inorder");
		t.inorder(root);
		System.out.println();

		System.out.println("Delete node 6");
		t.delete(6);
	
		System.out.println("inorder");
		t.inorder(root);
		System.out.println();
	}
}
