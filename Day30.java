import java.util.HashMap;

/* This problem was asked by MongoDB.
 * 
 * Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).
 * You can assume that such element exists.
 * For example, given [1, 2, 1, 1, 3, 4, 0], return 1.
 */
 


public class Day30 {
	
	public static Integer findMajority(int [] elements) {
		
		//Using a HashMap to store the element and frequencies
		HashMap<Integer,Integer> map = new HashMap<>();
		
		//Lets assume that majorityElement is first element itself
		int majorityElement = elements[0];
		
		for(int i=0;i<elements.length;i++) {
			
			Integer currentFreq = map.putIfAbsent(elements[i], 1);
			
			//If already existed,Increase the frequencies
			
			if(currentFreq!=null) {
				map.put(elements[i], ++currentFreq);
				
				//If current Key have maximum Frequency
				if(map.get(majorityElement) < map.get(elements[i])) {
					
					majorityElement = elements[i];
				}
			}
			
			System.out.println(elements[i] +" -"+map.get(majorityElement));
		}
		
		if(map.get(majorityElement) > ((elements.length)/2)) {
			return majorityElement;
		}
		else 
			return null;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(findMajority(new int[] {1, 2, 1, 1,1 ,1, 4, 0}));

	}

}
