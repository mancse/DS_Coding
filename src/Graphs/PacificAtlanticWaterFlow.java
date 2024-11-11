package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * 
 * Solution: 
 *  Idea here is to perform DFS from all 4 sides (i.e pacific or atlantic sides) until hight of neighbouring
 *  cell is greater than current cell and keep on marking true in respective atlantic or paciific boolean 
 *  array which means if a cell is marked true in atlantic[] then from that cell it is possible to flow towards
 *  atlantic ocean. Similar is case for pacific. 
 *  
 *  At last, again traverse the grid and check the the indexes where cells are set true in both atlantic and
 *  pacific array. 
 * 
 * 
 * @author Manoj Kumar
 *
 */
public class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean atlan[][] = new boolean[rows][cols];
        boolean pacif[][] = new boolean[rows][cols];
        
        for (int i=0; i<rows; i++){
            dfs(heights,i,0,pacif,Integer.MIN_VALUE);
            dfs(heights,i,cols-1,atlan,Integer.MIN_VALUE);
        }
        
        for (int i=0; i<cols; i++){
            dfs(heights,0,i,pacif,Integer.MIN_VALUE);
            dfs(heights,rows-1,i,atlan,Integer.MIN_VALUE);
        }
        
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (atlan[i][j] && pacif[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] heights, int i, int j, boolean ocean[][], int prev){
        if (i <0 || i>=heights.length || j < 0 || j >= heights[0].length){
            return;
        }
        
        if (heights[i][j] < prev || ocean[i][j] == true){
            return;
        }
        
        ocean[i][j] = true;
        
        dfs(heights,i,j+1,ocean,heights[i][j]);
        dfs(heights,i,j-1,ocean,heights[i][j]);
        dfs(heights,i+1,j,ocean,heights[i][j]);
        dfs(heights,i-1,j,ocean,heights[i][j]);
    }
}
