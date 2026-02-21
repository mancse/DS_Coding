/**
** Problem: https://leetcode.com/problems/number-of-distinct-islands/?q=island
** Idea: Relative position of each cell of iceland added as string and added in set. After traversing whole grid the total size of set is the answer. 
*/
class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> distIcelands = new HashSet<>();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,i,j, sb);
                    distIcelands.add(sb.toString());
                }
            }
        }
        return distIcelands.size();
    }
    
    int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int[][] grid,int row, int col, int baseRow, int baseCol, StringBuilder sb){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return;
        }
        
        //Mark the grid as visited. 
        grid[row][col] = 2;

        //Add the relative position (i.e row and column wrt base row & col position in the string)
        sb.append(row - baseRow).append(",").append(col - baseCol);
        
        for (int[] move : moves){
            int nrow = row + move[0];
            int ncol = col + move[1];
            if (nrow >=0 && nrow < grid.length && ncol >=0 && ncol < grid[0].length && grid[nrow][ncol] == 1){
                //Mark it visited.
                grid[nrow][ncol] = 2;
                dfs(grid,nrow,ncol,baseRow,baseCol,sb);
            }
        }

    }
}
