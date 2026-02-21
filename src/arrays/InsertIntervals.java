/**
 *Idea:
    1. Add all intervals into output which ends before start of newInterval.
    2. Then merge all intervals into newInterval which starts overlaps whith newInterval end i.e whose start >= end of newInterval. 
    3. Then add all rest intervals whose starts after end of newInterval. 
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        
        //Add all intervals whose end < start of newInterval in the output list
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        //Merge the range whose ends overlaps with start of newInterval and whose start less than equal to end of new intervals.  
        while(i < intervals.length && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        //Add the merged range in the output list
        list.add(newInterval);

        //Add the remaining intervals in the output where interval start is greater than new interval end. 
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
