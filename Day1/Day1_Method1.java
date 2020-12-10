/* This problem was recently asked by Google.
 Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 Using simple method.
 */

import java.util.*;

public class Day1_Method1 {
	
	static boolean check(int []a,int k) {
		
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				
				// Comparing the two elements of array
				if(a[i]+a[j]==k) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Length of array :");
		int n = sc.nextInt();
		
		int []a = new int[n];
		System.out.println("Enter the array element :");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
			System.out.print(" ");
		}
		
		System.out.print("\nEnter the value of k:");
		int k= sc.nextInt();
		
		System.out.print("\n"+check(a,k));
		
		sc.close();
	}

}
