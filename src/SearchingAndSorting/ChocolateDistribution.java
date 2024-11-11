package SearchingAndSorting;

import java.util.Arrays;
/**
 * 1. Given an array A[] of positive integers of size N, where each value represents the number of chocolates in a packet. 
 * Each packet can have a variable number of chocolates. There are M students, the task is to distribute 
 * chocolate packets among M students such that :
 * 2. Each student gets exactly one packet.
 * 3. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a 
 * student is minimum.
 * @author Manoj.K
 *
 */
public class ChocolateDistribution {
	 public static int find(int[]arr, int n, int m) {
		    Arrays.sort(arr);
		    int min = Integer.MAX_VALUE;
		    for (int i=0 ; i < n - m; i++){
		        int diff = arr[i+m-1] - arr[i];
		        min = Math.min(min,diff);
		    }
		    return min;
		  }
}
