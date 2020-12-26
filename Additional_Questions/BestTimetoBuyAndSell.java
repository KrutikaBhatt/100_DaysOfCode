/* Say you have an array for which the ith element is
 * the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share
 * of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimetoBuyAndSell {
	
	public static int bestProfit(int [] stockPrices) {
		if(stockPrices.length == 0)
			return 0;
		
		int [] max = new int[stockPrices.length];
		
		 max[stockPrices.length - 1] = stockPrices[stockPrices.length - 1];
		 
		    for (int i = stockPrices.length - 2; i >= 0; i--) {
		      max[i] = Math.max(stockPrices[i], max[i + 1]);
		    }
		
		int result = Integer.MIN_VALUE;
		for (int i = 0, l = max.length; i < l; i++) {
		      result = Math.max(result, max[i] - stockPrices[i]);
		    }
		return result;
	}

	public static void main(String[] args) {
		System.out.println(bestProfit(new int [] {7, 1, 5, 3, 6, 4}));

	}

}
