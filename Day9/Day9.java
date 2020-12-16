/* This problem was asked by Facebook.
 
 Suppose you are given two lists of n points, one list p1, p2, ...,
 pn on the line y = 0 and the other list q1, q2, ..., qn on the line y = 1.
 Imagine a set of n line segments connecting each point pi to qi.
 Write an algorithm to determine how many pairs of the line segments intersect.
 
*/

public class Day9 {
	
	// Method for counting pairs of line intersecting
	public static int count_pairs(int y0[], int y1[]) {
		
		int intersectingPairs = 0;
		
		for(int i = 0;i< y0.length;i++) {
			
			for(int j=0;j<y1.length;j++) {
				
				// Read the Algorithm.md file to understand the Concept
				if((y0[i]>y0[j] && y1[i]<y1[j]) ||(y0[i]<y0[j] && y1[i]>y1[j])) {
					
					intersectingPairs++;
				}
			}
		}
		return intersectingPairs;
	}
	
	public static void main(String[] args) {
		int y0[]= {1,2,3,4,5}; // coordinates of x at y=0
		int y1[]= {5,4,3,2,1}; // coordinates of x at y=1
		
		System.out.print("The number of Intersecting Pairs are "+count_pairs(y0,y1));

	}

}
