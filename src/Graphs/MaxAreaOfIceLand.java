package Graphs;
/*
 * 
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIceLand {
	 public int maxAreaOfIsland(int[][] grid) {
	        int maxArea = 0;
	        for (int i=0; i<grid.length; i++){
	            for (int j=0; j<grid[0].length; j++){
	                if (grid[i][j] == 1){
	                    maxArea = Math.max(maxArea,dfs(grid,i,j,0));
	                }
	            }
	        }
	        return maxArea;
	    }
	    
	    private int dfs(int[][] grid,int i,int j, int area){
	        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] ==0){
	            return 0;
	        }
	        area = grid[i][j];
	        grid[i][j] = 0;
	        
	        area += dfs(grid,i+1,j,area);
	        area += dfs(grid,i-1,j,area);
	        area += dfs(grid,i,j+1,area);
	        area += dfs(grid,i,j-1,area);
	        
	        return area;
	    }
}
