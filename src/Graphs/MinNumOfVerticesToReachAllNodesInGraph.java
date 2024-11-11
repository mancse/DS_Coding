package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/?envType=study-plan&id=graph-i
 * 
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
 * Notice that you can return the vertices in any order.
 
 Solution:
 ---------
 Those nodes which have indegree count is 0 then those nodes are not at all reachable from any node. So, 
 all nodes which indegree is 0 are part of answer. 

 * @author Manoj Kumar
 *
 */
public class MinNumOfVerticesToReachAllNodesInGraph {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegrees = new int[n];
        
        for (int i=0; i<edges.size(); i++){
            List<Integer> edge = edges.get(i);
            int src = edge.get(0);
            int dst = edge.get(1);
            indegrees[dst]++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i<indegrees.length; i++){
            if (indegrees[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
