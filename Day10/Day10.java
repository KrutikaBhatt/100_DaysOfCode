import java.util.Scanner;

/*This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
*/


/*Example :
 * 1. '101' decodes as 'ja' and returns 1
 * 2. '26' decodes as 'bf' and 'z' - It returns 2
 * 3. '602' There is no way to decode it It returns 0
 */


public class Day10 {
	

	// The Mapping Function
	// This function was only added to define the maping as mentioned in question
	private static String getCharForNumber(int i) {
		
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}
	
	// The main recursive function
	public static int Solution(String msg,int n,int []memo) {
		
		if(n == 0) {
			// If an empty string is Passed
			return 1;
		}
		
		int s = msg.length() - n;
		if(msg.charAt(s)=='0') {
			// If the encountered charachter is 0
			return 0;
		}
		
		if( memo[n]!=0){
			return memo[n];
		}
		
		// Recursively build the solution taking one charachter at a time
		int result = 0 ;
		result +=Solution(msg,n-1,memo);
		
		if(n>=2) {
			
			// If the length of Encoded message is >=2 ,there is a possibility
			// that string which is a two digit string can be decoded 
			// Example : '123' can have two digits from left to right which can be decoded as 
			//     '12' ->'L'
			//     '23' ->'W'
			
			String two_digit = ""+ msg.charAt(s) +msg.charAt((s+1));
			
			if(Integer.parseInt(two_digit) <=26) {
				result += Solution(msg,(n-2),memo);
				//System.out.print(getCharForNumber(Integer.parseInt(two_digit)));
			}
		}
		
		memo[n] = result;
		//System.out.print(getCharForNumber(result));
		return result;
				
	}
	
	public static int calling_function(String msg) {
		
		int [] memo = new int[msg.length()+1];
		
		// Initializing the array memo to 0
		for(int i=0;i<msg.length();i++) {
			memo[i] = 0;
		}
		return Solution(msg,msg.length(),memo);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Testcases
		System.out.println(calling_function("121"));
		System.out.println(calling_function("101"));
		System.out.println(calling_function("26"));
		System.out.println(calling_function("602"));
		System.out.println(calling_function("1234567"));
		
		System.out.println("Enter the String Encoded message :");
		String str = sc.next();
		
		System.out.println("The number of ways the message can be decoded is "+calling_function(str));
		sc.close();

	}

}
