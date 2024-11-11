package DP;
/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers 
 * in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10).
 * 
 * Note: House robber problem is also exactly similar to this problem where robber of the house has to maximize the 
 * profit by robbing the house. But, he can't rob in two adjacent houses. 
 * @author Manoj.K
 *
 */
public class MaximumSumSubsequenceNonAdjacentElements {
	
	/**
	 * Idea is to maintain 2 variables incl and excl.
	 * incl: Stores maximum sum including the previous element i.e (i-1)th element. 
	 * excl: Stores maximum sum excluding the previous element i.e (i-1)th element. 
	 * 
	 * Now, value of incl at index i will be num[i] + excl. Because here only excl will be considered which
	 * is the maximum sum at index (i-1)th index excluding i-1 th element. Because, incl at i-1 can't be considered
	 * because that will be adjacent to ith elemnt.
	 * 
	 * Also, value of excl at index i will be maximum of incl and excl at (i-1)th index. 
	 * 
	 * So, after traversing whole array and calculating incl/excl at every index, we can get incl/excl. Then return 
	 * maximum of incl and excl as result. 
	 * @param num
	 * @return
	 */
	public static int findNonAdjacentSum(int num[]){
		
		int res = 0;
		int incl = num[0];
		int excl = 0;
		
		for (int i=1; i<num.length; i++){
			int new_incl = excl + num[i];
			int new_excl = Math.max(excl, incl);
			
			incl = new_incl;
			excl = new_excl;
		}
		
		res = Math.max(incl, excl);
		return res;
	}
	
	public static void main(String args[]){
		int num[] = {3,2,5,10,7};
		int res = findNonAdjacentSum(num);
		System.out.println("Maximum non-adjacent sum: "+res);
	}
}
