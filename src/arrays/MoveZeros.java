package arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * @author Manoj.K
 *
 */
class MoveZeros 
{
	public static void moveZeroes(int[] nums) 
    {
       int j=0;
        
        for (int i=0; i<nums.length; i++)
        {
            if(nums[i]!= 0)
            {
                nums[j++] = nums[i];
            }
        }
        
        for (int i = j ; i < nums.length; i++)
        {
            nums[i] = 0;
        }
    }
    public static void main(String args[])
    {
    	int arr[] ={0,2,12,0,5,3,0,1,0,15,0};
    	moveZeroes(arr);
    	for(int n:arr) {
    	   System.out.println(n);	
    	}
    	
    }
}