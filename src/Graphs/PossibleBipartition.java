package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/possible-bipartition/?envType=study-plan&id=graph-i
 * 
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 
 Example 1:
Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 
Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.


Solution:
---------
Idea here is that first make a undirectional graph with people vs the list of people whom he dislikes. Then
assign each person in two different group i.e group 1 and group 2. Following is BFS approach. 
1. Add the first person i.e 1 in the queue and assign it to group 1. 
2. Loop through queue until queue is not empty
   -Remove element from queue and find all its rivals from the graph. 
   -if group of it's rival is equal to it's own group then return false. 
   -Else if group of current person is 1 then assign it to group 2 and if group of current person is 2
    then assign group of it's rival to group 1. 
3. When whole queue is traversed and all persons are allocated in two different groups then return true. 
 * @author Manoj Kumar
 *
 */
public class PossibleBipartition {
	public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer,List<Integer>> graph = createGraph(dislikes);
        int group[] = new int[n+1];
        
        Queue<Integer> queue = new LinkedList();
        for (int i=1; i<=n ; i++){
        	//Need to assign group-1 or group-2 only when person is not assigned with any group. 
        	//If during BFS traversal, if any person is already assigned to group-1 or group-2 then
        	//no need to further process for that node or person. 
            if (group[i] ==0){
                queue.add(i);
                group[i] = 1;
                while(!queue.isEmpty()){
                    int p = queue.poll();
                    List<Integer> rivals = graph.get(p);
                    if (rivals != null && rivals.size() > 0){
                        for (int r : rivals){
                        if (group[p] == group[r]){
                            return false;
                        }
                        else if (group[r] == 0){
                            if (group[p] == 1){
                                group[r] = 2;
                            }
                            else{
                                group[r] = 1;
                            }
                            queue.add(r);
                         }
                       }
                    }
                }
            }
        }
        return true;
    }
    
    private Map<Integer,List<Integer>> createGraph(int[][] dislikes){
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        for (int i=0; i<dislikes.length; i++){
            int c1 = dislikes[i][0];
            int c2 = dislikes[i][1];
            
            if (!graph.containsKey(c1)){
                List<Integer> list = new ArrayList<>();
                list.add(c2);
                graph.put(c1,list);
            }
            else{
                graph.get(c1).add(c2);
            }
            
            if (!graph.containsKey(c2)){
                List<Integer> list = new ArrayList<>();
                list.add(c1);
                graph.put(c2,list);
            }
            else{
                graph.get(c2).add(c1);
            }
        }
            
        return graph;
    }
}
