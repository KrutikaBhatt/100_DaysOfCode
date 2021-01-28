import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Given a set of distinct positive integers, find the largest subset such that every pair of elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.
// For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. Given [1, 3, 6, 24], return [1, 3, 6, 24].


public class Day37 {

	public static void main(String[] args) {
		
		System.out.println("The array [3, 5, 10, 20, 21] has subset: "+findSubset(new int[] {3, 5, 10, 20, 21}));
		System.out.println("The array [1, 3, 6, 24] has subset :"+findSubset(new int[] {1, 3, 6, 24}));

	}

	private static ArrayList<Integer> findSubset(int[] array) {
		if(array.length == 0) {
			return null;
		}
		
		//tempSubArr is the assumed large subArray
		// MaxSubArray is the main arraylist which stores the subArray
		ArrayList<Integer> tempSubArray = new ArrayList<>();
		ArrayList<Integer> main = new ArrayList<>();
		
		if(array.length == 1) {
			main.add(array[0]);
			return main;
		}
		
		int tempsum=0;
		int maximum =0;
		Arrays.sort(array);
		
		//Check the ends 
		if(array[array.length -1] % array[array.length-2] ==0) {
			tempsum = array[array.length-1];
			tempSubArray.add(tempsum);
		}
		
		//Loop for transversing
		for(int i=array.length-2;i>0;i--) {
			
			if(array[i]%array[i-1]!=0 && array[i+1]%array[i]!= 0) {
				System.out.println(array[i]+" Rejected " +i);
				tempsum =0;
				tempSubArray.clear();
				
			}
			
			else {
				
				//Add it to the arraylist
				tempsum+=array[i];
				System.out.println(array[i]+" Selected " +i);
				tempSubArray.add(array[i]);
			}
			
			if(maximum < tempsum) {
				main.clear();
				main.addAll(tempSubArray);
			}
		}
		
		//Check the start corner
		if(array[1] % array[0] == 0) {
			tempsum +=array[0];
			tempSubArray.add(array[0]);
		}
		
		if(maximum<tempsum) {
			main.clear();
			main.addAll(tempSubArray);
		}
		
		Collections.reverse(main);
		return main;
	}
	
	

}
