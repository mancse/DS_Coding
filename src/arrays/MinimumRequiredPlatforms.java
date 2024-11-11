package arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given arrival and departure times of all trains that reach a railway station, the task is to find the 
 * minimum number of platforms required for the railway station so that no train waits.
 * @author Manoj.K
 *
 * The idea is to consider all events in sorted order. Once we have all events in sorted order, 
 * we can trace the number of trains at any time keeping track of trains that have arrived, but not departed.
 * For example consider the above example.

    arr[]  = {9:00,  9:40,  9:50,  11:00, 15:00, 18:00}
    dep[]  = {9:10,  11:20, 11:30, 12:00, 19:00, 20:00}

 * All events sorted by time.
 * Total platforms at any time can be obtained by subtracting total 
 * departures from total arrivals by that time.
 *  Time     Event Type     Total Platforms Needed at this Time                               
 *  9:00       Arrival                  1
 *  9:10       Departure                0
 *  9:40       Arrival                  1
 *  9:50       Arrival                  2
 *  11:00      Arrival                  3 
 *  11:20      Departure                2
 *  11:30      Departure                1
 *  12:00      Departure                0
 *  15:00      Arrival                  1
 *  18:00      Arrival                  2 
 *  19:00      Departure                1
 *  20:00      Departure                0

 * Minimum Platforms needed on railway station = Maximum platforms 
 *                                               needed at any time 
 *                                            = 3  
 *                                            
 * Note : This approach assumes that trains are arriving and departing on same date.
 */
public class MinimumRequiredPlatforms 
{

	public static void main(String args[])
	{
		    int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		    int n = arr.length; 
		    System.out.println("Minimum Number of Platforms Required = "
		                        + findMinimumPlatform(arr, dep, n)); 
	}
	
	private static int findMinimumPlatform(int arr[],int dep[],int n)
	{
		/**
		 * Initialize minimum platform 1 as it will be required any case. 
		 */
		int minplatforms = 0;
		int result = 0;
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int i=0;
		int j=0;
		
		while(i < n && j < n)
		{
			if (arr[i] <= dep[j])
			{
				// If next event in sorted order is arrival,  
			    // increment count of platforms needed 
				minplatforms++;
				i++;
			}
			else
			{
				// If next event in sorted order is departure,  
			    // decrement count of platforms needed 
				minplatforms--;
				j++;
			}
			result = Math.max(minplatforms,result);
		}
		return result;
	}
	
}
