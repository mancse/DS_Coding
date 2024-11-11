package Graphs;
/**
 * https://leetcode.com/problems/number-of-closed-islands/?envType=study-plan&id=graph-i
 * 
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * Return the number of closed islands.
 * @author Manoj Kumar
 *
 */
public class NumberOfClosedIceLand {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i=1; i < grid.length - 1; i++){
            for (int j=1; j < grid[0].length - 1 ; j++){
                if (grid[i][j] == 0){
                    if (dfs(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    
    private boolean dfs(int[][] grid, int i, int j){
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1){
            return false;
        }
        
        if (grid[i][j] == 1 || grid[i][j] == 2){
            return true;
        }
        
        grid[i][j] = 2;
        
        boolean bf = dfs(grid, i+1, j);
        boolean uf = dfs(grid, i-1, j);
        boolean rf = dfs(grid, i, j+1);
        boolean lf = dfs(grid, i, j-1);
        
        return (bf && uf && rf && lf);
    }
}
