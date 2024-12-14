package TwoPointers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array arr of size N and an integer K, the task is to find the maximum for
 * each and every contiguous subarray of size K.
 * Example:
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * All ccontigious subarrays of size k are
 * {1, 2, 3} => 3
 * {2, 3, 1} => 3
 * {3, 1, 4} => 4
 * {1, 4, 5} => 5
 * {4, 5, 2} => 5
 * {5, 2, 3} => 5
 * {2, 3, 6} => 6
 * @author Manoj.K
 *
 * Idea: Idea is to start left pointer from 0 and right from k-1. Loop through the array until right < nums.length
 *       Assign left = right - (k-1)
 *       
 *       initialize max variable as Integer.MIN_VALUE for each window iteration by left pointer.
 *       
 *       Loop until left <= right
 *         max = Math.max(max,nums[left++])
 *         
 *       Store max found in the above windo in result set.
 */

public class MaximumSlidingWindows 
{
	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> dq = new LinkedList<Integer>();
		int[] res = new int[nums.length -k + 1];
		int j = 0;
		for (int i=0; i<nums.length; i++){
			//Check if queue first index is out of the window then remove the first element from the queue.
			if (!dq.isEmpty() && (dq.peekFirst() < (i - k + 1))){
				dq.pollFirst();
			}

			//Always ensure that queue contains elements in decreseasing order. So, if queue last element is less than current index value of nums array then remove elements from queue last.
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
				dq.pollLast();
			}
			dq.offerLast(i);

			//Once window size reaches k then keep storing the queue first element as answer which ensures that highest value of each window is achieved.
			if (i >= k-1){
				res[i-k+1] = nums[dq.peekFirst()];
			}
		}
		return res;
	}
	 
	 public static void main(String args[])
	 {
		 int nums[] = {1,3,-1,-3,5,3,6,7};
		 int [] result =  maxSlidingWindow(nums,3);
		 for (int i=0; i < result.length ; i++)
		 {
			 System.out.print(" "+result[i]);
		 }
	 }
}
