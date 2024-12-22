package SearchingAndSorting;

/**
 * https://leetcode.com/problems/find-peak-element/description/
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 *
 * Idea: Idea is that if array's 0'th index element is greater than first index element then return 0 as answer
 * else if arrays last index element is greater than it's left element then return last index as answer
 * reason is that all elements of array is guranteed to be greater than left of 0th index and right of n-1 index
 * So, for 0th index element, we only need to check if element at 1st index is lesser to it and similarly for n-1th index
 * element only need to check if element at n-2 index is smaller to it.
 *
 * For rest of the index, check if current index element is smaller than it's right then find peak element at right
 * else if current index element is smaller to it's left then find peek element at left.
 *
 * Note: if any element is not peak element it means at least one of its neighbours must be greater than or equal to it
 * as per peak element definition.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;

        if (nums.length == 1){
            return 0;
        }
        else{
            if (nums[0] > nums[1]){
                return 0;
            }
            else if (nums[nums.length - 2] < nums[nums.length-1]){
                return nums.length - 1;
            }
        }
        int res = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (mid > 0 && mid < nums.length -1 &&
                    nums[mid] > nums[mid -1]  && nums[mid] > nums[mid + 1]){
                res =  mid;
                break;
            }
            //If nums[mid] < nums[mid + 1] then peak element will be in right side.
            else if (mid < nums.length - 1 && nums[mid] <= nums[mid+1]){
                left = mid + 1;
            }
            //Else if nums[mid] < nums[mid -1] then peek element will be in left side.
            else if (mid > 0 && nums[mid - 1] >= nums[mid] ){
                right = mid - 1;
            }
        }
        return res;
    }
}
