package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:

 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 
 * @author Manoj.K
 *
 *
 * Idea is to use Min Heap and keep on adding array's elements into the min heap. and whenever heap
 * size exceeds k size, remove element from min heap. So, by end of all array elements exhausts, root
 * of the mean heap contains the desired number, i.e Kth largest element of the array. 
 */

public class KthLargestElementOfArray 
{
	public int findKthLargest(int[] nums, int k)
    {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (int i=0; i<nums.length; i++)
        {
            minHeap.add(nums[i]);
            
            if(minHeap.size() > k)
            {
               minHeap.remove(); 
            }
        }
        
        int kthLargest = minHeap.remove();
        
        return kthLargest;
    }
}
