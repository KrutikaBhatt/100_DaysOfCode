/*
  Given a binary tree having N nodes, remove all the half nodes (which has only one child).
  In order to remove any half node, replace that node with its only child and then remove the child.
  Print the inorder traversal of updated tree.
  Note : Leaves should not be touched as they have both children as NULL.
  
 */


// Class that defines the node of tree	
class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

public class Day33 {
		
public static Node RemoveHalfNodes(Node node){
        
        if(node == null)
            return null;
        
        node.left = RemoveHalfNodes(node.left);
        node.right = RemoveHalfNodes(node.right);
        
        //The node is leaf if no left or right node is present
        if(node.left ==null && node.right ==null )
            return node;
        
        //If the node is a half node
        if(node.left == null){
        	Node newNode = node.right;
            return newNode;
            
        }
        if(node.right == null){
        	Node newNode = node.left;
            return newNode;
        }
        
        return node;
    }
    
    public static void printInorder(Node node){
        if (node != null)  
        { 
            printInorder(node.left); 
            System.out.print(node.data + " "); 
            printInorder(node.right); 
        } 
    }
	public static void removeHalfNodes(Node root) {
		
		Node newTree= RemoveHalfNodes(root);
		printInorder(newTree);
	}
    
	public static void main(String[] args) {
		
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6); 
        root.left.right.left = new Node(1); 
        root.left.right.right = new Node(11); 
        root.right.right = new Node(9); 
        root.right.right.left = new Node(4); 
        
        System.out.println("The Inorder Tranversal of the tree :");
        printInorder(root);
        
        System.out.println("\nThe Inorder Transversal of tree with removal of half nodes :");
        removeHalfNodes(root);
        
	}

}
