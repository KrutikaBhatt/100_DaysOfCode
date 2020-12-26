/*At a lemonade stand, each lemonade costs $5.
 *
 * Customers are standing in a queue to buy from you, and order one at a time (in the order
 * specified by bills).
 *
 * Each customer will only buy one lemonade and pay with either a $5, $10, or any multiple of 5  bill. You must
 * provide the correct change to each customer, so that the net transaction is that the customer
 * pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Return true if and only if you can provide every customer with correct change.
 */

public class Lemonade_Change {
	
	public static boolean getLemonadeChange(int []bills) {
		
		int five=0;
		//System.out.println("Original Income :"+(five*5));
		for( int bill :bills) {
			if(bill == 5) {
				five++;
				
			}
			else {
				int change = bill/5 -1;
				
				//System.out.println("Change to be given :"+change*5+" ruppess");
				while(change!=0) {
					five -- ;
					change --;
				}
			}
			if(five <0) {
				return false;
			}
			//System.out.println("Income now :"+(five*5));
		}
		return true;
	}
	public static void main(String[] args) {
		
		assert (getLemonadeChange(new int [] {5,5,5,10,20})):true;
		assert (getLemonadeChange(new int [] {5,5,10})):true;
		assert (getLemonadeChange(new int [] {5,5,10,10,20})):false;
		assert (getLemonadeChange(new int [] {5,5,5,10,5,15,25})):false;
		

	}

}
