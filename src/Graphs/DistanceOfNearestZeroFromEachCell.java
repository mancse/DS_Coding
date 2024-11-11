package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/?envType=study-plan&id=graph-i
 * 
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * 
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * @author Manoj Kumar
 * 
 * Solution:
 * ---------
 * Idea is to start BFS from each zero to other cells. So, insert all zero cell in queue initially and
 * mark them visited. Then on each level of traversal neighbouring cells which are not visited, increment 
 * level and insert into the neighbouring cells. 
 * 
 * So, ideally all cells with 1 initially, will be assigned 
 * with level value by BFS. 
 */
public class DistanceOfNearestZeroFromEachCell {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (mat[i][j] == 0){
                    //mark visited true for grid index which value is 0 as len for them going to be 0 only and then add in queue to make BFS.  
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                int pos[] = queue.poll();
                for (int j=0; j<dirs.length; j++){
                    int nr = pos[0] + dirs[j][0];
                    int nc = pos[1] + dirs[j][1];
                    
                    if (nr >=0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]){
                        mat[nr][nc] = level;
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
        return mat;
    }
}
