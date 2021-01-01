import java.util.ArrayList;
import java.util.Arrays;

/* This problem was asked by Google.
 * 
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
 * For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
*/

public class Day23 {
	
	static int MAX =256;
	
	public static boolean compare(char [] array1, char [] array2) {
		
		for(int i=0;i< MAX ;i++) {
			if(array1[i] != array2[i])
				return false;
		}
		return true;
	}
	
	static ArrayList<Integer> getIndices(String S, String W){
		
		int Slen = S.length();
		int Wlen = W.length();
		
		if(Wlen > Slen)
			return null;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// countP[]:  Store count of all characters of word/Pattern
        // countTW[]: Store count of current window of text 
		
		char [] countP = new char[MAX];
		char [] countTW = new char[MAX];
		
		for(int i=0; i<Wlen; i++) {
			
			(countP[W.charAt(i)])++;
			(countTW[S.charAt(i)])++;
		}
		
		for( int i=Wlen ;i<Slen;i++) {
			if(compare(countP,countTW))
				list.add((i-Wlen));
			
			 // Add current character to current window 
            (countTW[S.charAt(i)])++; 
  
            // Remove the first character of previous 
            // window 
            countTW[S.charAt(i-Wlen)]--; 
            	
		}
		if(compare(countP,countTW))
        	list.add(( Slen-Wlen ));
		
		return list;
	}

	public static void main(String[] args) {
		String S ="abxaba";
		String W = "ab";
		
		ArrayList<Integer> list = getIndices(S,W);
		System.out.println(" The first Indices in "+S+" which are anagrams of "+W+" is\n"+ Arrays.asList(list));

	}

}
