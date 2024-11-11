package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/*
 * Do topological sorting of vertices of the graph.
 * input[][]={{0,1},{1,2},{2,3},{0,3},{4,3},{4,5},{5,6},{4,6}}
 * 
 * Output: 0 4 1 5 2 6 3
 * 
 * Idea: 
 *   1.) Take indegree[] array to store count of inwards vertices coming to the vertex. 
 *   2.) Add those vertices in a queue whose indegree count is zero. 
 *   3.) Loop while queue is not empty
 *       -remove vertex from queue and lets say it as current vertex
 *       -Add this vertex in the result set.
 *       -decrement indegree count for neighbouring vertices of the current vertex. 
 *       -If indegree ount for neighbouring vertex =0 then add that index into queue again. 
 */
public class TopologicalSortByBFS {
	
	public static List<Integer> topologicalSortByBFS(int v, Map<Integer,ArrayList<Integer>> graph){
		int indegree[] = new int[v];
		
		for (int i=0; i<v; i++){
			List<Integer> nbrs = graph.get(i);
			if (nbrs != null){
				for (Integer nbr : nbrs){
					indegree[nbr]++; 
				}
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=0; i<v; i++){
			if (indegree[i] == 0){
				queue.add(i);
			}
		}
		List<Integer> result = new ArrayList<>();
		int count = 0;
		while(!queue.isEmpty()){
			int i = queue.poll();
			result.add(i);
			
			List<Integer> nbrs = graph.get(i);
			if (nbrs != null){
				for (Integer nbr : nbrs){
					indegree[nbr]--;
					count++;
					if (indegree[nbr] == 0){
						queue.add(nbr);
					}
				}
			}
		}
		
		if (count-1 != v){
			System.out.println("\nCount: "+count+" Graphh is cyclic and cant be sorted topologically");
		}
		return result;
	}
    private static Map<Integer,ArrayList<Integer>> createGraph(int[][] input){
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for (int i=0; i<input.length; i++)
        {
            int src = input[i][0];
            int dst = input[i][1];
            ArrayList<Integer> nbrs = graph.get(src);
            if (nbrs == null){
                nbrs = new ArrayList<Integer>();
                graph.put(src,nbrs);
            }
            nbrs.add(dst);
        }
        return graph;
    }
    
    public static void main(String args[]){
    	int input[][]={{0,1},{1,2},{2,3},{0,3},{4,3},{4,5},{5,6},{4,6}};
    	Map<Integer,ArrayList<Integer>> graph = createGraph(input);
    	
    	for (int i : graph.keySet()){
    		System.out.print(" Key: "+i);
    		List<Integer> nbrs = graph.get(i);
    		System.out.print(" Values: " );
    		for (int nbr : nbrs){
    			System.out.print(" "+nbr);
    		}
    	}
    	
    	
    	List<Integer> result = topologicalSortByBFS(7,graph);
    	System.out.println("Topological sorted: ");
    	for (Integer i : result){
    		System.out.print(" "+i);
    	}
    	
    }
}
