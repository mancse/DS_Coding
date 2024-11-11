package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan&id=graph-i
 * 
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two
 * different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in 
 * one direction because they are too narrow.Roads are represented by connections where connections[i] = [ai, bi] 
 * represents a road from city ai to city bi.This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 * 
 * Solution:
 * --------
 * Idea is to create non-cyclic graph using src and dest node in connections graph so that traversal can be performed. 
 * Also, maintain a directions map with key as "src-dest" and value as 1 and key as "dest-src" and value as -1. 
 * 
 * While performign DFS from 0 th node, if value in directions map is 1 then add in result count. Finally return count as answer. 
 * @author Manoj Kumar
 *
 */
public class ReorderRoutesToMakeAllPathsLeadToCityZero {
	public int minReorder(int n, int[][] connections) {
        Map<String,Integer> directions = new HashMap<String,Integer>();
        Map<Integer,List<Integer>> graph = createGraph(connections,directions);
        
        Set<Integer> visited = new HashSet<>();
        int count = dfs(graph, 0,visited,directions);
        
        return count;
    }
    
    int dfs(Map<Integer,List<Integer>> graph, int src, Set<Integer> visited, Map<String,Integer> directions){
        visited.add(src);
        List<Integer> nbrs = graph.get(src);
        
        if (nbrs == null){
            return 0;
        }
        
        int count = 0; 
        
        for (int nbr : nbrs){
            if (!visited.contains(nbr)){
                int incr = directions.containsKey(src+"-"+nbr) && directions.get(src+"-"+nbr) == 1 ? 1 : 0;
                count += dfs(graph,nbr,visited,directions) + incr ; 
            }
        }
        
        return count;
    }
    private Map<Integer, List<Integer>> createGraph(int[][] connections,Map<String,Integer> directions){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for (int i=0; i<connections.length; i++){
            int[] connection = connections[i];
            int src = connection[0];
            int dst = connection[1];
            
            if (!graph.containsKey(src)){
                List<Integer> list = new ArrayList<>();
                list.add(dst);
                graph.put(src,list);
                directions.put(src+"-"+dst,1);
            }
            else{
                graph.get(src).add(dst);
                directions.put(src+"-"+dst,1);
            }
            
            if (!graph.containsKey(dst)){
                List<Integer> list = new ArrayList<>();
                list.add(src);
                graph.put(dst,list);
                directions.put(dst+"-"+src,-1);
            }
            else{
                graph.get(dst).add(src);
                directions.put(dst+"-"+src,-1);
            }
        }
        return graph;
    }
}
