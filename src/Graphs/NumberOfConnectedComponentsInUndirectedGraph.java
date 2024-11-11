package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * @author Manoj Kumar
 *
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
	public static int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        int count = 0;
        Map<Integer,List<Integer>> graph = createGraph(edges);
        for (int i=0; i<n; i++){
            if (!visited[i])
                count += dfs(graph, i,visited);
        }
        return count;
    }
    
    private static int dfs(Map<Integer,List<Integer>> graph, int i, boolean[] visited){
        visited[i] = true;
        List<Integer> nbrs = graph.get(i);
        if (nbrs != null){
            for (int nbr : nbrs){
                if (!visited[nbr])
                    dfs(graph,nbr,visited);
            }
        }
        return 1;
    }
    private static Map<Integer,List<Integer>> createGraph(int[][] edges){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            List<Integer> nbrs = graph.get(src);
            if (nbrs == null){
                nbrs = new ArrayList<Integer>();
                graph.put(src,nbrs);
            }
            nbrs.add(dst);
            
            List<Integer> nbrs1 = graph.get(dst);
            if (nbrs1 == null){
                nbrs1 = new ArrayList<Integer>();
                graph.put(dst,nbrs1);
            }
            nbrs1.add(src);
        }
        return graph;
    }
}
