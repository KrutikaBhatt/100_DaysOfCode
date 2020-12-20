import java.util.LinkedList;
import java.util.Queue;

/*
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
Given the root to a binary tree, count the number of unival subtrees.
For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 
 */


/* As per the question - We need to write a function with takes a tree input and return the number of 
 * Non-Empty Universal Tree that can be formed
 * Unival Tree - All nodes have same value
 
       3
      / \
     3   3
  
  The below Solution has Time Complexity - O(n)
 */

public class Day12 {
	
	// Basic structure of all the nodes in the tree
	static class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
			left = null;
			right = null;
		}
		
		// Method for Insertion in binary Trees
		public static void insert (Node root ,int value) {
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node temp = queue.element();
				queue.remove();
				
				if(temp.left == null) {
					temp.left = new Node(value);
					break;
				}
				else {
					queue.add(temp.left);
				}
				if(temp.right == null) {
					temp.right = new Node(value);
					break;
				}
				else {
					queue.add(temp.right);
				}
			}
		}
		
		// Method to give the Inorder Transversal of the Tree
		public static void printTree(Node root) {
			if(root == null) {
				return ;
			}
			else {
				printTree(root.left);
				System.out.print(root.value+" ");
				printTree(root.right);
			}
		}
	}
	
	// Parent Method -
	public static int count_unival(Node root) {
		
		int total = recursive(root)[0];
		int is_unival = recursive(root)[1];
		return total;
		
	}
	
	// The Recursive Methos -
	public static int[] recursive(Node root) {
		
		// The array returned is {Number of unival trees,True/False}
		// Here , True(1) is returned if tree is unival and 
		// False(0) if tree not an unival
		
		int is_unival =1; // True
		
		// If the tree is empty -
		//    - returns 0 unival trees
		//    - It is a unival tree
		
		if(root == null) {
			return new int[] {0,1};	
		}
		
		int left_count = recursive(root.left)[0];
		int is_left_unival =recursive(root.left)[1];
		
		int right_count = recursive(root.right)[0];
		int is_right_unival = recursive(root.right)[1];
		
		
		// All the cases when the tree is not a unival Tree
		
		if(is_right_unival == 0 || is_left_unival == 0) {
			is_unival = 0; // The Tree is not a unival if both right and left tree is not unival
		}
		
		if( root.left!=null && root.left.value != root.value) {
			is_unival = 0;  // The tree is not a unival tree if left node is not equal to root
		}
		
		if(root.right!=null && root.right.value != root.value) {
			is_unival = 0;  // The tree is not a unival tree if right node is not equal to root
		}
		
		if(is_unival == 1) {
			
			return new int[] {(left_count+right_count+1),1}; // +1 for the current tree is true
		}
		
		else {
			return new int [] {(left_count+right_count),0};
		}
			
	}
	

	public static void main(String[] args) {
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(0);
		root.right.left = new Node(1);
		root.right.right = new Node(0);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(1);
		
		
		System.out.println(" ---  Inorder Traversal  ----");
		Node.printTree(root);
		
		System.out.println("\n\nThe Number of unival trees possible is :");
		System.out.println(count_unival(root));

	}

}
