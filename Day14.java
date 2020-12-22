/* This problem was asked by Uber.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *  Find the minimum element in O(log N) time. You may assume the array does not contain duplicates.
 *  For example, given [5, 7, 10, 3, 4], return 3.
 */ 

/* A sorted rotated Array is obtained when the Array is shifted to right or left by a number
 * For eg :
 * Original Array : [1,2,3,4,5]
 * Rotated array by shifting elements to right by 3 - [3,4,5,1,2]
 * 
 * From most of the examples :
 * The minimum element is the only element whose previous is greater than it.
 * We check for the minimum array by comparing array[mid+1],array[mid-1]
 * If the minimum element is not at the middle (neither mid nor mid + 1), 
 * then the minimum element lies in either the left half or right half. 
       -If the middle element is smaller than the last element, then the minimum element is in left half
       -Else minimum element lies in the right half.
 */

public class Day14 {
	
	// Time Complexity - O(logn)
	
	public static int findMin(int [] array) {
		
		int start = 0;
		int end = array.length-1;
		
		if(start == end) // Array has one element only
			return array[0];
		
		else {
			
			if(array[end]>array[start])    // Array is not rotated and already sorted
				return array[start];
			
			while(start<end) {
				
				int mid = (end+start)/2;
				
				if(array[mid-1]>array[mid]) {
					
					// Eg - [4,5,1,2,3]
					return array[mid];
				}
				else if(array[mid]>array[mid+1]) {
					
					// Eg - [3,4,5,1,2]
					return array[mid+1];
				}
				
				// when mid element is greater than start
				else if(array[mid]>array[start]) {
					start = mid+1;
				}
				// when mid element is less than start
				else {
					end = mid -1;
				}
			}
			
		}
		
		return -1;
	}
	public static void main(String[] args) {
		
		// TestCases
		
		//1. No rotations perfored
		assert (findMin(new int [] {1,2,3,4,5})) == 1 :true;
		
		//2. Array with single element
		assert (findMin(new int [] {4}))==4 :true;
		
		//3. Sorted Rotated Array
		assert (findMin(new int [] {4,5,6,7,3})) == 3:true;
		
		assert (findMin(new int [] {2, 3, 4, 5, 6, 7, 8, 1})) == 1 : true;
		
		assert (findMin(new int [] {5, 6, 7, 1, 2, 3, 4 })) == 1: true;
		
	}

}
