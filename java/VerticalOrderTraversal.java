//This program implements vertical order traversal of a binary tree

import java.util.*;

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

public class VerticalOrderTraversal{

	static TreeMap<Integer, LinkedHashSet<Integer>> Map;

	public static void verticaltraversal(Node root, int id){

		if(Map.get(id) == null){
			LinkedHashSet<Integer> S = new LinkedHashSet<Integer>();
			S.add(root.val);
			Map.put(id, S);
		}
		else{
			Map.get(id).add(root.val);
		}

		if(root.left != null && root.right != null){
			verticaltraversal(root.left, id+1);
			verticaltraversal(root.right, id-1);
		}
		else if(root.left == null && root.right != null){
			verticaltraversal(root.right, id-1);
		}
		else if(root.left != null && root.right == null){
			verticaltraversal(root.left, id+1);
		}
	}
	
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.left.right = new Node(8);
		root.right.right = new Node(7);
		root.right.right.right = new Node(9);

		Map = new TreeMap<Integer, LinkedHashSet<Integer>>(Collections.reverseOrder());

		verticaltraversal(root,0);

		for(int id : Map.keySet()){
			System.out.println(id + " " + Map.get(id));
		}
	}

}
