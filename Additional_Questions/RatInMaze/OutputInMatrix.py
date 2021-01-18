def ratInMaze(n,maze):
    solution = [[0 for j in range(n)] for i in range(n)]
    solveMaze(0,0,n,maze,solution)
    
def solveMaze(row,col,n,maze,solution):
    if(row == n-1 and col == n-1):
        solution[row][col] = 1
        printSolution(solution,n)
        print("")
        return 
    
    if(row<0 or col<0 or row>n-1 or col>n-1):
        return
    
    if(row<0 or col<0 or row>n-1 or col>n-1 or maze[row][col] ==0 or solution[row][col] ==1):
        return
    
    solution[row][col] =1
    
    #Directing to left
    solveMaze(row,col-1,n,maze,solution)
    #To right
    solveMaze(row,col+1,n,maze,solution)
    #To down
    solveMaze(row+1,col,n,maze,solution)
    #To up
    solveMaze(row-1,col,n,maze,solution)
    
    solution[row][col] =0
    
def printSolution(solution,n):
    for i in range(0,n):
        for j in range(0,n):
            print(solution[i][j],end=" ")

n = int(input())
maze = n*[0]

for i in range(0,n):
    maze[i] = input().split()
    maze[i] = [int(j) for j in maze[i]]

ratInMaze(n,maze)
