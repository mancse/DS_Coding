package arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * @author Manoj.K
 *
 */
public class JumpGame 
{
	public static boolean canJump(int[] nums) 
    {
        int moves= nums[0];
        
        for (int i=1; i<nums.length ; i++)
        {
            moves--;
            
            if (moves < 0)
                return false;
            moves = Math.max(moves,nums[i]);
        }
        return true;
    }
	
	public static void main(String args[])
	{
		int nums[] = {2,3,1,1,4};
		System.out.println("Can jump: "+canJump(nums));
	}
}

