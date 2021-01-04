/*This problem was asked by Facebook.
 * 
 * A builder is looking to build a row of N houses that can be of K different colors. 
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
*/

/* So from above:
 * Input : A n x k matrix
 * Return a minimum cost
 * 
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Day25 {
	
	
	// Time Complexity - O(N*K*K)
	public static int MinCost(int [][] costMatrix) {
				
		int num_houses = costMatrix.length;
		int num_colors = costMatrix[0].length;
		
		if(num_houses ==0 || num_colors ==0)
			return 0;
		
		// If all elements are zero return 0 .. No need to processing
		
		int flag =0;
		for(int i=0;i<num_houses;i++) {
			for(int j=0;j<num_colors;j++)
				if(costMatrix[i][j] !=0)
					flag = 1;
		}
		if(flag == 0)
			return 0;
		
		// An empty matrix of the same size
		
		int [][] result = new int [num_houses][num_colors] ;
		
		for(int i=0;i<num_houses;i++) {
			
			// If its the very first house/ first row
			// Then simply the result matrix will have the first row same as the cost matrix row
			if(i ==0) {
				for(int j=0;j<num_colors;j++) {
					result[i][j] = costMatrix[i][j];
				}
			}
			
			// Add the current house price to the minimum house prices of earlier row
			else {
				for(int j=0;j<num_colors;j++) {
					result[i][j] = costMatrix[i][j] + min_cost_prior_houses(result[i-1],j);   //Pass the earlier row of the matrix
				}
			}
		}
		
		// Return the minimum of last row
		List<Integer> list  = Arrays.stream(result[num_houses-1]).boxed().collect( Collectors.toList() );
		return Collections.min(list);
		
		
	}
	
	public static int  min_cost_prior_houses(int [] matrix,int j) {
		
		// We need to delete the item at j so that adjacent houses get different color
	
		List<Integer> tempList  = Arrays.stream(matrix ).boxed().collect( Collectors.toList() );
	    tempList.remove(j);
	    return Collections.min(tempList);
		
	}

	public static void main(String[] args) {
		
		int matrix1 [][] = new int[][] {{2,5},
			                            {1,6},
			                            {2,7},
			                            {4,3}
			                           };
        System.out.println("For Matrix 1: The minimum cost is :"+MinCost(matrix1));
			                           
        int matrix2 [][] = new int[][] {{0,0},{0,0},{0,0},{0,0}};
        
        System.out.println("For Matrix 2: The minimum cost is :"+MinCost(matrix2));
        
        int matrix3 [][] = new int[][] {{7, 3, 8, 6, 1, 2},
                                         {5, 6, 7, 2, 4, 3},
                                         {10, 1, 4, 9, 7, 6}};
        
        System.out.println("For Matrix 3: The minimum cost is :"+MinCost(matrix3));  
        
        int matrix4 [][] = new int [][] {{7, 3, 8, 6, 1, 2},
							            {5, 6, 7, 2, 4, 3},
							            {10, 1, 4, 9, 7, 6},
							            {10, 1, 4, 9, 7, 6}};
							           
		System.out.println("For Matrix 4: The minimum cost is :"+MinCost(matrix4));					            
							          

	}

}
