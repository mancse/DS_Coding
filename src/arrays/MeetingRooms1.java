package arrays;

import java.util.Arrays;

/**
 * 252. Meeting Rooms
Easy

1523

74

Add to List

Share
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true

https://leetcode.com/problems/meeting-rooms/

 * @author Manoj Kumar
 *
 */
public class MeetingRooms1 {
	 public boolean canAttendMeetings(int[][] intervals) {
	        Arrays.sort(intervals,(i1,i2) -> i1[0] - i2[0]);
	        
	        for (int i=1; i<intervals.length; i++){
	            if (intervals[i-1][1] > intervals[i][0]){
	                return false;
	            }
	        }
	        
	        return true;
	    }
}
