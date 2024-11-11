package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
represent the start and the end of the ith interval and intervals is sorted in ascending order by 
starting. You are also given an interval newInterval = [start, end] that represents the start and
end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starting
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
 * @author Manoj Kumar
 *
 *Idea:
 *First sort the intervals based on first value of each interval. 
  The follow 3 steps as below:
    1. Add all intervals into output which ends before start of newInterval.
    2. Then merge all intervals into newInterval which starts before end of newInterval and then add merged interval into output. 
    3. Then add all rest intervals which starts after end of newInterval. 
 */
class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    	
    	if (intervals.length <=1)
	            return intervals;
    	
    	Arrays.sort(intervals,(arr1,arr2) -> (arr1[0] - arr2[0]));
        List<int[]> list = new ArrayList<int[]>();
        
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        //Merge all such intervals
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        
        int[][] res = new int[list.size()][2];
        for (int j=0; j<list.size(); j++){
            res[j] = list.get(j);
        }
    return res;
    }
}
