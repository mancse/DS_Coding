package arrays;

public class MoveEvenOdd 
{
	public static int [] moveEvenOdds(int nums[])
	{
	    if (nums.length == 0 || nums.length==1)
	    	return nums;
	    
	    int left = 0;
	    int right = nums.length -1;
	    
	    while(left < right)
	    {
	    	if (!isEven(nums[left]) && isEven(nums[right]))
	    	{
	    		swap(nums,left,right);
	    		left++;
	    		right--;
	    	}
	    	
	    	else if (isEven(nums[left]) && !isEven(nums[right]))
	    	{
	    		left++;
	    		right--;
	    	}
	    	
	    	else if (isEven(nums[left]))
	    	{
	    		left++;
	    	}
	    	else if (!isEven(nums[right]))
	    	{
	    		right--;
	    	}
	    }
	    return nums;
	}
	
	private static boolean isEven(int num)
	{
		return num % 2 == 0 ? true : false;
	}
	
	private static void swap(int nums[],int i, int j)
	{
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}
	
	public static void main(String args[])
	{
		int nums[] = {1,3,2,6,8,9,7};
		
		for (int i=0; i< nums.length; i++)
		{
			System.out.print(" "+nums[i]);
		}
		
		System.out.println("\nMoved even odds: ");

		nums = moveEvenOdds(nums);
		
		for (int i=0; i< nums.length; i++)
		{
			System.out.print(" "+nums[i]);
		}
	}
}

