// Given a number in the form of a list of digits, return all possible permutations.
// For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

import java.util.*;

public class Day38 {
	
	private static ArrayList<ArrayList<Integer>> GetPermutations(int[] number){
		
		if(number.length ==0) {
			return null;
		}
		
		//The arraylist with all the permutations
		ArrayList<ArrayList<Integer>> permutation = new ArrayList<ArrayList<Integer>>();
		boolean visited [] = new boolean[number.length];
		
		//Current permutation array is made to keep a track of all the permutations in current execution
		PermutationBacktrack(permutation,visited,number, new ArrayList<Integer>());
		
		return permutation;
	}

	private static void PermutationBacktrack(ArrayList<ArrayList<Integer>> permutation, boolean[] visited, int[] number, ArrayList<Integer> currentPerm) {
		
		//Best case
		if(currentPerm.size() == number.length) {
			permutation.add(new ArrayList<>(currentPerm));
			return ;
			
		}
		
		for(int i=0;i<number.length;i++) {
			
			//If current number from the array is visited then move to next iterations
			if(visited[i]) {
				continue;
			}
			
			currentPerm.add(number[i]);
			visited[i]=true;
			
			PermutationBacktrack(permutation,visited,number,currentPerm);
			// when currentPermutation has been stored in permutations,
			// then we update it for storing next Permutation
			currentPerm.remove(currentPerm.size()-1);
			visited[i]= false;
			
			
		}
		
	}

	public static void main(String[] args) {
		
		int []numbers = {1,2,3};
		System.out.println(GetPermutations(numbers));
	}

}
