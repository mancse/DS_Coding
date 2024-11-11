package arrays;

import java.util.*;

public class SquaresOfSortedArray {
	public static int[] sortedSquares(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int res[] = new int[nums.length];
		int resRight = res.length - 1;
		while (left <= right) {
			int leftVal = Math.abs(nums[left]);
			int rightVal = Math.abs(nums[right]);
			if (leftVal >= rightVal) {
				res[resRight--] = leftVal * leftVal;
				left++;
			} else {
				res[resRight--] = rightVal * rightVal;
				right--;
			}
		}
		return res;
	}

	// ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];

		for (int i = 0; i < n; i++)
			nums[i] = scn.nextInt();

		int[] res = sortedSquares(nums);

		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
