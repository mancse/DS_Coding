package Graphs;

import java.util.ArrayList;
import java.util.List;
/**
 * Idea: Perform DFS on every vertex of the graph to check if cycle is found while doing DFS from any
 * of the vertex. 
 *     While doing DFS, pass parent vertex to each call of the DFS and check if neighbour vertex is already
 *     visited and if it is not equal to parent vertex then it means cycle is present. 
 * 
 * @author Manoj.K
 *
 */
public class DetectCycleInUndirectedGraph {
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
				if(isCycleFound(graph,i,visited,-1))
					return true;
		}
		return false;
	}
	
	private static boolean isCycleFound(List<ArrayList<Edge>> graph,int vertex,boolean visited[],int parent){
		visited[vertex] = true;
		
		ArrayList<Edge> edges = graph.get(vertex);
		
		for (Edge edge : edges){
			if (!visited[edge.nbr]){
				if (isCycleFound(graph,edge.nbr,visited,edge.src))
					return true;
			}
			else{
				/**
				 * If neighbour vertex is already visited and if it is not equal to parent then it means
				 * back edge is present and hence cycle is there. 
				 */
				if (edge.nbr != parent)
					return true;
			}
		}
		return false;
	}
	public static void main(String args[]){
		int verts = 3;
		List<ArrayList<Edge>> graph = new ArrayList<>();
		
		for (int i=0; i<verts; i++){
			graph.add(new ArrayList<Edge>());
		}
		
		graph.get(0).add(new Edge(0,1));
		graph.get(1).add(new Edge(1,0));
		graph.get(1).add(new Edge(1,2));
		graph.get(2).add(new Edge(2,1));
		graph.get(2).add(new Edge(2,0));
		graph.get(0).add(new Edge(0,2));
		
		boolean isCycle = isCycle(graph,verts);
		System.out.println("Cycle found: "+isCycle);
	}
}
