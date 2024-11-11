package Graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-provinces/?envType=study-plan&id=graph-i
 * 
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

 * Return the total number of provinces.
 * @author Manoj Kumar
 *
 */
public class NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        
        for (int i=0; i<n; i++){
            if (!visited.contains(i)){
                visited.add(i);
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs (int[][] isConnected, int i, Set<Integer> visited){
        int[] nbrs = isConnected[i];
        
        for (int j=0; j<nbrs.length; j++){
            if(isConnected[i][j] ==1 && !visited.contains(j)){
                visited.add(j);
                dfs(isConnected,j,visited);
            }
        }
    }
}
