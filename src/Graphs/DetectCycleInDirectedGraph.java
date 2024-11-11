package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
	static class Edge{
    	int src;
    	int nbr;
    	
    	public Edge(int src, int nbr){
    		this.src = src;
    		this.nbr = nbr;
    	}
    }
	private static boolean isCycle(List<ArrayList<Edge>> graph,int v){
		boolean visited[] = new boolean[v];
		/**
		 * Traverse through all vertices and check if cycle is found while doing DFS from any vertex.
		 */
		for (int i=0; i<v ; i++){
			if (!visited[i])
					if(isCycleFound(graph,i,visited))
						return true;
		}
		return false;
	} 
	
	private static boolean isCycleFound(List<ArrayList<Edge>> graph,int i,boolean visited[]){
		
		/**
		 * If there is a cycle in the graph at vertex i, then flow will come to here where visited flag
		 * is already set as true because backtracking step won't execute in that case. Hence, cycle is found.
		 */
		if (visited[i])
			return true;
		
		visited[i]=true;
		
		ArrayList<Edge> edges = graph.get(i);
		
		for (Edge edge : edges){
				if (isCycleFound(graph,edge.nbr,visited))
					return true;
		}
		/**
		 * Once all connected vertices are visited from a particular vertex without cycle then 
		 * Backtrack and set visited of particular vertex as false.
		 */
		
		visited[i] = false;
		return false;
	}
	
	public static void main(String args[]){
		int verts = 4;
		List<ArrayList<Edge>> graph = new ArrayList<>();
		
		for (int i=0; i<verts; i++){
			graph.add(new ArrayList<Edge>());
		}
		
		graph.get(0).add(new Edge(0,1));
		graph.get(0).add(new Edge(0,2));
		graph.get(1).add(new Edge(1,2));
		graph.get(2).add(new Edge(2,0));
		graph.get(2).add(new Edge(2,3));
		//graph.get(3).add(new Edge(3,3));
		boolean isCycle = isCycle(graph,verts);
		System.out.println("Cycle found: "+isCycle);
	}
}
