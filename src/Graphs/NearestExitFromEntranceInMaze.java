package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/?envType=study-plan&id=graph-i

Solution: Perform BFS from entrance point with help of empty cells and keep on marking empty cell as occupied. 
On performing each level of BFS traversal, increment the level. The moment, we reach to row or column ends and
exit then return value of level as lowest nearest path from entrance to exit. 
 */
public class NearestExitFromEntranceInMaze {
	public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i < size; i++){
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                int steps = pos[2];
                if ((row == 0 || row == maze.length -1 || col == 0 || col == maze[0].length -1) && maze[row][col] != '+' ){
                    return steps;
                }
                for (int[] dir: dirs){
                int nrow = pos[0] + dir[0];
                int ncol = pos[1] + dir[1];
            
                if (nrow >=0 && nrow < maze.length && ncol >=0 && ncol < maze[0].length && maze[nrow][ncol] == '.'){
                    queue.add(new int[]{nrow,ncol,steps + 1});
                    maze[nrow][ncol] = 'x';
                }
              }
            }
        }
        return -1;
    }
}
