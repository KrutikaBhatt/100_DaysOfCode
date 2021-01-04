import java.util.ArrayList;

// Given a string, determine whether any permutation of it is a palindrome.
// For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome.
// daily should return false, since there's no rearrangement that can form a palindrome.

public class Day26 {
	
	public static boolean hasPallindrone(String str) {
		
		// Creating a Character Arraylist
		ArrayList<Character> checker = new ArrayList<>();
		
		//Traversing the string and check for duplicates
		for(int i=0;i<str.length();i++) {
			
			if(checker.contains(str.charAt(i)))
				checker.remove((Character)str.charAt(i));      // This step was a bit debug step
			                                                  //If '(Charachter)' is not added it shows  java.lang.IndexOutOfBoundsException error
			
			else
				checker.add(str.charAt(i));
		}
		
		// if length is even then there will be a pair(duplicate) for each character,
		// if length is odd one character will not have a character
		
		if((str.length()%2 == 0) && checker.isEmpty())
			return true;
		
		if((str.length()%2 !=0 ) && checker.size() ==1)
			return true;
		
		else
			return false;
			
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Is 'carrace' a Palindrone : "+hasPallindrone("carrace"));
		System.out.println("Is 'daily' a Palindrone : "+hasPallindrone("daily"));
		
	}
}
