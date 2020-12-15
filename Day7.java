/* Given a string with repeated characters, rearrange the string so that no two adjacent characters are the same.
 * If this is not possible, return None.
 * For example, given "aaabbc", you could return "ababac". Given "aaab", return None.
 */


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


// Defines the structure of each element in Priority queue
class Key{
	int freq;
	char ch;
	
	// constructor
	Key(int freq,char ch){
		this.freq = freq;
		this.ch  = ch;
	}
}

class compare_key implements Comparator<Key>{
	
	// Override the compare() method
	
	public int compare(Key a,Key b) {
		if(a.freq < b.freq) {
			return 1;
		}
		else if(a.freq > b.freq) {
			return -1;
		}
		return 0;
	}
}


public class Day7 {
	
	
	public static String rearrange_string(String str) {
		
		int len = str.length();
		
		str = str.toLowerCase();
		
		int [] frequencies = new int [26];
		
		// Storing frequencies of all characters in string in array frequencies
		for(int i=0;i<len;i++) {
			
			frequencies[str.charAt(i) - 'a']++;
		}
		
		// Insert all the charachters from string into Priority Queue along with frequencies
		PriorityQueue<Key> queue = new PriorityQueue<>(new compare_key());
		
		
		// Traverse through all the charachters and add in queue
		for(char i ='a';i<='z';i++) {
			int value = i-'a';
			if(frequencies[value]>0) {
				
				queue.add(new Key(frequencies[value],i));
			}
		}
		
		str="";
		
		//initially there's no previous element so,char is '#' and it's frequency is '-1' 
		Key previous = new Key(-1,'#');
		
		
		while(queue.size()!=0) {
			
			//Pop top element and add to the string
			Key char_InUse = queue.poll();
			str= str + char_InUse.ch;
			
			//If frequency of previously used character is not less than zero , then only add the character again with it's updated frequency
			if(previous.freq>0) {
				queue.add(previous);	
			}
			
			(char_InUse.freq) --;
			previous = char_InUse;
			
			
		}
		 
		//System.out.println(final_str);
		
		//If the length of the final resultant string and given string is not equal- It is a invalid string
		 if (str.length() != len) 
            return "None";
         else
            return str;
		 	
	}
	 
	
	public static void main(String[] args) {
		
		// TestCases
		System.out.println("aaabc :"+rearrange_string("aaabbc")+"\naaab :"+rearrange_string("aaab"));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string :");
		String str = sc.next();
		System.out.print("The resultant string is :"+rearrange_string(str));
		
		// aaabbbcdddf -> abdabdabdcf
		
		sc.close();
	}

}
