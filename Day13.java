import java.util.ArrayList;

/* This problem was asked by Google.
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
*/

public class Day13 {
	
	public static int getLongestSubArray(int [] array) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		// Traversing the given array -
		for(int i=0;i<array.length;i++) {
			
			// Check if the list contains the array elements or else add
			if(!list.contains(array[i])) {
				list.add(array[i]);
			}
		}
		
		// Print the Arraylist
		System.out.println("The SubArray Elemnets are :");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println("");
		
		return list.size();
		
	}

	public static void main(String[] args) {
		
		// Testcases
		assert getLongestSubArray(new int [] {5,1,3,5,2,3,4,1})==5 : true;
		
		// All elements distinct
		assert getLongestSubArray(new int [] {1,2,3,4,5,6})==6 : true;
		
		// All the array elements are same 
		assert getLongestSubArray(new int [] {1,1,1,1,1,1})==1 : true;
		

	}

}
