package SearchingAndSorting;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * 
 * leetcode: https://leetcode.com/problems/subarray-sum-equals-k/
 * @author Manoj.K
 *
 */
public class SubArraySumEqualsK 
{
	/*Given an array of integers with positive and negative numbers and an integer k, you need to find the total number of continuous subarrays 
	 * whose sum equals to k.*/
	
	public static void main(String args[])
	{
		int [] nums = {-1,2,-3,5,7,8};
		int count = subarraySum(nums,4);
		System.out.println("Count of subarray sum is: "+count);
	}
	
	
	/*
	 *`, i.e, if sum[i]−sum[j]=k, the sum of elements lying between indices i and j is k.
	 * Hence, we will use a hash map to store the cumulative sum up to all indices and the occurances of that sum 
	 * up to those indices. traverse over the array nums and keep on finding the cumulative sum. Every time we 
	 * encounter a new sum, we make a new entry in the hashmap corresponding to that sum.If the same sum occurs again, 
	 * we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, 
	 * we also determine the number of times the sum sum-k has occured already, since it will determine the number of 
	 * times a subarray with sum k has occured upto the current index. We increment the count by the same amount. 
	 * After the complete array has been traversed, the count gives the required result
	 * 
	 * E.g: nums[] = {-1,2,-3,5,7,8}; K = 4
	 * int result=0, cnt=0,sum=0;
	 * map.put(0,1)
	 * i=0 --> sum = sum + nums[0]--> 0+ (-1) -->  -1
	 * map.containsKey(sum-k)-->map.containsKey(-1-4)-->map.containsKey(-5)== false --> no subarray found so far
	 * cnt=map.get(sum) --> map.get(-1) == null --> 0
	 * map.put(sum,cnt+1) --> map.put(-1,0+1)--> map.put(-1,1)
	 * i=1 --> sum = sum + nums[1] --> -1 + 2 --> 1
	 * map.containsKey(sum-k)-->map.containsKey(1-4)-->map.containsKey(-3)== false --> no subarray found so far
	 * cnt = map.get(sum) --> map.get(1) --> null --> 0
	 * map.put(sum,cnt + 1) --> map.put(1,1)
	 * i=2 --> sum = sum + nums[2]--> sum = 1 + -3= -2
	 * map.containsKey(sum-k) -->map.containsKey(-2-4)-->map.containsKey(-6)== false --> no subarray found so far
	 * cnt = map.get(sum) --> map.get(-2) --> null --> 0
	 * map.put(sum,cnt+1) --> map.put(-2,0+1) --> map.put(-2,1)
	 * i=3 -->sum = sum + nums[3] --> -2 + 5 = 3
	 * map.containsKey(sum - k) --> map.containsKey(3-4)-->map.containsKey(-1)== true --> subarray found here
	 * result = result + map.get(sum-k) --> 0 + map.get(3-4) --> 0 + map.get(-1) --> 0 +1=1
	 * cnt=map.get(sum) --> map.get(3) --> null --> 0
	 * 
	 * map.put(sum,cnt+1) -->map.put(3,1)
	 * i=4 --> sum = sum + nums[4] --> 3 + 7 = 10
	 * map.containsKey(sum-k)-->map.containsKey(10-4)-->map.containsKey(6)== false --> no further subarray
	 * cnt = map.get(sum) --> map.get(10) --> null--> 0
	 * map.put(sum,cnt+1) --> map.put(10,0+1)--> map.put(10,1)
	 * i=5 --> sum = sum+nums[5] --> 10 + 8= 18
	 * map.containsKey(sum-k)-->map.containsKey(18-4)-->map.containsKey(14)== false --> no further subarray
	 * cnt = map.get(sum) --> map.get(18) -- null -->0
	 * map.put(sum,cnt+1) --> map.put(18,0 + 1) --> map.put(18,1)
	 * loop ends
	 * return result = 1
	 */
	public static int subarraySum(int[] nums, int k) 
    {
		    int sum =0; 
	        int result =0;
	        
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        
	        /*
	         * Following entry means sum=0 has count=1 
	         */
	        map.put(0,1);
	        
	        for (int i=0; i<nums.length; i++)
	        {
	            sum = sum + nums[i];
	            
	            if (map.containsKey(sum-k))
	            {
	            	result = result + map.get(sum-k);
	            }
	            int cnt = map.get(sum) != null ? (Integer) map.get(sum) : 0;
	            map.put(sum,cnt + 1);
	        }
	        return result;
    }
}
