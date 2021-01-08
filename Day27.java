import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. 
If there is more than one possible reconstruction, return any of them. 
If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", 
return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
*/


public class Day27 {
	
	

	public static void main(String[] args) {
		
		// All Test Cases .. 
		//Time Complexiy :O(N^2) 
		//Space Complexity :O(N)
		
		System.out.println(splitWords(words("quick", "brown", "the", "fox"), "thequickbrownfox"));
        System.out.println(splitWords(words("bed", "bath", "bedbath", "and", "beyond"), "bedbathandbeyond"));
        System.out.println(splitWords(words("the", "theremin"), "theremin"));
        System.out.println(splitWords(words("a", "aa", "aaa", "aaaa", "aaaaa"), "aaaaab"));
		

	}
	
	private static List<String> splitWords(Set<String> words, String string) {
		Deque<String> queue = new LinkedList<>();
		splitWords_Recursive(queue,words,string,0);
		
		if(queue.isEmpty()) {
			return null;
		}
		else {
			return new ArrayList<>(queue);
		}
	}

	private static boolean splitWords_Recursive(Deque<String> queue, Set<String> words, String string, int offs) {
		
		if(offs>= string.length()) {
			return true;
		}
		
		for(String word :words) {
			if(!string.startsWith(word,offs)) {
				continue;
			}
			queue.addLast(word);
			
			if(splitWords_Recursive(queue,words,string,offs+word.length()))
				return true;
			
			queue.removeLast();
		}
		
		return false;
	}

	// Add the words to the Set
	private static Set<String> words(String... word){
		return Arrays.stream(word).collect(Collectors.toSet());
	}
	
	//
	
	
}
