package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/?envType=study-plan&id=graph-i
 * 
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 * 
 * Solution:
 * Idea is to perform BFS from top-left most cell to all clear path (i.e with 0). Each level of traversal in BFS will 
 * increment the counter. Once we encounter the bottom-right most cell first return counter. 
 * It will be always be the shortest path.  
 * @author Manoj Kumar
 *
 */
public class SortestPathInBinaryMatrix {
	 public int shortestPathBinaryMatrix(int[][] grid) {
	        if(grid[0][0] == 1){
	            return -1;
	        }
	        
	        Queue<int[]> queue = new LinkedList<>();
	        
	        queue.add(new int[]{0,0,0});
	        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1}};
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            
	            for (int i=0; i<size; i++){
	                int[] pos = queue.poll();
	                int r = pos[0];
	                int c = pos[1];
	                int cnt = pos[2];
	                
	                if (pos[0] == grid.length -1 && pos[1] == grid[0].length -1){
	                    return cnt + 1;
	                }
	                for (int j=0; j<dirs.length; j++){
	                    int nr = r + dirs[j][0];
	                    int nc = c + dirs[j][1];
	                    
	                    if (nr >=0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == 0){
	                        grid[nr][nc] = 1;
	                        queue.add(new int[]{nr,nc,cnt +1});
	                    }
	                }
	            }
	        }
	        return -1;
	    }
}
