package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	private static List<List<Integer>> kSum(int nums[], int target, int k, int start){
		List<List<Integer>> result = new ArrayList<>();
			
		if (k==2){
			twoSum(nums, target, start, result);
		}
		else{
			for (int i=start; i<=nums.length-k; i++){
				if (i>start && nums[i] == nums[i-1]) 
					continue;
				
				int subTarget = target-nums[i];
				List<List<Integer>> subres = kSum(nums,subTarget,k-1,i+1);
				
				for (List<Integer> res : subres){
					//Add nums[i] at first index of the list. 
					res.add(0,nums[i]);
					result.add(res);
				}
			}
		}
		return result;
	}

	private static void twoSum(int[] nums, int target, int start,
			List<List<Integer>> result) {
		int left = start;
		int right = nums.length -1;
		
		while(left < right){
			int sum = nums[left] + nums[right];
			if (sum == target){
				List<Integer> res = new ArrayList<>();
				res.add(nums[left]);
				res.add(nums[right]);
				result.add(res);
				
				while(left < right && nums[left] == nums[left+1])
					left++;
				while(left < right && nums[right] == nums[right-1])
					right--;
				
				left++;
				right--;
			}
			else if(sum < target){
				left++;
			}
			else{
				right--;
			}
			
		}
	}
	
	public static void main(String args[]){
		int nums[] = {1,3,2,1,5,7,4,2,3,8};
		Arrays.sort(nums);	
		List<List<Integer>> result = kSum(nums,10,4,0);
		System.out.println(result);
	}
}
