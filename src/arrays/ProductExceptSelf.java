package arrays;

public class ProductExceptSelf 
{
	public static int[] productExceptSelf(int[] nums) 
    {
        int [] result = new int[nums.length];
        
        if (nums.length <= 1)
            return result;
        
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        
        left[0] = 1;
        
        for (int i=1; i<nums.length; i++)
        {
            left[i] = nums[i-1] * left[i-1];
        }
              
        right[nums.length - 1] = 1;
        
        for (int i=nums.length-2; i>=0; i--)
        {
            right[i] = nums[i+1] * right[i+1];
        }
        
        for(int i=0; i<nums.length; i++)
        {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }
	
	public static void main(String args[])
	{
		int [] nums = {1,2,3,4};
		int [] result = productExceptSelf(nums);
		for(int i : result)
		{
			System.out.print(" "+i);
		}
	}
}
