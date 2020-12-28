/* Given a circular array, compute its maximum subarray sum in O(n) time.
 * A subarray can be empty, and in this case the sum is 0.
 * For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 where the 8 is obtained from wrapping around.
 * Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.
*/


public class Day19 {
	
	// The method to get the maximum subarray sum using Kadane's Algorithm
	// This works for normal arrays
	
	static int totalSum = 0;
	
	public static int Kadane(int [] array) {
		
		int max_current= array[0];
		int max_global = array[0];
		
		totalSum+=array[0];
		for(int i=1;i<=array.length-1;i++) {
			
			max_current = Math.max(array[i], max_current +array[i]);
			
			totalSum += array[i];
			
			if(max_current > max_global) {
				max_global = max_current;
			}
		
		}
		
		return max_global;
	}

	// Method that returns the maximum subarray sum in circular array
	public static int circularMax(int [] A) {
		
		// There are two cases in our case :
		// 1. We can get the maximum sum of subarray without wrapping. In this case Kadane's Algorithm will just work fine
		// 2.  Subarray contains wrapped elements, few elements from tail and few are from head.
		
		
		/*  Logic :
		 *  Equation :Total_Sum_of_Array – middle_sum = head_sum + tail_sum 
		 *  From this equation we can get the maxsum of wrapped array.
		 *  We can calculate Total_Sum_of_Array, only missing part is to find the middle portion and sum of that.
		 *  To get that we can revert all the elements with opposite sign (+ -> – and – -> +) and apply Kadane’s algorithm on that array, which gives the sum of the middle elements.
		 */
        int wrapMax = 0, normalMax = 0;
		
		normalMax = Kadane(A);  // Approach 1, SubArray lies within main  array
		  
		for(int i=0;i<A.length;i++) {  //Approach 2: SubArray contains wrapped elements
			A[i]=-A[i];
		}
		
		wrapMax = totalSum+Kadane(A);
		
		if(wrapMax > normalMax)
			return wrapMax;
		
		return normalMax;
		
		
	}
	public static void main(String[] args) {
		System.out.println("Array [8, -1, 3, 4] :"+circularMax(new int [] {8, -1, 3, 4}));
		System.out.println("Array [-4, 5, 1, 0] :"+circularMax(new int[] {-4, 5, 1, 0}));
	}

}
