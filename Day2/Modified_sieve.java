/* Manipulated Sieve of Eratosthenes algorithm with time Complexity O(N)
 *
 */

import java.util.*;
public class Modified_sieve {
	
	
	static Vector<Boolean> isprime = new Vector<>();
	static Vector<Integer> prime  =new Vector<>();
	static Vector<Integer> spf = new Vector<>(); // Smallest Prime factor
	
	static void getPrime(long N) {
		
		// Initializing Vector isprime elements to be true
		for(int i=0;i<N;i++) {
			isprime.add(true);
			spf.add(2);
		}
		
		// Set false for numbers 0,1
		isprime.set(0, false);
		isprime.set(1, false);
		
		for(int i=2;i<N;i++) {
			if(isprime.get(i)==true) {
				
				prime.add(i);
				// A prime number is its own smallest SPF
				spf.add(i,i);
			}
			
			for(int j=0;j<prime.size() && i*prime.get(j) < N && prime.get(j) <= spf.get(i);j++) {
				
				isprime.set(i*prime.get(j),false); 
			       
                // put smallest prime factor of i*prime[j] 
                spf.set(i*prime.get(j),prime.get(j)) ; 
			}
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("********* Manipulated Sieve of Eratosthenes **********\n\n");
		
		System.out.print("Enter the value of N :");
		int N=sc.nextInt();
		
		getPrime(N);
		for (int i=0; i<prime.size() && prime.get(i) <= N ; i++) 
            System.out.print(prime.get(i) + " "); 
	}

}
