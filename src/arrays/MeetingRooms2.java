package arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

https://leetcode.com/problems/meeting-rooms-ii/

 * @author Manoj Kumar
 *
 */
public class MeetingRooms2 {
	public static int minMeetingRooms(int[][] intervals) {
        int[] stime = new int[intervals.length];
        int[] etime = new int[intervals.length];
        
        for (int i=0; i < intervals.length; i++){
            stime[i] = intervals[i][0];
            etime[i] = intervals[i][1];
        }
        
        Arrays.sort(stime);
        Arrays.sort(etime);
        
        int rooms = 0; 
        int minrooms = 0;
        int i=0; 
        int j=0;
        while (i < stime.length && j < etime.length){
            if (stime[i] < etime[j])
            {
                rooms++;
                i++;
            }
            else{
                rooms--;
                j++;
            }
            minrooms = Math.max(minrooms,rooms);
        }
        return minrooms;
    }
	
	public static void main(String args[]) {
		int [][] intervals= {{0,30},{5,10},{15,20}};
		 	System.out.println("Minimum Meeting Room: "+minMeetingRooms(intervals));
	}
}
