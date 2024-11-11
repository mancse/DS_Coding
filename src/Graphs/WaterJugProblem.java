package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/water-and-jug-problem/?envType=study-plan&id=graph-i
 * 
 * You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.
 *If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
Example 1:

Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 
Example 2:

Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false
Example 3:

Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 
Constraints:

1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106

Solution:
---------
Idea is that 4 operations here i.e fill and empty of each jugs are 4 possible children of current capacity node 
in graph like DS. So, start from current capacity 0 and perform BFS with 4 operations as children states. 

If target capacity is achieved then return true else return false. 

 * @author Manoj Kumar
 *
 */
public class WaterJugProblem {
	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        boolean visited[] = new boolean[jug1Capacity + jug2Capacity+1];
        //4 different types of operations could be like filling/emptying with jug1Capacity or jug2Capacity
        int[] operations = new int [] {jug1Capacity,-jug1Capacity,jug2Capacity,-jug2Capacity
};
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                int currCapacity = queue.poll();
                if (currCapacity == targetCapacity){
                    return true;
                }
                
                for (int j=0; j<operations.length; j++){
                    int nextCapacity = currCapacity +  operations[j];
                    if (nextCapacity >= 0 && nextCapacity <= (jug1Capacity + jug2Capacity) && !visited[nextCapacity]){
                        queue.add(nextCapacity);
                        visited[nextCapacity] = true;
                    }
                }
            }
        }
        
        return false;
    }
}
