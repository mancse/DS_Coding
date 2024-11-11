package Graphs;

import java.util.ArrayList;
import java.util.List;

public class HasPathBetween2Vertices {
	static class Edge{
    	int src;
    	int nbr;
    	
    	public Edge(int src, int nbr){
    		this.src = src;
    		this.nbr = nbr;
    	}
    }
	
	public static void main(String args[]){
		int verts = 9;
		List<ArrayList<Edge>> graph = new ArrayList<>();
		
		for (int i=0; i<verts; i++){
			graph.add(new ArrayList<Edge>());
		}
		
		graph.get(0).add(new Edge(0,1));
		graph.get(1).add(new Edge(1,2));
		graph.get(2).add(new Edge(2,3));
		graph.get(0).add(new Edge(0,3));
		graph.get(3).add(new Edge(3,4));
		graph.get(4).add(new Edge(4,5));
		graph.get(5).add(new Edge(5,6));
		graph.get(4).add(new Edge(4,6));
		graph.get(4).add(new Edge(4,7));
		
		graph.get(3).add(new Edge(3,8));
		boolean visited[] = new boolean[verts]; 
		boolean hasPath1 = hasPath(graph,visited,0,6);
		System.out.println("Has Path:  "+hasPath1);
		
		boolean hasPath2 = hasPath(graph,visited,4,8);
		System.out.println("Has Path:  "+hasPath2);
		
		System.out.println("All paths are: ");
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		printAllPath(graph,0,6,sb);
	}
	
	private static boolean hasPath(List<ArrayList<Edge>> graph,boolean visited[], int src, int dest){
		//Base condition
		if (src == dest){
			return true;
		}
		visited[src] = true;
		ArrayList<Edge> edges = graph.get(src);
		for (Edge edge : edges){
			/*
			 * Check if there is path from it's neighbour vertice to dest. If yes,
			 * then there will be path from src vertice to destination also.
			 */
			 if (visited[edge.nbr] == false)
			 {
				 if (hasPath(graph,visited,edge.nbr,dest))
				 return true;
			 }
		}
		return false;
	}
	
	private static void printAllPath(List<ArrayList<Edge>> graph, int src, int dest,StringBuilder psf){
		//Base condition
		if (src == dest){
			System.out.println(" "+psf.toString());
			return;
		}
		
		ArrayList<Edge> edges = graph.get(src);
		for (Edge edge : edges){
				 printAllPath(graph,edge.nbr,dest,psf.append(edge.nbr));
				 psf.deleteCharAt(psf.length()-1);
		}
	}
}
