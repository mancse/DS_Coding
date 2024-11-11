package SearchingAndSorting;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example 1:
   Input: nums = [4,5,6,7,0,1,2], target = 0
   Output: 4
   Example 2:

   Input: nums = [4,5,6,7,0,1,2], target = 3
   Output: -1
 * @author Manoj.K
 *
 */
public class SearchInRotatedSortedArray 
{
    private static int findUsingBinarySearchTree(int nums[],int target, int start,int end)
    {
        while(start <= end)
        {
        	int mid = start + (end - start)/2;
        
            if (nums[mid] == target)
                return mid;
        
            //It means, right half is sorted
            if (nums[mid] <= nums[end])
            {
                if(target > nums[mid] && target <= nums[end])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
            else // Left half is sorted.
            {
                if (target >= nums[start] && target < nums[mid])
                {
                    end = mid -1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    
    public static int search(int[] nums, int target) 
    {
        if (nums.length ==0 || target < 0)
            return -1;
        
        return findUsingBinarySearchTree(nums,target, 0,nums.length -1);
    }
}
