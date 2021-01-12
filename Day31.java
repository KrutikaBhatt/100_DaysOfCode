import java.util.ArrayList;
import java.util.*;
/* Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.
 * For example, given the following tree and K of 20
     10
    /  \
   5    15
       /  \
      11   15
 Return the nodes 5 and 15.
*/

//Class that defines the basic structure of node in Tree

class Nodes{
	int data;
	Nodes left;
	Nodes right;
	
	public Nodes(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class Day31 {
	
	public static ArrayList<Integer> findPair(Nodes root,int K){
		
		if(root == null) {
			return null;
		}
		
		HashSet<Integer> visited = new HashSet<>();
		Queue<Nodes> toBeVisited = new LinkedList<Nodes>();
		ArrayList<Integer> pair = new ArrayList<>();
		
		//We will use BFS to store unvisited nodes in Queue
		
		toBeVisited.add(root);
		
		while(!toBeVisited.isEmpty()) {
			
			if(toBeVisited.peek() !=null) {
				
				//Remove the element
				Nodes currentNode = toBeVisited.remove();
				
				//When the pair is found
				if(visited.contains(K-currentNode.data)) {
					
					pair.add(currentNode.data);
					pair.add(K-currentNode.data);
					return pair;
				}
				
				//Else Add the current node in visited HashSet
				//Add the currentNode's left and right subtree to toBeVisited Queue
				visited.add(currentNode.data);
				toBeVisited.add(currentNode.left);
				toBeVisited.add(currentNode.right);
			}
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		
		/*Creating tree
	      10
	     /  \
	    5    15
	        /  \
	       11   15
	       */
		Nodes root = new Nodes(10);
		root.left = new Nodes(5);
		root.right = new Nodes(15);
		root.right.left = new Nodes(11);
		root.right.right = new Nodes(15);
		
		System.out.println( Arrays.asList(findPair(root,20)));
		
		/*Creating Tree
		     1
		   /   \
		 0      1
		/ \    / \
	   0   1  1   1
		 */
		
		Nodes root1 = new Nodes(1);
		root1.left  = new Nodes(0);
		root1.right = new Nodes(1);
		root1.left.left = new Nodes(0);
		root1.left.right = new Nodes(1);
		root1.right.left = new Nodes(1);
		root1.right.right = new Nodes(1);
		
		System.out.println( "Search for 0 :"+Arrays.asList(findPair(root1,0)));
		System.out.println( "Search for 1 :"+Arrays.asList(findPair(root1,1)));
		System.out.println( "Search for 2 :"+Arrays.asList(findPair(root1,2)));
	}

}
