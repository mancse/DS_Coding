package SearchingAndSorting;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 * Example:

 * Input:
 * [4,3,2,7,8,2,3,1]

 * Output:
 * [5,6]
 * @author Manoj.K
 *
 */
public class FindAllNumbersDisapperd 
{
	public static List<Integer>  findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length == 0)
			return result;

		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] > 0)
				nums[idx] = -1 * nums[idx];
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}

		return result;
	}
	 
	 public static void main(String args[])
	 {                 
		 int nums[] = {4,3,2,7,8,2,3,1};
		 List<Integer> result = findDisappearedNumbers(nums);
		 System.out.println(result);
	 }
}
