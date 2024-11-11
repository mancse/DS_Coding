package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/keys-and-rooms/?envType=study-plan&id=graph-i
 * 
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

 

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

Solution:
Idea is to simply perform BFS from very first key and get on another set of keys from rooms array and traverse
each level of the graph. Once all graph is visited, just check if visited set size is equal to rooms.size() then
it means all keys retrieved to open all rooms. 

 * @author Manoj Kumar
 * 
 */
public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        queue.add(0);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                int room = queue.poll();
                List<Integer> keys = rooms.get(room);
                if (keys != null && !keys.isEmpty()){
                    for(int j = 0; j < keys.size() ; j++){
                        int key = keys.get(j);
                        if (!visited.contains(key)){
                            visited.add(key);
                            queue.add(key);
                        }
                    }
                }
            }
        }
        
        if (visited.size() == rooms.size()){
            return true;
        }
        return false;
    }
}
