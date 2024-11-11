package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/as-far-from-land-as-possible/?envType=study-plan&id=graph-i
 * 
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, 
 * find a water cell such that its distance to the nearest land cell is maximized, and return the distance. 
 * If no land or water exists in the grid, return -1.
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and 
 * (x1, y1) is |x0 - x1| + |y0 - y1|.
 */
public class AsFarFromLandAsPossible {
public int maxDistance(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == 1){
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    queue.add(pos);
                }
            }
        }
        int count = 0;
        if (queue.size() == rows * cols){
            return -1;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for (int i=0; i < size; i++){
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                
                if (r + 1 < rows && grid[r+1][c] == 0){
                    grid[r+1][c] = 2;//visited
                    int[] npos = new int[2];
                    npos[0] = r + 1;
                    npos[1] = c;
                    queue.add(npos);
                }
                
                if (r - 1 >= 0 && grid[r-1][c] == 0){
                    grid[r-1][c] = 2;//visited
                    int[] npos = new int[2];
                    npos[0] = r -1;
                    npos[1] = c;
                    queue.add(npos);
                }
                
                if (c + 1 < cols && grid[r][c+1] == 0){
                    grid[r][c+1] = 2;//visited
                    int[] npos = new int[2];
                    npos[0] = r;
                    npos[1] = c+1;
                    queue.add(npos);
                    
                }
                
                if (c - 1 >= 0 && grid[r][c-1] == 0){
                    grid[r][c-1] = 2;//visited
                    int[] npos = new int[2];
                    npos[0] = r;
                    npos[1] = c-1;
                    queue.add(npos);
                }
            }
            count++;
        }
        
        return count-1;
    }
}
