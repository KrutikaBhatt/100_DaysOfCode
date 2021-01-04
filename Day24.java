/*
 * This problem was asked by Twitter.
 * 
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/

/*  The Naive Solution
 * We need to iterate over dictionery and check if each word starts with our prefix.
 * If it does,then add it to our set of the results and return it

 *   The Better Solution is :
 * We could use a tree t a tree where each child represents
 * one character of the alphabet. For example, let's say we had the words 'a' and 'dog' in our dictionary.
 * Then the tree would look like this:
     x
    / \
   a  d
       \
        o
         \
          g

 * Then, to find all words beginning with 'do', we could start at the root, go into the 'd' child, and then
 * the 'o', child, and gather up all the words under there. We would also some sort of terminal value to
 * mark whether or not 'do' is actually a word in our dictionary or not. This data structure is known as a
 * trie.
*/


import java.util.*;

public class Day24 {
	
	// Class for each node in the trie
	// Each node have a charachter assigned to it and children of the Node
	
	private static class Node{

		private char ch;
		private Node []children;
		private boolean end;
		
		public Node(char ch) {
			this.ch = ch;
		}
		
		public boolean hasChildren() {
			
			return children!=null;
		}
		
		public Node getChild(char ch) {
			if(hasChildren()) {
				return children[ch-'a'];
			}
			return null;
		}
		
		public void addWord(String word) {
			 addWord(word != null ? word.trim().toLowerCase() : null, 0, this);
		}
		
		private Node addChild(char ch) {
			if(children==null) {
				children = new Node['z' - 'a' + 1];
			}
			if(children[ch-'a']==null) {
				children[ch-'a'] = new Node(ch);
			}
			
			return children[ch-'a'];
		}

		private void addWord(String word, int i, Node node) {
			if(word == null)
				return;
			if(i == word.length())
				node.end = true;
			else
				  addWord(word, i + 1, node.addChild(word.charAt(i)));
		}
		
	}
	
	// We will create a class Dictionery with each element of Node
	
	private static class Dictionery{
		// Add starting root as empty or end of the line
		private Node root = new Node('\0');
		
		public void addWords(Collection<String> words) {
			Optional.ofNullable(words).orElse(Collections.emptySet()).forEach(root::addWord);
		}
		
		public Set<String> getWords(String prefix) {
                       return getWords(prefix, findLastNode(prefix != null ? prefix.trim().toLowerCase() : null, 0, root));
        }
		 private static Node findLastNode(String prefix, int i, Node node) {
	            while (true) {
	                if (node == null)
	                    return null;
	                if (i == prefix.length())
	                    return node;
	                node = node.getChild(prefix.charAt(i));
	                i++;
	            }
	        }

	        private static Set<String> getWords(String prefix, Node node) {
	            if (node == null)
	                return Collections.emptySet();
	            if (!node.hasChildren())
	                return Collections.singleton(prefix);
	            return collectWords(prefix, node, new TreeSet<>());
	        }
                
	        private static Set<String> collectWords(String prefix, Node node, Set<String> words) {
	            if (node == null)
	                return words;
	            if (node.end)
	                words.add(prefix);
	            if (node.hasChildren())
	                for (Node child : node.children)
	                    if (child != null)
	                        collectWords(prefix + child.ch, child, words);
	            return words;
	        }
	}
        
        
	public static void main(String[] args) {
            Dictionery dict = new Dictionery();
            dict.addWords(Arrays.asList("deer","dog","deal"));
            dict.getWords("de").forEach(System.out::println);
	}

}
