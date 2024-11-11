package SearchingAndSorting;

import java.util.HashMap;
import java.util.Map;
/**
 * Given an array of positive and negative numbers. Find if there is a subarray exists whose sum is equal to
 * given sum. 
 * 
 * Idea behind this is to maintain a map of key-value where key is the value of the current sum so far
 * which is calculated as sum of elements of array and value is the current index value. Now following 
 * conditions can happen.
 * 1. if currSum - given sum = 0: It means desired sum is achieved from start index
 * 2. if currSum - given sum exists in the map, It means element at array index against the value of
 *    (currSum - given sum) should not be part of the sub-array. So ignore that index element from
 *    sub-array.
 *    
 *    E.g: Input array is: 2,1,5,3,6,9 and given sum is 9.
 *    
 *    i = 0 --> arr[0] = 2 --> currSum = currSum + arr[0]--> 2 ; map.put(currSum,i) --> map.put(2,0)
 *    i = 1 --> arr[1] = 1 --> currSum = currSum + arr[1]--> 2+1=3; ; map.put(currSum,i) --> map.put(3,1)
 *    i = 2 --> arr[2] = 5 --> currSum = currSum + arr[2]--> 3+5=8; ; map.put(currSum,i) --> map.put(8,2)
 *    i = 3 --> arr[3] = 3 --> currSum = currSum + arr[3]--> 8+3=11; ; map.put(currSum,i) --> map.put(11,3)
 *    
 *    currSum - sum --> 11 - 9 = 2; map.get(currSum - sum) --> map.get(2) = 0 (So, element at index 0 is not
 *    part of desired sub array) 
 *    
 *    so, start index = 0 + 1 = 1 and end index = i --> end index = 3. Hence, resulted sub array is between
 *    index 1 and 3. 
 * @author Manoj.K
 *
 */
public class SubArraySumPositiveNegativeNumbers 
{
    public static void main(String args[])
    {
    	//int arr[] = {2,1,5,3,6,9};
    	
    	int arr[] = {-1,-1,1};
    	subArraySum(arr,1);
    	/*subArraySum(arr,9);
    	subArraySum(arr,8);
    	subArraySum(arr,12);
    	subArraySum(arr,14);*/
    }
    
    private static void subArraySum(int arr[], int sum)
    {
    	int n = arr.length;
    	int currSum=0;
    	int start = 0;
    	int end = 0;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
    	boolean found=false;
    	
    	for (int i=0 ; i<n ; i++)
    	{
    		currSum = currSum + arr[i];
    		
    		/*
    		 * If we got currSum-sum equal to zero, it means desired sum is found
    		 * from starting index itself.
    		 */
    		if ((currSum - sum) == 0)
    		{
    			start = 0;
    			end = i;
    			found=true;
    			break;
    		}
    		
    		/*
    		 * If we get entry in map for currSum - sum, it means that index element
    		 * should not be the part of desired sum. So, exclude that index.
    		 */
    		if (map.containsKey(currSum - sum))
    		{
    			start = map.get(currSum - sum) + 1;
    			end = i;
    			found=true;
    			break;
    		}
    		
    		map.put(currSum, i);
    	}
    	
    	if (found)
    		System.out.println("Subarray found between index "+start+" and "+end);
    	else
    		System.out.println("Subarray not found");
    }
}
