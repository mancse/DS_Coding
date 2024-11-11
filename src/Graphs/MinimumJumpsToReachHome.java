package Graphs;
import java.util.*;
/**
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/?envType=study-plan&id=graph-i
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.

The bug jumps according to the following rules:

It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.

Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.

Example 1:

Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
Output: 3
Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
Example 2:

Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
Output: -1

Constraints:
1 <= forbidden.length <= 1000
1 <= a, b, forbidden[i] <= 2000
0 <= x <= 2000
All the elements in forbidden are distinct.
Position x is not forbidden.

Solution: 
---------
Idea is to perform BFS starting from 0th index and check if bug reaches to position x, if it reaches then
return the number of levels traversed in BFS as answer. 

To solve this question, also keep on tracking the last movement to see if last movement was having any 
backward movement if yes then bug can move only forward else bug can move forward as well as backward. 
So, to do that use class position which includes position index and backward. 


 * @author Manoj Kumar
 *
 */
public class MinimumJumpsToReachHome {
	class Position{
        int pos;
        int backward;
        
        public Position(int pos, int backward){
            this.pos = pos;
            this.backward = backward;
        }
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0));
        Set<String> visited = new HashSet<>();
        visited.add(0+"-"+0);
        
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int i=0; i<forbidden.length; i++){
            forbiddenSet.add(forbidden[i]);
        }
        int steps = 0;
        int maxLength = 2000 + a + b; //Bug can't go beyond this length.
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                Position curPos = queue.poll();
                if (curPos.pos == x){
                    return steps;
                }
                
                //If last move was backward, then next mmove can only be forward.
                if (curPos.backward == 1){
                    int nPos = curPos.pos + a;
                    if (nPos >=0 && nPos < maxLength && !visited.contains(nPos+"-"+0) && !forbiddenSet.contains(nPos)){
                        visited.add(nPos+"-"+0);
                        Position nextPos = new Position(nPos,0);
                        queue.add(nextPos);
                    }
                }
                else{
                //Else if last move was forward, then next move can be either forward or backward
                    int nPos = curPos.pos + a;
                    if (nPos >=0 && nPos < maxLength && !visited.contains(nPos+"-"+0) && !forbiddenSet.contains(nPos)){
                        visited.add(nPos+"-"+0);
                        Position nextPos = new Position(nPos,0);
                        queue.add(nextPos);
                    }
                    
                    nPos = curPos.pos -b;
                    if (nPos >=0 && nPos < maxLength && !visited.contains(nPos+"-"+1) && !forbiddenSet.contains(nPos)){
                        visited.add(nPos+"-"+1);
                        Position nextPos = new Position(nPos,1);
                        queue.add(nextPos);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
