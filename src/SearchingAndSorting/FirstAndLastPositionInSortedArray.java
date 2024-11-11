package SearchingAndSorting;

import java.util.Arrays;

public class FirstAndLastPositionInSortedArray 
{
	 public static  int[] searchRange(int[] nums, int target) 
	 {
	    int [] result = new int[2];
	    Arrays.fill(result,-1);
	       
	    if (nums.length == 0)
	        return result;
	        
	        result[0] = getFirstPositionOfGivenElement(nums,target);
	        result[1] = getLastPositionOfGivenElement(nums,target);
	        
	        return result;
	  }
	    
	    
	    private static int getFirstPositionOfGivenElement(int[] nums, int target)
	    {
	        int left = 0;
	        int right = nums.length -1;
	        int position = -1;
	        while (left <= right)
	        {
	            int mid = left + (right - left)/2;
	           
	            if (nums[mid] == target)
	            {
	                position = mid;
	                right = mid - 1;
	            }
	            
	            else if (nums[mid] < target)
	            {
	                left = mid + 1;
	            }
	            
	            else if (nums[mid] > target)
	            {
	                right = mid -1;
	            }
	        }
	        return position;
	    }
	    
	    private static int getLastPositionOfGivenElement(int[] nums, int target)
	    {
	        int left = 0;
	        int right = nums.length -1;
	        int position = -1;
	        while (left <= right)
	        {
	            int mid = left + (right - left)/2;
	           
	            if (nums[mid] == target)
	            {
	                position = mid;
	                left = mid + 1;
	            }
	            
	            else if (nums[mid] < target)
	            {
	                left = mid + 1;
	            }
	            
	            else if (nums[mid] > target)
	            {
	                right = mid -1;
	            }
	        }
	        return position;
	    }
	    
	    public static void main(String args[])
	    {
	    	int nums[] = {5,5,5,5,5,7,7,7,8,8,8,8,10};
	    	int target = 7;
	    	
	    	int range [] = searchRange(nums, target);
	    	System.out.println("Start position: "+range[0] + " End Position: "+range[1]);
	    }
}
