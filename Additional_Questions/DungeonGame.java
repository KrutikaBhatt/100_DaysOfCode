import java.util.Vector;

/* The demons had captured the princess (P) and
 * imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must
 * fight his way through the dungeon to rescue the princess.
 *
 * <p>The knight has an initial health point represented by a positive integer. If at any point his
 * health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon
 * entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the
 * knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only
 * rightward or downward in each step.
 *
 * 
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue
 * the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if
 * he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * -2 (K) -3 3 -5 -10 1 10 30 -5 (P)
 *
 * Notes:
 * The knight's health has no upper bound. Any room can contain threats or power-ups, even the
 * first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 * 
 */
public class DungeonGame {
	
	// The 2D dungeon
	public static int calculateMinimumHP(int [][] dungeon) {
		if(dungeon.length == 0) {
			return 1;
		}
		
		// Assigning the values of row and column
		int row = dungeon.length;
		int col = dungeon[0].length;
		
		
		int HP_right; // Integer to point the right of the cell
		int HP_down ;  // Integer to point the down of the cell
		
		int [][] new_dungeon = new int[dungeon.length][dungeon[0].length]; 
		
		
		// We start from the last i.e, bottom right cell where we have the princess
		new_dungeon[row-1][col-1] = 1-dungeon[row-1][col-1];
		 
		
		// If the value from above is -ve then
		new_dungeon[row-1][col-1] = Math.max(1, new_dungeon[row-1][col-1]);
		
		// Traversing the data of the matrix
		for(int i=row-1;i>=0;i--) {
			
			for(int j=col-1;j>=0;j--) {
				
				System.out.println("Matrix : "+new_dungeon[i][j]);
				// We have already assigned the value to last cell
				if(i == row-1 && j == col-1)
					continue;
				
				// If the element is the right most element. It should not have any right element
				if(j == col-1) {
					 HP_right = Integer.MAX_VALUE;
				}
				else {
					HP_right = new_dungeon[i][j+1] - dungeon[i][j];
				}
				
				System.out.println("HP_Right :"+HP_right);
				
				// If the element is at the last row, It can't traverse downside
				if(i == row-1) {
					HP_down = Integer.MAX_VALUE;
				}
				else {
					HP_down = new_dungeon[i+1][j] - dungeon[i][j];

				}
				System.out.println("HP_down :"+HP_down);
				
				// In case the Knight might go to right or downward cell . He must choose
				// the optimized path i.e, the one with least HP requirement 
				
				int HP = Math.min(HP_right, HP_down);
				
				// If the HP turns out to be negative,turn the value to be 1
				HP = Math.max(1,HP);
				new_dungeon[i][j] = HP;
				System.out.println("HP :"+HP);
				
			}
		}
		
		return new_dungeon[0][0];    // The least Health Value will be in the 1st cell of the matrix
		
	}

	public static void main(String[] args) {
		int [][] a = {{-2,-3,3},
			      {-5,-10,1},
			      {10,30,-5}};
		
		System.out.println("The minimum Health Knight requires is :"+calculateMinimumHP(a));
		

	}

}
