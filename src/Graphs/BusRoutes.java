package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/bus-routes/
 * 
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 
 Example 1:
 Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 Output: 2
 Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

 Example 2:
 Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 Output: -1
 
 Constraints:
 1 <= routes.length <= 500.
 1 <= routes[i].length <= 105
 All the values of routes[i] are unique.
 sum(routes[i].length) <= 105
 0 <= routes[i][j] < 106
 0 <= source, target < 106
 
 * @author Manoj Kumar
 *
 */
public class BusRoutes {
	public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stopToBussesMap = new HashMap<>();
        for(int i=0; i<routes.length; i++) {
            for(int j=0; j<routes[i].length; j++) {
                if(stopToBussesMap.containsKey(routes[i][j])){
                    stopToBussesMap.get(routes[i][j]).add(i);
                }else{
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    stopToBussesMap.put(routes[i][j], lst);
                }
            }
        } 
        return bfs(routes, stopToBussesMap, source, target);
        
    }
    
    int bfs(int[][] routes, Map<Integer, List<Integer>> map,int source, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curStop = q.poll();
                if(curStop == target) {
                    return level;
                }
                List<Integer> buses = map.get(curStop);
                for(int j=0; j<buses.size(); j++) {
                    int bus = buses.get(j);
                    //If a bus is not picked yet, then pick the bus and check all it's stops to which this bus
                    //goes and add them in the queue. So, mark that bus as visited. 
                    if(!visited.contains(bus)){
                        visited.add(bus);
                        int[] nextStops = routes[bus];
                        for(int k=0; k<nextStops.length; k++) {
                            q.add(nextStops[k]);
                        }   
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
