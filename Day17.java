/*This problem was asked by Airbnb.

 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 * For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 */

public class Day17 {
	
	public static int max(int a,int b) {
		if(a>b) {
			return a;
		}
		else if(a<b) {
			return b;
		}
		else {
			return a;
		}
	}
	public static int getLargest(int [] array) {
		
		int previous = 0;
		int largest = 0;
		
		for(int i =0;i<array.length;i++) {
			//System.out.printf("Amount :%d Previous :%d Largest :%d\n",array[i],previous,largest);
			
			int c = max(largest,previous+array[i]);
			previous = largest;
			largest = c;
			
			//System.out.printf("--- The new Values ----\nAmount :%d Previous :%d Largest :%d\n",array[i],previous,largest);
			
		}
		return largest;
	}

	public static void main(String[] args) {
		
		System.out.println("Array [2, 4, 6, 8] : "+getLargest(new int [] {2, 4, 6, 8}));
		System.out.println("Array [5, 1, 1, 5]  :"+getLargest(new int [] {5, 1, 1, 5}));
		
		System.out.println("Array [-2,3,-1,-1]  :"+getLargest(new int [] {-2,3,-1,-1}));
		System.out.println("Array [1,1,1,1]  :"+getLargest(new int [] {1,1,1,1}));
		
	}

}
