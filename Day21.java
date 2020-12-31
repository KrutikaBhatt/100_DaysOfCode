/* This problem was asked by Google.
 * You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string.
 * Determine whether the parentheses are balanced.
 * For example, (()* and (*) are balanced. )*( is not balanced.
 */

public class Day21 {
	
	public static boolean checkBalanced(String str) {
		
		int closed =0;
		int opened =0;
		
		// Traverse through the String
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i) == '(') {
				opened++;
				closed ++;
			}
			
			else if(str.charAt(i) == ')') {
				
				opened --;
				closed = Math.max(closed-1, 0);
				
			}
			else {
				closed = Math.max(closed-1, 0);
				opened++;
			}
		}
		
		if(opened < 0) {
			return false;
		}
		return closed==0;
	}

	public static void main(String[] args) {
		
		String str = "((*)";
		System.out.println(checkBalanced(str));
	}

}
