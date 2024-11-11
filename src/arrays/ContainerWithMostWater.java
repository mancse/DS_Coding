package arrays;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

public class ContainerWithMostWater 
{
   /**
    * Idea: Idea behind this is that keep two pointers one left which starts from 0th index and other right starting
    * from last (n-1)th index. Initialize maxArea as 0.
    * a. Calculate area at every step by multiplying minimum of the two left/right heights and 
    *    difference of right - left indices which gives breadth. 
    * b. Check if area calculated in step a is greater than maxArea then assign the vlaue of area to maxArea
    * c. Else if height of left lines are lesser than move left pointer to right else move right pointer to left
    * d. Repeat the above steps until left < right.  
    * 
    * @param heights
    * @return
    */
   private static int maxArea(int[] heights)
   {
	   int maxArea = 0;
	   
	   int left = 0;
	   int right = heights.length -1;
	   if (heights.length < 2)
	   {
		   System.out.println(" Minimum two heights should be there to calculate max area");
		   return 0;
	   }
	   while (left < right)
	   {
		   int area = (Math.min(heights[left],heights[right]))  * (right - left);
		   
		   if (area > maxArea)
			   maxArea = area;
		   else if (heights[left] <= heights[right])
			   left ++;
		   else if (heights[right] < heights [left])
			   right--;
	   }
	   return maxArea;
   }
   public static void main(String args[])
   {
	   int heights [] = {1,8,6,2,5,4,8,3,7};
	   int maxArea = maxArea(heights);
	   System.out.println("Max area is : "+ maxArea);
   }
}
