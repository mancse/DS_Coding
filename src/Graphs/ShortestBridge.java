package Graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Idea is to keep all cells of both icelands in two different sets. To do so, perform two seperate DFS. 
 * Once two sets are ready then iterate both sets and then calculate length between each points of two 
 * different sets and keep on updating min length. 
 * Following formula to calculate distance between two points. 
 * 
 * Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1])
 * 
 * @author Manoj Kumar
 *
 */
public class ShortestBridge {
	 public int shortestBridge(int[][] grid) {
	        Set<int[]> iLand1 = new HashSet<int[]>();
	        Set<int[]> iLand2 = new HashSet<int[]>();
	        boolean iLand1Visited = false;
	        boolean iLand2Visited = false;
	        for (int i=0; i<grid.length; i++){
	            for (int j=0; j<grid[0].length; j++){
	                if (grid[i][j] == 1 && !iLand1Visited){
	                    dfs(grid,i,j, iLand1);
	                    iLand1Visited = true;
	                }
	            }
	            if (iLand1Visited)
	                break;
	        }

	        for (int i=0; i<grid.length; i++){
	            for (int j=0; j<grid[0].length; j++){
	                if (grid[i][j] == 1 && !iLand2Visited){
	                    dfs(grid,i,j, iLand2);
	                    iLand2Visited = true;
	                }
	            }
	            if (iLand2Visited)
	                break;
	        }
	             
	        int res = 2 * grid.length;
	        for (int[] point1 : iLand1){
	            for (int[] point2: iLand2){
	                res = Math.min(res, distanceBetweenTwoGridCells(point1, point2));
	            }
	        }
	        return res;
	    }
	    
	    private int distanceBetweenTwoGridCells(int[] point1, int[] point2){
	        int dist =  Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]) -1;
	        return dist;
	    }
	    private void dfs(int[][] grid, int i, int j, Set<int[]> iLand){
	        if (i <0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
	            return;
	        }
	        iLand.add(new int[]{i,j});
	        grid[i][j] = 0;
	        
	        dfs(grid,i-1,j,iLand);
	        dfs(grid,i+1,j,iLand);
	        dfs(grid,i,j-1,iLand);
	        dfs(grid,i,j+1,iLand);
	    }
}
