//Count BST subtrees that lie in given range

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

public class BST_p3{

	static int count;

	static boolean countbst(Node root, int low, int high){
		if(root != null){
			boolean rt = (root.val >= low && root.val <= high)?true:false;
			if(root.left != null && root.right != null){
				boolean l = countbst(root.left, low, high);
				boolean r = countbst(root.right, low, high);
				if(rt && l && r){
					count++;
					return true;
				}
				return false;
			}
			else if(root.left == null && root.right != null){
				boolean r = countbst(root.right, low, high);
				if(rt && r){
					count++;
					return true;
				}
				return false;
			}
			else if(root.left != null && root.right == null){
				boolean l = countbst(root.left, low, high);
				if(rt && l){
					count++;
					return true;
				}
				return false;
			}
			else{
				if(rt){
					count++;
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args){
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(1);
		root.right = new Node(50);
		root.right.left = new Node(40);
		root.right.right = new Node(100);

		int low = 1;
		int high = 45;
		count = 0;
		countbst(root, low, high);
		System.out.println(count);
	}
	
}
