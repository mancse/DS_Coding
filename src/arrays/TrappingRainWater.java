package arrays;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much total rain water it is able to trap after raining.
 * 
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Idea: Maintain 2 arrays leftMaxSoFar and rightMaxSoFar which holds maximum heights from left side up to 
 * particular index where as rightMaxSoFar will hold maximum heights so far from right side upto particular index. 
 * 
 * Once these two arrays are populated, iterate again heights array and find minHeight = min(leftMaxSoFar[i],rightMaxSoFar[i])
 * at every index i and then calculate totalTrapWater = totalTrapWater + minHeight - heights[i]. 
 * 
 * Return totalTrapWater as result at the end.
 * @author Manoj.K
 *
 */
public class TrappingRainWater 
{
	public static int trap(int[] heights) 
	{
		int leftMax = 0 ;
		int rightMax = 0 ;
	    int totalTrapWater = 0;
	    if (heights.length < 2)
	    {
	    	System.out.println(" Minimum two towers should be there to trap water");
	    	return 0;
	    }
	    
	    int leftMaxSoFar [] = new int[heights.length];
	    int rightMaxSoFar [] = new int[heights.length];
	    
	    for (int i=0 ; i < heights.length ; i++)
	    {
	    	if (heights[i] > leftMax)
	    	{
	    		leftMax = heights[i];
	    	}
	    	leftMaxSoFar[i] = leftMax;
	    }
	    
	    for (int i= heights.length - 1; i > 0 ; i--)
	    {
	    	if (heights[i] > rightMax)
	    	{
	    		rightMax = heights[i];
	    	}
	    	rightMaxSoFar[i] = rightMax;
	    }
	    
	    for (int i=0 ; i < heights.length; i++)
	    {
	    	int minOfLeftAndRightMax = Math.min(leftMaxSoFar[i], rightMaxSoFar[i]);
	    	totalTrapWater = totalTrapWater + (minOfLeftAndRightMax - heights[i]);
	    }
	    return totalTrapWater;
	}
    public static void main(String args[])
    {
    	int heights [] = {0,1,0,2,1,0,1,3,2,1,2,1};
    	int maxTrapWater = trap(heights);
    	System.out.println("Max trapped water is : "+ maxTrapWater);
    }
}
