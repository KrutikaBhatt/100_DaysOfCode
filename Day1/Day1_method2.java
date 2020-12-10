// Set is used to get the time Complexity as O(n). Its a way efficient and better code
import java.util.*;

public class Day1_method2 {
	
	public static boolean check(int []a,int k) {
		// Using Hashset 
		Set<Integer> set= new HashSet<Integer>();
		
		
		for(int i:a) {
			int remain =  k-i;
			if(set.contains(remain)) {
				return true;
			}
			set.add(i);
		}
		return false;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of array :");
		int len = sc.nextInt();
		
		int []a = new int[len];
		for(int i=0;i<len;i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.print("\nEnter value of k :");
		int k = sc.nextInt();
		System.out.print("\n"+check(a,k));
		
		sc.close();
	}

}
