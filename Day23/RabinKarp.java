import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a word W and a string S, find all starting indices in S in W.
 * For example, given that W is "ab", and S is "abxaba", return 0, 3.
 
 The naive method slides the pattern one by one

 Using Rabin-Karp Algorithm for Pattern Searching 
 Resources : https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/

*/

public class RabinKarp {
	
	static int d = 256;
	static int q = 101 ; // Prime number taken for the hashtable
	
	public static ArrayList<Integer> findAnagramIndices(String string,String word ){
		
		int strLen = string.length();
		int wordLen = word.length();
		
		if(wordLen > strLen)
			return null;
		
		int hashString =0;
		int hashword = 0;
		int j;
		int h=1;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<wordLen-1;i++) {
			h = (h*d)%q;  // Getting the hash indexes
		}
		
		// Calculate the hash value of pattern and first window of text 
		for(int i=0;i<wordLen;i++) {
			hashword = (d*hashword + word.charAt(i))%q; 
            hashString = (d*hashString + string.charAt(i))%q; 
		}
		
		// Slide the pattern over text
		// Check the hash values of current window of text and pattern. If the hash values match then only 
        // check for characters on by one 
		
		for(int i=0;i<=strLen-wordLen;i++) {
			
			if(hashString == hashword) {
				
				for(j=0;j<wordLen;j++) {
					if(string.charAt(i+j) != word.charAt(j))
						break;
				}
				
				// If everything matches
				if(j == wordLen)
					result.add(i);
					
			}
			
			// Calculate hash value for next window of text: Remove leading digit, add trailing digit 
			if(i < strLen-wordLen) {
				hashString = (d*(hashString - string.charAt(i)*h) + string.charAt(i+wordLen))%q;
			
			// If we get the negative number
				if(hashString < 0)
					hashString += q;
			}
				
		}
		
		return result;
	}
	
	

	public static void main(String[] args) {
		
		String string = "abxaba";
		
		String word = "ab";
		
		ArrayList<Integer> list = findAnagramIndices(string,word);
		
		System.out.println("The starting indices of word W = "+word+" In string S = "+string+" is\n"+Arrays.asList(list));
		
	}

}
