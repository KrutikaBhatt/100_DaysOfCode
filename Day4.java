/* 
 * This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */

import java.util.*;

public class Day4 {
	
	static int[] product_array(int [] array) {
		
		int temp = 1;
		int len = array.length;
		
		// Allocate memory for result array
		int []product = new int[len];
		
		// 	In this loop,
		//the variable temp = product of elements of left side of array excluding array[i]
		for(int i=0;i<len;i++) {
			product[i] = temp;
			temp = temp*array[i];
		}
		
		temp =1;
		
		//In this loop,
		//the variable temp = product of elements of right side of array excluding array[i]
		
		for(int i=(len-1);i>=0;i--) {
			product[i] = product[i]*temp;
			temp*=array[i];
		}
		
		// Return the final product result array
		return product;

	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of array :");
		int m = sc.nextInt();
		
		if(m<1) {
			System.out.print("\nError :Negative length enterd ");
		}
		else if(m==1) {
			int []a = new int[m];
			
			System.out.print("\nEnter the array :\n");
			for(int i=0;i<m;i++) {
				a[i] = sc.nextInt();
			}
			System.out.print("\nThe product array is same as array-\n");
			System.out.print(a[0]);
			
		}
		else {
		
			// Creating the array of length 
			int []a = new int[m];
			
			System.out.print("\nEnter the array :");
			for(int i=0;i<m;i++) {
				a[i] = sc.nextInt();
			}
			
			int []product = product_array(a);
			
			System.out.print("\nThe product array is -\n");
			for(int i=0;i<product.length;i++) {
				System.out.print(product[i]+" ");
			}
		}
		sc.close();

	}

}
