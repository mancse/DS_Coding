package SearchingAndSorting;

/**
 * Idea here is to re-arrange the array elements to it's 
 * a. Correct position like this. nums[0]=1, nums[1]=2..... 
 * b. Ignore the numbers less than 0 and greater than array length.
 * c. Once, above arrangement is done, then iterate the array one more time and check
 *    the position where it violates above arrangement and that is the answer. 
 * @author Manoj.K
 *
 */
public class FirstMissingPositive 
{
	public static int firstMissingPositive(int[] nums) 
    {
        int i=0;
        
        int length = nums.length;
        
        while(i < length)
        {
        	if (nums[i] > 0 && nums[i] < length && nums[i] != i+1 && nums[i] != nums[nums[i] -1])
        	{
        		/**
        		 * swap elements of nums[i] and nums[nums[i]-1].
        		 * Note: Here sequence of swap of two indexed elements in the array should be as below only. 
        		 * We can't first replace the variable of nums[i] before replacing variable at nums[nums[i]-1]. 
        		 * Because it will change the desired indexed variable. 
        		 */
        		int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
                
        	}
        	else
        	{
        		i++;
        	}
        }
        
        System.out.println("\n Arranged array is: ");
        for (int k=0 ; k<nums.length; k++)
        {
        	System.out.print(" "+nums[k]);
        }
        int j=0;
        while(j < length)
        {
        	if (nums[j] != j+1)
        		break;
        	j++;
        }
        return j + 1;
    }
	
	public static void main(String args[])
	{
		int nums[] = {1,2,5,17,4,3,0};
		int result = firstMissingPositive(nums);
		System.out.println("\n Result: "+result);
	}
}
