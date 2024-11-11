package Graphs;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author Manoj.K
 * 
 * You are given an m x n grid where each cell can have one of three values:
   https://leetcode.com/problems/rotting-oranges/description/
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 */
public class RottenOranges {
	    public static int orangesRotting(int[][] grid) {
	        Queue<int[]> queue = new LinkedList<>();
	        int [][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
	        int freshOranges=0;
	        
	        /**
	         * Find number of fresh Oranges and also add rotten oranges to queue. 
	         */
	        for (int i=0; i<grid.length; i++){
	            for (int j=0; j<grid[0].length;j++){
	                if (grid[i][j] == 2){
	                    queue.add(new int[] {i,j});
	                }
	                
	                if (grid[i][j] == 1){
	                    freshOranges++;
	                }
	            }
	        }
	        int minutes=0;
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            
	            for (int i=0; i<size; i++){
	                int[] cell = queue.poll();
	                
	                for (int[] move: moves){
	                    int x = cell[0] + move[0];
	                    int y = cell[1] + move[1];
	                    
	                    if (x >=0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1){
	                        grid[x][y] = 2;
	                        queue.add(new int[] {x,y});
	                        freshOranges--;
	                    }
	                }
	            }
	            
	            /**
	             * Check the queue size after first iteration (i.e some oranges became wrotten in current cycle
	             * which caused wrotten oranges inserted in the queue, if queue size > 0
	             * it means, in the previous iteration, fresh oranges were converted to wrotten oranges and 
	             * now new wrotten oranges in queue are going to wroten other set of fresh oranges. Hence, 
	             * increment the minutes count. 
	             */
	            if (queue.size() > 0)
	            {
	                minutes++;
	            }
	        }
	        
	        return freshOranges == 0 ?  minutes : -1;
	    }
	    
	    public static void main(String args[]) {
	    	int[][] grid= {{2,1},{1,0}};
	    	System.out.println("Minutes: "+orangesRotting(grid));
	    	
	    	int[][] grid1 = {{2,1},{1,1}};
	    	System.out.println("Minutes: "+orangesRotting(grid1));
	    }
}
