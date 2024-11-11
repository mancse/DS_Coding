package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * @author Manoj Kumar
 *
 */
public class AllPathsFromSourceToTarget {
	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	        List<List<Integer>> result = new ArrayList<>();
	        dfs(graph,result,0,graph.length - 1, new ArrayList<Integer>());
	        return result;
	    }
	    
	    private void dfs(int[][] graph, List<List<Integer>> result, int src, int dest, List<Integer> list){
	        if (src == dest){
	            list.add(src);
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
	        list.add(src);
	        int[] nbrs = graph[src];
	        
	        for (int i=0; i<nbrs.length; i++){
	                dfs(graph,result,nbrs[i],dest, list);
	                list.remove(list.size() - 1);
	        }
	    }
}
