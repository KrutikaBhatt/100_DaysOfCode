import java.util.LinkedList;

/* This problem was asked by Yahoo.
 *  Write an algorithm that computes the reversal of a directed graph.
 *  For example, if a graph consists of A -> B -> C, it should become A <- B <- C.
*/

public class Graph_Reversal {
	
	 // Adjacent List for given graph
	static LinkedList<Character> adj[];
	
	// List list for revresal graph
	static LinkedList<Character> reversal[];
	
	// Creation of Graph
	public Graph_Reversal(int vertice) {
		
		adj = new LinkedList[vertice];
		reversal = new LinkedList[vertice];
		
		for(int i=0;i<vertice;i++) {
			adj[i] = new LinkedList<Character>();
			reversal[i] = new LinkedList<Character>();
			
		}		
	}
	
	public static void addEdge(char source,char destination, Boolean InReverse ) {
		if(!InReverse)
			adj[(int)source-65].addFirst(destination);
		else
			reversal[(int)source-65].addFirst(destination);
	}
	
	public static void reverseGraph() {
		int v = adj.length;
		
		for(int i=0;i<v;i++) {
			
			for(int j=0;j<adj[i].size();j++) {
				addEdge(adj[i].get(j), (char)(i+65), true);
			}
		}
	}
	
	public  void display(int v,boolean isRev)
	{
		//checks whether to print adj or rev
		if(!isRev) {

			//traverses each node of adjency list
			for(int i = 0; i < v; i++)
	        {
	            System.out.print((char)(i+65) + " --> ");

	            //traverses each edge of adjency list
	            for(int j = 0; j < adj[i].size(); j++)
	                System.out.print(adj[i].get(j) + ", ");
	        }
			System.out.println("-");
		}
		else {

			//traverses each node of adjency list
			for(int i = v-1; i >=0; i--)
	        {
	            System.out.print((char)(i+65) + " --> ");

	            //traverses each edge of adjency list
	            for(int j = 0; j < reversal[i].size(); j++)
	                System.out.print(reversal[i].get(j) + ", ");

	        }
			System.out.println("-");
		}

	}
	public static void main(String[] args) {
		
		// A graph of 3 vertices
		Graph_Reversal graph = new Graph_Reversal(3);
		
		addEdge('A', 'B', false);
		addEdge('B', 'C', false);

		graph.display(3,false);

		reverseGraph();

		graph.display(3,true);

	}

}
