/*
Gary has an array of N coins some have head side up and others have the tail side up.
Now Gary wants to flip exactly one interval of coins (i.e. continuous subarray) so that he can get 
maximum number of head side up coins.

Return the maximum number of head side up coins Gary can get after flipping exactly one interval of coins.
Note : Assume input is 1 - indexed based i.e. indexing in array starts from 1 instead of 0.

Input : N = Size of array
       1 - head side up
       0 - tails side up
       
Sample Input :
     5
     0 1 0 1 0
     
Output : 3
 */


public class Day32 {
	
	public static int getHeads(int n,int []arr) {
		
		int MaxHeadCount = Integer.MIN_VALUE;
		int modifiedCount;
		
		int [] sum = new int [n+1];
		sum[0] =0;
		//Since the arr starts from 1
		
		for(int i=1;i<=n;i++) {
			sum[i] = sum[i-1]+arr[i];
		}
		
		//Iterate over all intervals
		for(int l=1;l<=n;l++) {
			for(int r=l;r<=n;r++) {
				
				//Flip the coins in range l and r
				//Then Update the maxHeadCount
				modifiedCount = sum[l-1]+ ((r-l+1)-(sum[r]-sum[l-1])) + (sum[n] - sum[r-1]);
				
				if(modifiedCount > MaxHeadCount) {
					MaxHeadCount = modifiedCount;
				}
			}
		}
		
		return MaxHeadCount;
	}

	public static void main(String[] args) {
		
		int [] arr = new int [] {0,0, 1, 0, 1, 0};
		System.out.println(getHeads(5,arr));

	}

}
