package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/?envType=study-plan&id=graph-i
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 * You are given an initial computer network connections.You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 * 
 * Solution:
 * ---------
 * Idea is to find the number of disconnected components. So, if number of disconnected 
 * components are 2 then minimum 1 connection would be required to connect them. Similarly 
 * if disconnected components are 3 then 2 connections would be required. So, answer would be 
 * number of disconnected components - 1. 
 * 
 * 
 * @author Manoj Kumar
 *
 */
public class NumberOfOperationToMakeNetworkConnected {
	 public int makeConnected(int n, int[][] connections) {
	        if (connections.length < n-1)
	            return -1;
	        
	        Map<Integer,List<Integer>> graph = createGraph(connections);
	        
	        Set<Integer> visited = new HashSet<>();
	        int count = 0;
	        
	        for (int i=0; i < n; i++){
	            if (!visited.contains(i)){
	                dfs(graph,i,visited);
	                count++;
	            }
	        }
	        
	        return count -1;
	    }
	    
	    private void dfs(Map<Integer,List<Integer>> graph, int i,Set<Integer> visited){
	        visited.add(i);
	        List<Integer> nbrs = graph.get(i);
	        if (nbrs == null)
	            return;
	        for (int nbr : nbrs){
	            if (!visited.contains(nbr)){
	                dfs(graph,nbr,visited);
	            }
	        }
	    }
	    
	    private Map<Integer,List<Integer>> createGraph(int[][]connections){
	        Map<Integer,List<Integer>> graph = new HashMap<>();
	        for (int i=0; i<connections.length; i++){
	            int v1 = connections[i][0];
	            int v2 = connections[i][1];
	            
	            if (!graph.containsKey(v1)){
	                List<Integer> list = new ArrayList<>();
	                list.add(v2);
	                graph.put(v1,list);
	            }
	            else{
	                List<Integer> list = graph.get(v1);
	                list.add(v2);
	            }
	            
	            if (!graph.containsKey(v2)){
	                List<Integer> list = new ArrayList<>();
	                list.add(v1);
	                graph.put(v2,list);
	            }
	            else{
	                List<Integer> list = graph.get(v2);
	                list.add(v1);
	            }
	        }
	        return graph;
	    }
}
