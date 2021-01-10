// Determine whether a tree is a valid binary search tree.

// A binary search tree is a tree with two children, left and right,
// and satisfies the constraint that the key in the left child must be less than or equal to the root and 
// the key in the right child must be greater than or equal to the root.


//Class That defines the tree
class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		left = right = null;
	}
}
public class Day28 {
	
	public static boolean isValid(Node root,int min,int max){
		
		//Best case 
		if(root == null) {
			return true;
		}
		
		if(root.data <min || root.data > max) {
			return false;
		}
		
		//Check the subtrees recursively
		return( isValid(root.left,min,root.data -1) && isValid(root.right,root.data+1,max));
	}

	public static void main(String[] args) {
		
		Node tree = new Node(7);
		tree.left = new Node(2); 
        tree.right = new Node(5); 
        tree.left.left = new Node(1); 
        tree.left.right = new Node(3); 
        
        System.out.println(isValid(tree,Integer.MIN_VALUE,Integer.MAX_VALUE));

	}

}
