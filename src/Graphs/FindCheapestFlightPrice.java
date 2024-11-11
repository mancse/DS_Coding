package Graphs;
import java.util.*;

/*
 * Cheapest Flights Within K Stops
 * 
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 * 
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 
 */
public class FindCheapestFlightPrice {
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<String,Integer> costMap = createCostMap(flights);
        Map<Integer,List<Integer>> graph = createGraph(flights);
        boolean visited[] = new boolean[n];
        int res = cheapestPriceDFS(graph,costMap,src,dst,k,0,Integer.MAX_VALUE,visited);
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private static int cheapestPriceDFS(Map<Integer,List<Integer>> graph, Map<String,Integer> costMap,int src, int dst, int k, int currPrice, int minPrice, boolean[] visited){
        /**
         * Following condition is kept because k is considered as steps without source and destination. 
         * But, here we are decrementing for each src vertex except dest vertex, so one extra decrement. 
         * Hence,instead of base condition as k < 0, I am putting k < -1.  
         */
    	if (k < -1){
            return minPrice;
        }
        
    	//Here when src is equal to dst, k is not decremented. 
        if (src == dst){
            minPrice = Math.min(minPrice,currPrice);
            return minPrice;
        }
        //Here, visited array is to avoid any cycle in the graph. 
        visited[src] = true;
        List<Integer> nbrs = graph.get(src);
        if (nbrs != null){
            for (int nbr : nbrs){
                int cost = costMap.get(src+""+nbr);
                if (!visited[nbr] && currPrice + cost <= minPrice){
                    minPrice = cheapestPriceDFS(graph,costMap,nbr,dst,k-1,currPrice+cost,minPrice,visited);
                }
            }
        }
        //Backtrack.
        visited[src] = false;
        return minPrice;
    }
    
    private static  Map<String,Integer> createCostMap(int[][] flights){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dst = flights[i][1];
            int cost = flights[i][2];
            
            map.put(src+""+dst, cost);
        }
        return map;
    }
    
    private static Map<Integer,List<Integer>> createGraph(int[][] flights){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for (int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dst = flights[i][1];
            
            List<Integer> nbrs = graph.get(src);
            if (nbrs == null){
                nbrs = new ArrayList<>();
                graph.put(src,nbrs);
            }
            nbrs.add(dst);
        }
        return graph;
    }
}
