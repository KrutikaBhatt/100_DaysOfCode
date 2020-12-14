/*This problem was asked by Stripe.

 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 */


/* Algorithm : 
 * 1. Move all the negative numbers to end of array
 * 2. Transverse throught the positive numbers
 * 3. Find the number equal to that value and mark it negative ** Assuming one indexed **
 * 4. Iterate through array again
 * 5. Return index of first positive number
 * 6 Else if no positive number present return (last index +2) 
 */

import java.lang.Math;

public class Day6 {
	
	// Linear time and constant space ...
	public static int missing_Integer(int []array) {
		
		int current =0;
		int n = array.length;
		int last = n-1;
		
		while(current<=last) {
			
			// If number in array is negative push it to the end
			while(array[current]<=0 && last>=current) {
				int temp = array[last];
				array[last] = array[current];
				array[current] = temp;
				
				last --;
			}
			current++;
		}
		
		// Interating and marking number equal to that value negative 
		for(int i=0;i<= last ;i++) {
			
			int seen = Math.abs(array[i])-1;
			
			if(seen<=last && array[seen]>=0) {
				array[Math.abs(array[i])-1] *=-1;		
			}
		}
		
		// Algorithm step 4,5,6
		
		for(int i=0;i<=last;i++) {
			if(array[i]>0)  {
				// Return the index of positive number 
				return (i+1);
			}
		}
		
		// Else return last indexed +2
		return (last+2);
	}

	public static void main(String[] args) {
		
		// 	Test Cases :
		
		System.out.println(missing_Integer(new int []{3,4,-1,1}) == 2); // Negative number
		System.out.println(missing_Integer(new int []{1,2,0})==3);    
		System.out.println(missing_Integer(new int[]{3,3,2,1})==4);   // Duplicates
		System.out.println(missing_Integer(new int[]{})==1);  // Entered a empty array
		
		// Great all the test cases returns true :)
	}

	
}
