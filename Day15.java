
/*This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase.
The order of the steps matters.
For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? 
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
*/

import java.util.*;

public class Day15 {
	
	// Function to find the minimum number from array
	public static int minimum(int [] array) {
		
		int min = array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i] <= min)
				min = array[i];
		}
		
		return min;
	}
	
	// The main Function to get the combinations of steps
	
	public static List<int[]> getStepCombinations(int NumberOfsteps , int [] StepSizes) {
		
		List<int[]> list = new ArrayList<int[]>();
		
		int minimum = minimum(StepSizes);
		
		// If Number of steps given to us is less than the smallest value present in the array
		// Then , no combination is possible
		if(NumberOfsteps < minimum) {
			return list;
		}
		
		for(int i=0;i<StepSizes.length;i++) {
			
			// Example Number of steps - 3
			// Size Array - [1,3]
			// This means that, all the steps can be climbed in Array[1] i.e in Size 3
			// So we add the individual array to our list
			
			if(NumberOfsteps == StepSizes[i])
				list.add(new int[] {StepSizes[i]});
			
			else if(NumberOfsteps > StepSizes[i]){
				
				// Recursively get the child Combinations
				List<int[]> child_combos =getStepCombinations((NumberOfsteps-StepSizes[i]),StepSizes);
				
				for(int[] j :child_combos) {
					
					// Concatinate the two lists and add in List
					int[] a = new int[] {StepSizes[i]};
					int []c = new int [(a.length + j.length)];
					
					System.arraycopy(a, 0, c, 0, a.length); 
					System.arraycopy(j, 0, c, a.length, j.length); 
					list.add(c);
				}
			}
		}
		return list;
		
	}
	public static void main(String[] args) {
		
		System.out.println("Staircase has 4 stairs and you can jump [1,2,3] steps :\n");
		for (int[] strArr : getStepCombinations(4,new int [] {1,2,3})) {
			System.out.println(Arrays.toString(strArr));
		}
		
		System.out.println("\nStaircase has 7 stairs and you can jump [3,4,7] steps :\n");
		for (int[] strArr : getStepCombinations(7,new int [] {3,4,7})) {
			System.out.println(Arrays.toString(strArr));
		}

	}

}
