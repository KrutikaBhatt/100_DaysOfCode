/* This problem was asked by Spotify.
 
   There are N couples sitting in a row of length 2 * N. They are currently ordered randomly,
   but would like to rearrange themselves so that each couple's partners can sit side by side.
   What is the minimum number of swaps necessary for this to happen?
*/

import java.util.*;

public class Day3 {
	
	// This function links the pair from reference_Array[]
	static void link_pair(int pairs[],int reference_Array[]) {
		for(int i=0;i<reference_Array.length;i++) {
			if(i%2 == 0) {
				pairs[i] = reference_Array[i+1];
			}
			else {
				pairs[i] = reference_Array[i-1];
			}
		}
	}
	
	static void sort_the_pairs(int pairs[],int reference_Array[],int array_toSort[]) {
		
		int swaps =0;
		int m = reference_Array.length;
		
		for(int i=0;i<m;i+=2) {
			
			for(int j=0;j<m;j++) {
				
				if(array_toSort[i] == reference_Array[j]) {
					int current_pair = pairs[j];
					
					// Now find the pair in array_tosort and pair it
					for(int k=(i+1);k<m;k++) {
						if(array_toSort[k]==current_pair && array_toSort[i+1]!=current_pair) {
							
							// Swap the pairs
							int t= array_toSort[i+1];
                            array_toSort[i+1]= array_toSort[k];
                            array_toSort[k]= t;
                            swaps++;
						}
					}
				}
			}
		}
		
		System.out.println("The minimum number of swaps required :"+swaps);
		
	}
	public static void main(String[] args) {
		int reference_Array[] = {1,8,4,5,9,6,2,11,10,12,13,14,15,16,17,18};
		int array_toSort[] = {1,4,5,6,8,9,14,12,13,11,2,10,18,16,17,15};
		
		int []pairs = new int[array_toSort.length];
		
		System.out.print("\nBefore sorting -\n");
		for(int i=0;i<array_toSort.length;i++) {
			
			System.out.print(array_toSort[i]+" ");
			
		}
		
		System.out.print("\nAfter sorting -\n");
		link_pair(pairs,reference_Array);
		sort_the_pairs(pairs,reference_Array,array_toSort);
		
		for(int j=0;j<array_toSort.length;j++) {
			System.out.print(array_toSort[j]+" ");
		}

	}

}
