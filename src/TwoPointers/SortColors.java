package TwoPointers;

public class SortColors 
{
    public static void main(String args[])
    {
    	int input[] ={2,0,2,1,1,0};
    	sortColors(input);
    }
    
    
    public static void sortColors(int[] nums) 
    {
        int start = 0;
        int mid = 0;
        int end = nums.length -1;
        
        while(mid <= end)
        {
        	switch(nums[mid])
        	{
        	    case 0:
        	    	/*
        	    	 * Swap with value of start pointer and mid pointer and increment both start 
        	    	 * and mid pointer.
        	    	 */
        	    	swap(nums,start,mid);
        	    	start = start + 1;
        	    	mid = mid + 1;
        		break;
        		    		
        	    case 1:
        	    	/*
        	    	 * If mid pointer is pointing to 1 itself then nothing to do and just increment mid pointer.
        	    	 */
            		 mid = mid+1;
        	    break;
        	    
        	    case 2:
        	    	/*
        	    	 * Swap with value of end pointer and mid pointer and decrement end pointer.
        	    	 */
        	    	swap(nums,mid,end);
        	    	end = end - 1;
        	    break;
        	}
        }
        
        
        for (int i=0 ; i< nums.length; i++)
        {
        	System.out.print(" "+nums[i]);
        }
    }
    
    private static void swap(int nums[], int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
