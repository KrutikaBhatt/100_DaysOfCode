import java.util.LinkedList;

// This problem was asked by Yahoo.
// Write an algorithm that computes the reversal of a directed graph.
// For example, if a graph consists of A -> B -> C, it should become A <- B <- C.

public class Day11 {
	
	public  static class Graph{
		int vertice;
		LinkedList<Integer>[] adjlist;
		
		Graph(int vertice){
			this.vertice = vertice;
			adjlist = new LinkedList[vertice];
			
			// Intialize the lists
			for(int i =0;i<vertice;i++) {
				adjlist[i] = new LinkedList<>();
			}
		}
		
		public void addedge(int source ,int dest) {
			adjlist[source].addFirst(dest);
		}
		
		public Graph reverse(Graph graph) {
			
			Graph reversegraph = new Graph(vertice);
			// Inputs a graph and returns a reversed Graph
			for(int i=0;i<vertice;i++) {
				LinkedList<Integer> nodelist =adjlist[i];
				
				int source =i;
				for(int j=0;j<nodelist.size();j++) {
					int destination = nodelist.get(j);
					reversegraph.addedge(destination,source );
					
				}
			}
			return reversegraph;
		}
		
		public void printgraph() {
			for(int i=0;i<vertice;i++) {
				System.out.print(i);
				LinkedList<Integer> nodelist = adjlist[i];
				for (int j = 0; j <nodelist.size() ; j++) {
                    System.out.print("->" + nodelist.get(j));
                }
				
				System.out.println("");
				
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(3);
        graph.addedge(0,1);
        graph.addedge(1, 2);
        
        System.out.println("---------------Original Graph Edges---------------------------");
        graph.printgraph();
        Graph reverseGraph = graph.reverse(graph);
        System.out.println("---------------Reverse Graph Edges---------------------------");
        reverseGraph.printgraph(); 

	}

}
