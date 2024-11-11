package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    
	static class Edge{
    	int src;
    	int nbr;
    	
    	public Edge(int src, int nbr){
    		this.src = src;
    		this.nbr = nbr;
    	}
    }
	
	public static void main(String args[]){
		int verts = 7;
		
		/**
		 * This is arrays of ArrayList of Edges. 
		 */
		ArrayList<Edge> graph[]= new ArrayList[verts];
		
		for (int i=0; i<verts; i++){
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[1].add(new Edge(1,2));
		graph[2].add(new Edge(2,3));
		graph[0].add(new Edge(0,3));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		graph[5].add(new Edge(5,6));
		graph[4].add(new Edge(4,6));
		
		boolean visited[] = new boolean[verts];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<verts; i++){
			if (visited[i] == false)
				topologicalSort(graph,visited,i,stack);
		}
		
		System.out.println("Topological sorting: ");
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
	
	private static void topologicalSort(ArrayList<Edge> graph[],boolean visited[], int src,Stack<Integer> stack){
		visited[src] = true;
		ArrayList<Edge> edges = graph[src];
		for (Edge edge : edges){
			 if (visited[edge.nbr] == false)
			 {
				 topologicalSort(graph,visited,edge.nbr,stack);
			 }
		}
		stack.push(src);
	}
}
