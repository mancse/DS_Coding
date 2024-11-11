package arrays;

public class MedianOfTwoSortedArrays 
{
    public static double findMedianOfTwoSortedArrays(int nums1[], int nums2[])
    {
    	double median = 0.0;
    	
    	/**
    	 * Ensure that nums1 array is shhorter arrry in length where binary search is applied
    	 */
    	if (nums1.length > nums2.length)
    	{
    		int tmp [] = nums2;
    		nums2 = nums1;
    		nums1 = tmp;
    	}

    	
    	int start = 0 ;
    	int end = nums1.length;
    	
    	while(start <= end)
    	{
    		int midx = start + (end - start)/2;
    		int midy = (nums1.length + nums2.length +1)/2 - midx;
    		
    		int maxLeftX = (midx == 0) ? Integer.MIN_VALUE : nums1[midx -1];
    		int minRightX = (midx == nums1.length) ? Integer.MAX_VALUE : nums1[midx];
    		
    		int maxLeftY = (midy == 0) ? Integer.MIN_VALUE : nums2[midy -1];
    		int minRightY = (midy == nums2.length) ? Integer.MAX_VALUE : nums2[midy];
    		
    		if (maxLeftX <= minRightY && maxLeftY <= minRightX)
    		{
    			if ((nums1.length + nums2.length)%2 == 0)
    			{
    			    median = (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
    			}
    			else
    			{
    				median = (double)Math.max(maxLeftX, maxLeftY);
    			}
    			return median;
    		}
    		else if (maxLeftX > minRightY)
    		{
    			//We are too far at right side of partitionX. So move left side. 
    			end = midx - 1;
    		}
    		else 
    		{
    			//We are too far on left side of partitionX. So, move right side.
    			start = midx + 1;
    		}
    	}
    	return median;
    }
    
    public static void main(String args[])
    {
    	int nums1[] = {1, 3, 4, 5, 6, 7, 10};
    	int nums2[] = {2,8,12,14};
    	
    	double median = findMedianOfTwoSortedArrays(nums1,nums2);
    	System.out.println("Median is : "+median);
    }
}
