package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

https://leetcode.com/problems/merge-intervals/

 * @author Manoj Kumar
 * 
 * Idea: 
 * First sort the intervals based on first value of each interval. 
-Consider first interval as currentInterval and add it in result list
-Check until 2nd indexed value of current interval is greater than or equal to first indexed value 
 of interval
     -cInterval[1] = Math.max(cInterval[1],interval[1]);
    - else cInterval = interval and add the cInterval into result list. 

 *
 */

public class MergeIntervals 
{
	 public int[][] merge(int[][] intervals) 
	    {
	        if (intervals.length <=1)
	            return intervals;
	        //Sort the interval arrays based on first element value of each subarray. 
	        Arrays.sort(intervals,(arr1,arr2)-> Integer.compare(arr1[0],arr2[0]));
	        
	        int[] currInterval = intervals[0];
	        /*
	         * Take list of integer subarray. Reason, we don't know what will be the 
	         * final length of result array after merging the interval. 
	         */
	        List<int[]> list = new ArrayList<>();
	        
	        list.add(currInterval);
	        
	        for (int[] interval : intervals)
	        {
	            int curr_first = currInterval[0];
	            int curr_second = currInterval[1];
	            int next_first = interval[0];
	            int next_second = interval[1];
	            
	            if (curr_second >= next_first)
	            {
	                currInterval[1] = Math.max(curr_second,next_second);
	            }
	            else
	            {
	                currInterval = interval;
	                list.add(currInterval);
	            }
	        }
	        
	        /*
	         * Convert the resulted list into 2-D array to return as response(as return type of function is 2 D array). 
	         */
	        int[][] res = new int[list.size()][2];
	        for (int j=0; j<list.size(); j++){
	            res[j] = list.get(j);
	        }
	        return res;
	    }
	 
}
