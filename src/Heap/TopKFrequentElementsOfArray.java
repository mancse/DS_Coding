package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Given a non-empty array of integers, return the k most frequent elements.

 * Example 1:

 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:

 * Input: nums = [1], k = 1
 * Output: [1]
 * @author Manoj.K
 *
 */
public class TopKFrequentElementsOfArray 
{
	public static int[] topKFrequent(int[] nums, int k) 
    {
		int res[] = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0 ; i<nums.length; i++)
        {
        	int freq = 0;
        	if (map.containsKey(nums[i]))
                freq = map.get(nums[i]);
        	
            freq++;
            map.put(nums[i],freq);
        }
        
        Queue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>((e1,e2)->e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
        	minHeap.add(entry);
        	
        	if (minHeap.size() > k)
        	{
        		minHeap.remove();
        	}
        }
        int i=0;
        
        //Now whatever left in the queue are the elements of max frequencies. 
        while(!minHeap.isEmpty())
        {
        	res[i++] = minHeap.remove().getKey();
        }
        return res;
    }
	
	public static void main(String args[])
	{
		int nums[] = {1,1,1,2,2,3,4,4,4};
		int k= 3;
		int res[] = topKFrequent(nums,k);
		for (int i=0; i<res.length; i++)
		{
			System.out.print(" " +res[i]);
		}
	}
}
