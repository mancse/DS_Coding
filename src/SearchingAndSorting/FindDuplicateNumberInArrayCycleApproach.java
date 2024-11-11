package SearchingAndSorting;
/**
 * Question:Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] 
 * inclusive.There is only one repeated number in nums, return this repeated number.
 * Example 1:
   Input: nums = [1,3,4,2,2]
   Output: 2
   Example 2:

   Input: nums = [3,1,3,4,2]
   Output: 3
 * Idea: Duplicate number in array would be starting point of the cycle. 
 * 1,3,4,2,2                --------- 
                            |       |
                     0,	1,	2,	3,	4
					        |       |  
							---------
	slow=1
	fast=3

	slow=nums[slow]= 3
	fast=nums[nums[fast]]= 4

	slow=nums[3]=2
	fast=nums[nums[fast]]= 4

	slow=nums[2]=4
	fast=nums[nums[fast]]= 4 ---> cycle found
	
   Now, make slow=0 and then iterate until slow!=fast to get root point of cycle.
 * Refer following link for cycle approach. 
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 * @author Manoj.K
 *
 */
public class FindDuplicateNumberInArrayCycleApproach {
    public static int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        slow=0;
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
            
            System.out.println("Slow: "+slow+" fast"+fast);
        }
        return slow;
    }
}
