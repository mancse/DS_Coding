package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/is-graph-bipartite/description/
 * 
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 * Return true if and only if it is bipartite.
 * 
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
 * 
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 * 
 * Solution:
 * ---------
 * 
 * Consider 0: no color, 1 - blue, -1: red. Start with first node to color as blue. Then perform BFS to find all neighbours. 
   Check color of neighbour is equal to current node color then it is conflicting situation so return false.
   Else if neighbour is not colored then color it as oppostite color to the current node and add it again in the queue for further processing. 
   If whole graph is colored and BFS is complete then return true means graph is bipartite graph. 
   
 * @author Manoj Kumar
 *
 */
public class IsGraphBipertite {
	
	    public boolean isBipartite(int[][] graph) {
	        int[] color = new int[graph.length];
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i=0; i<graph.length; i++){
	            if (color[i] == 0){
	                queue.add(i);
	                color[i] = 1;
	                while(!queue.isEmpty()){
	                    int n = queue.poll();
	                    int[] nbrs = graph[n];
	                    for (int nbr: nbrs){
	                        if (color[n] == color[nbr]){
	                            return false;
	                        }
	                        else if (color[nbr] == 0){
	                            queue.add(nbr);
	                            color[nbr] = -color[n];
	                        }
	                    }
	                }
	            }
	        }
	        return true;
	    }
}
