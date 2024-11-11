package SearchingAndSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Question: You are given an integer array nums and you have to return a new counts array. The counts 
 * array has the property where counts[i] is the number of smaller elements to the right of nums[i].
   	Example 1:
	Input: nums = [5,2,6,1]
	Output: [2,1,1,0]
   Explanation:
	To the right of 5 there are 2 smaller elements (2 and 1).
	To the right of 2 there is only 1 smaller element (1).
	To the right of 6 there is 1 smaller element (1).
	To the right of 1 there is 0 smaller element.
	
	Idea: We need to find out how many numbers are coming before for any particular number if numbers are 
	arranged in sorted order. So, make a copy of the number array of same numbers and sort them in ascending order.
	
	Then iterate the original number array and perform binary search of any number into the sorted array and find the
	first matching index and add the index in to result array... also remove that particular number from sorted array
	so that it shouldn't be considered in next iteration. 
	
 * @author Manoj.K
 *
 */
public class CountSmallerNumberAfterSelf {
	public static List<Integer> countSmaller(int[] nums) 
    {
        List<Integer> result = new ArrayList<>();
        
        List<Integer> copyList = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++){
            copyList.add(nums[i]);
        }
        
        Collections.sort(copyList);
        
        for (int i=0; i<nums.length; i++){
            int index = binarySearch(copyList,nums[i]);
            result.add(index);
            copyList.remove(index);
        }
        return result;
    }
	
	public static List<Integer> countGreater(int[] nums) 
    {
        List<Integer> result = new ArrayList<>();
        
        List<Integer> copyList = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++){
            copyList.add(nums[i]);
        }
        
        Collections.sort(copyList);
        
        for (int i=0; i<nums.length; i++){
            int index = binarySearch(copyList,nums[i]);
            result.add(copyList.size() - (index+1));
            copyList.remove(index);
        }
        return result;
    }
    /**
     * Find the first index of the matching number in binary search of sorted array. 
     */
    private static  int binarySearch(List<Integer> list, int num){
        
        int start=0;
        int end=list.size()-1;
        
        while(start<end){
            int mid = start + (end-start)/2;
            
            if (list.get(mid) < num){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    
    public static void main(String args[]){
    	int nums[] = {5,2,6,1};
    	
    	List<Integer> result = countSmaller(nums);
    	List<Integer> result1 = countGreater(nums);
        System.out.println("Smaller number counts: "+result);
        System.out.println("Greater number counts: "+result1);
    }
}
