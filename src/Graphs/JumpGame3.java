package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/jump-game-iii/?envType=study-plan&id=graph-i
 * 
 * Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

Solution:
---------
The movement to next index from current index can have two possiblities i.e forward direction or backward. 
It forms a graph kind of data structure. So, Idea is to perform graph traversal in DFS or BFS fashion starting
from givne start index and check if we reach at index having zero. If yes then return true. 

If traversal is complete but no index with value zero is foudn then return false.
 * @author Manoj Kumar
 *
 */
public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for (int i=0; i<size; i++){
                int index = queue.poll();
                if(arr[index] == 0){
                    return true;
                }
                
                int nextIndex = index + arr[index];
                
                if (nextIndex < arr.length && !visited.contains(nextIndex)){
                    visited.add(nextIndex);
                    queue.add(nextIndex);
                }
                
                nextIndex = index - arr[index];
                
                if (nextIndex >= 0 && !visited.contains(nextIndex)){
                    visited.add(nextIndex);
                    queue.add(nextIndex);
                }
            }
        }
        
        return false;
    }
}
