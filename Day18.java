import java.util.*;

/*This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
*/
public class Day18 {
	
	public static ArrayList<Integer> computMaximum(int [] array,int k) {
		
		ArrayList<Integer> result = new ArrayList<>(); // Creating the result Array list
		
		// Boxing 
		Integer[] data = Arrays.stream( array ).boxed().toArray( Integer[]::new );
		
		if(k<=0) {
			// If the length of the subarray given to te user is <=0 than return an empty Arraylist
			return new ArrayList<>();
		}
		
		else if(k == array.length) {
			
			//If the subarray length is == to array length, return maximum of whole array
			int max = Collections.max(Arrays.asList(data));
			result.add(max);
			return result;
		}
		
		
		ArrayList<Integer> dequeue = new ArrayList<>();
		
		for(int i=0;i<array.length;i++) {
			
			if(dequeue.size()!=0 && dequeue.get(0)< (i-k+1))
				dequeue.remove(0);
			
			while(dequeue.size() !=0 && array[i] >array[dequeue.get(dequeue.size()-1)]) {
				dequeue.remove(dequeue.size()-1);
			}
			
			dequeue.add(i);
			
			if(i>=k-1) {
				result.add(array[dequeue.get(0)]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		int a[] = {10, 5, 2, 7, 8, 7};
		ArrayList<Integer> array= computMaximum(a,3);
		System.out.println("Array :{10, 5, 2, 7, 8, 7}  :"+ Arrays.toString(array.toArray()) );
		
		
		int b[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		ArrayList<Integer> array1= computMaximum(b,4);
		System.out.println("Array1 :{8, 5, 10, 7, 9, 4, 15, 12, 90, 13} :"+ Arrays.toString(array1.toArray()) );
		
		int c[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		ArrayList<Integer> array2= computMaximum(c,3);
		System.out.println("Array :{1, 2, 3, 1, 4, 5, 2, 3, 6} :"+ Arrays.toString(array2.toArray()) );
		
	}

}
