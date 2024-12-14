package TwoPointers;

import java.util.Arrays;

public class TripletCountsWithSumLessThanGivenSum {
	
	public static void main(String args[]){
		int a[] = {-2,0,1,3,4}; // {-2,0,1},{-2,0,3},{-2,0,4},{-2,1,3},{-2,1,4}
		          // i    j   k
		int sum = 4;
		int count = findCountOfTriplets(a,sum);
		
		System.out.println("Max triplet: "+count);
	}
	
	private static int findCountOfTriplets(int a[], int sum){
		int res =0;
		Arrays.sort(a);
		int n = a.length;
		for (int i=0; i<n-2; i++){
			int left=i+1;
			int right=n-1;
			
			while(left < right){
				if (a[i]+a[left]+a[right] >= sum){
					right--;
				}
				else{
					/**
					 * If (a[i]+a[j]+a[k]) < sum, it means for current value of i, all values between (k-j)
					 * will be valid candidate because array is sorted in ascending order and will add up 
					 * to form sum less than given sum. 
					 */
					res = res + (right-left);
					left++;
				}
			}
		}
		return res;
	}
}
