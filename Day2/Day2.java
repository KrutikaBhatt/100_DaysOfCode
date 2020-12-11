/*
 * The Sieve of Eratosthenes is an algorithm used to generate all prime numbers smaller than N.
   The method is to take increasingly larger prime numbers, and mark their multiples as composite.
   For example, to find all primes less than 100, we would first mark [4, 6, 8, ...] (multiples of two),
   then [6, 9, 12, ...] (multiples of three), and so on. Once we have done this for all primes less than N,
   the unmarked numbers that remain will be prime.
   Implement this algorithm.

*/
/* The classical Sieve of Eratosthenes algorithm takes O(N log (log N)) time to find all prime numbers less than N. 
 * a modified Sieve is discussed in Modified.java works in O(N) time.
 */

import java.util.*;
public class Day2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("******** Sieve of Eratosthenes ******** \n\n");
		
		// Input the number
		System.out.print("Enter the prime number :");
		long n = sc.nextLong();
		
		// Initializing the Array List and add true for every element at start
		ArrayList <Boolean> primes = new ArrayList();
		for(int i=0;i<n;i++) {
			primes.add(true);
		}
		
		// 1 is not a prime number
		primes.set(0, false);
		primes.set(1, false);
		
		for(int i=2;i< Math.sqrt(n); i++) {
			
			if(primes.get(i) == true) {
				
				// Getting all prime numbers
				for(int j=(i*i) ;j<n ;j+=i) {
					primes.set(j,false);
				}
			}	
		}
		// Print all the values of prime number which are true
		System.out.print("\nThe prime numbers are less than "+n+" :\t");
		for(int i=2;i<n;i++) {
			if(primes.get(i)==true) {
				System.out.print(" "+i);
			}
		}
	}

}
