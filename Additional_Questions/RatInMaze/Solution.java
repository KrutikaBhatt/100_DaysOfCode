/*
You are given a N*N maze with a rat placed at maze[0][0]. 
Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. 
Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells 
and those with value 1 are open.


  -->Input Format

  The next N lines of input contain N space-separated 
  integers representing the type of the cell.
  
  
--> Output :
  Give the directions the rat should go
  D - Down
  R- Right
  L -Left
  U - Up
*/
import java.util.*;

public class Solution {
	static Vector<String> possiblePaths = new Vector<>();
    
    static String path = "";
	
	
    public static boolean isSafe(int row,int col,int maze[][],int n,boolean visited [][]){
        if (row == -1 || row == n || col == -1 || 
         col == n || visited[row][col] || 
                     maze[row][col] == 0)
            return false;
        
        return true;
    }
    
    public static void printPathUtil(int row,int col,int [][] maze,int n,boolean [][] visited){
    	
        if(row ==-1 || col == -1 || row ==n || col == n || visited[row][col] == true || maze[row][col] ==0 ) {
            return;
        }
    
        //If you reach the last cell
        if(row == n-1 && col == n-1){
            possiblePaths.add(path);
            return;
        }
        
        //Mark the cell as visited
        
        visited[row][col] = true;
        
        //Try all the directions in order down-left-right-up
        
        if(isSafe(row+1,col,maze,n,visited)){
            path += 'D';
            printPathUtil(row+1,col,maze,n,visited);
            path = path.substring(0, path.length() - 1);
        }
        // Check if the left move is valid
    if (isSafe(row, col - 1, maze, n, visited))
    {
        path += 'L';
        printPathUtil(row, col - 1, maze, n,visited);
        path = path.substring(0, path.length() - 1);
    }
 
    // Check if the right move is valid
    if (isSafe(row, col + 1, maze, n, visited)) 
    {
        path += 'R';
        printPathUtil(row, col + 1, maze, n, visited);
        path = path.substring(0, path.length() - 1);
    }
 
    // Check if the upper move is valid
    if (isSafe(row - 1, col, maze, n, visited))
    {
        path += 'U';
        printPathUtil(row - 1, col, maze, n,visited);
        path = path.substring(0, path.length() - 1);
    }
        
       visited[row][col] = false;
        
    }
	public static void ratInAMaze(int maze[][]){
		
	  int n = maze.length;
        
      //Create the matrix to keep a record of visited nodes
        boolean [][] visited = new boolean[n][n];
       
        
        //Util function to see if path is valid
        //Start from row=0,column = 0
        printPathUtil(0,0,maze,n,visited);
        
        //Print all the paths
        
        for(int i=0;i<possiblePaths.size();i++){
            System.out.print(possiblePaths.get(i)+"\n");
        }
        
	}
	
	public static void main(String[] args) {
		int [][] maze = new int [][] {{1,0,1},
	 				      {1,0,1},
					      {1,1,1}};
			ratInAMaze(maze);
		
		int [][] maze2 = new int [][] {{ 1,0,1},
				{1 ,1 ,1},
				{1 ,1 ,1}};
				
		System.out.println("\nFor maze 2:");
		ratInAMaze(maze2);
			
	}

	
	
}
