package Graphs;
import java.util.*;
/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by
 * a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning
 * there is an edge from node i to each node in graph[i].A node is a terminal node if there are no outgoing edges. 
 * A node is a safe node if every possible path starting from that node leads to a terminal node 
 * (or another safe node).Return an array containing all the safe nodes of the graph. The answer should be sorted in
 * ascending order.
 * 
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 * 
 * 
 * Solution: Idea is that if path from any node eventually lands up in a cycle, then that node can't be part of eventual
 * safe nodes because that node can't reach up to terminal node. Also, if any node is directed to other node which is already
 * part of the cycle then this node will also not be safe node. 
 * 
 * Hence, Need to write DFS logic to find if cycle is formed from any node in the graph. Also, memorize if cycle exists in any node so 
 * that result can be directly returned if that node comes in path from any other node. 
 * 
 * Finally, loop through all node and check in memoization map that if node is not part of cycle then add it in answer. 
 * @author Manoj Kumar
 *
 */
public class FindEventualSafeStates {
	public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
       
        boolean visited[] = new boolean[n];
        Map<Integer, Boolean> memoize = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i=0; i<n ; i++){
            if (!visited[i]){
                memoize.put(i,isCycle(graph,i,visited,memoize));
            }
        }
        
        
        for (int i=0; i<n; i++){
            if (!memoize.get(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    
    private boolean isCycle(int[][] graph, int i, boolean[]visited, Map<Integer,Boolean> memoize){
        
        if (memoize.containsKey(i)){
            return memoize.get(i);
        }
        
        if (visited[i]){
            return true;
        }
        
        visited[i] = true;
        
        int[] children = graph[i];
        
        for (int child : children){
            if (isCycle(graph,child,visited,memoize)){
                memoize.put(child,true);
                return true;
            }
        }
        
        memoize.put(i,false);
        
        //Backtrack
        visited[i] = false;
        
        return false;
    }
}
