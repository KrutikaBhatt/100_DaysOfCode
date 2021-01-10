/* Find an efficient algorithm to find the smallest distance (measured in number of words)
 * between any two given words in a string.
 * For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
 * return 1 because there's only one word "cat" in between the two words
*/



public class Day29 {
	
	public static Integer findSmallestdistance(String sentence,String word1,String word2) {
		
		//If the sentence,word1 or word2 is empty or null
		if(word1 == null || word2 == null || sentence == null || sentence.isBlank() || word1.isBlank() || word2.isBlank()) {
			return null;
		}
		
		
		// Create the array of sentence
		String[] sentenceArray = sentence.split(" ");
		
		Integer from =null;
		Integer to = null;
		
		int shortest_distance = sentenceArray.length+1;
		//Traverse the sentence 
		for(int i=0;i<sentenceArray.length;i++) {
			
			if(sentenceArray[i].equalsIgnoreCase(word1))
				from = i;
			if(sentenceArray[i].equalsIgnoreCase(word2))
				to = i;
			
			//If both the words are found then find the shortest distance between them
			if(from!=null && to!=null) {
				shortest_distance = Math.min(shortest_distance, Math.abs(to-from));
			}
		}
		
		
		// If the shortest distance is not changed that means the words are not found
		// in the array
		
		if(shortest_distance == sentenceArray.length+1) {
			return null;
		}
		
		//Return
		return shortest_distance-1;
		
	}

	public static void main(String[] args) {
		
		String sentence = "dog cat hello cat dog dog hello cat world";
		System.out.println("Minimum Distance :"+findSmallestdistance(sentence,"hello","world"));

	}

}
