/**
  Idea: This is also another variant of count number of iceland problem only. Only difference is that while doing DFS it checks of current cell is candidate of subIceland or not if yes then all 4 sides DFS should also return subIslannd = true. 
 */
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0; 
        for (int i=0; i<grid2.length; i++){
            for (int j=0; j<grid2[0].length; j++){
                if (grid2[i][j] == 1 && dfs(grid2,grid1,i,j)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
    private boolean dfs(int[][] grid2, int[][] grid1, int row, int col){
        //If it is boundary or water cell just return true as they are neutral. 
        if (row < 0 || row >= grid2.length || col < 0 || col >= grid2[0].length || grid2[row][col] == 0){
            return true;
        }
        
        //Mark the land cell as water cell to consider it as visited visited. 
        grid2[row][col] = 0;
        boolean subIceland = false;

        //If current cell is land cell in grid1 also then return subIceland = true 
        if (grid1[row][col] == 1){
            subIceland = true;
        }
        
        //Now perform DFS to see if all 4 sides DFS traversal returns as subiceland. 
        for (int[] move : moves){
            int nrow = row + move[0];
            int ncol = col + move[1];
            if (nrow >=0 && nrow < grid2.length && ncol >=0 && ncol <grid2[0].length && grid2[nrow][ncol] == 1){
                subIceland = subIceland & dfs(grid2,grid1,nrow,ncol);
            }
        }
        
        return subIceland;
    }
}
