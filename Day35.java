/*
 
	Given an array A of size n and an integer K, return all subsets of A which sum to K.
	Subsets are of length varying from 0 to n, that contain elements of the array.
	But the order of elements should remain same as in the input array.
	Note : The order of subsets are not important.

 */
public class Day35 {
	
	 public static void print2D(int mat[][]) 
	    { 
	        // Loop through all rows 
	        for (int i = 0; i < mat.length; i++) {
	        	
	        	System.out.println("");
	            for (int j = 0; j < mat[i].length; j++) 
	                System.out.print(mat[i][j] + " "); 
	        }
	        
	    } 

	public static void main(String[] args) {
		
		int [][] n= Return_subsets_sum_to_K(new int[] {5 ,12 ,3 ,17, 1 ,18, 15, 3, 17}, 6);
		System.out.println("The number of subsets :"+n.length+"\nThe subsets are -");
		print2D(n);
		
	}

	private static int[][] Return_subsets_sum_to_K(int[] input, int k) {
		return subsetsSumKHelper(input, 0, k);
	}

	private static int[][] subsetsSumKHelper(int[] input, int beginIndex, int k){
	   
		if(beginIndex == input.length){
	        if(k == 0){
	            return new int[1][0];
	        }
	        else{
	            return new int[0][0];
	        }
	    }
		
	    int[][] smallOutput1 = subsetsSumKHelper(input, beginIndex+1, k);
	    int[][] smallOutput2 = subsetsSumKHelper(input, beginIndex + 1,k -input[beginIndex]);
	    
	    int[][] output = new int[smallOutput1.length + smallOutput2.length][];
	    
	    
	    int index = 0 ;
	    for(int i = 0; i < smallOutput1.length; i++){
	        output[index++] = smallOutput1[i];
	    }
	    
	    for(int i = 0; i < smallOutput2.length; i++){
	        output[index] = new int[smallOutput2[i].length+1];
	        output[index][0] = input[beginIndex];
	        
	        for(int j = 0; j < smallOutput2[i].length; j++){
	            
	        	output[index][j+1] = smallOutput2[i][j];
	        }
	        index++;
	    }
	    return output;
	}

}
