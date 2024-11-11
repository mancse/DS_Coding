package DP;

import java.util.Arrays;
import java.util.Comparator;
/*
 * Given N jobs where every job is represented by following three elements of it.
 * Start Time
 * Finish Time
 * Profit or Value Associated 
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 * 
 * Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50} 
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
 * Output: The maximum profit is 250.
 * We can get the maximum profit by scheduling jobs 1 and 4.
 * Note that there is longer schedules possible Jobs 1, 2 and 3 
 * but the profit with this schedule is 20+50+100 which is less than 250.
 */
public class JobSchedulingMaxProfit {
	
	static class Job{
		int start;
		int end;
		int profit;
		public Job(int start, int end, int profit){
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}
	
	static class JobComparator implements Comparator<Job>{
		public int compare(Job a, Job b){
			return a.end - b.end;
		}
	}
	
	public static int findMaxProfitbyDP(Job jobs[]){
		Arrays.sort(jobs,new JobComparator());
		int dp[] = new int[jobs.length];
		
		dp[0] = jobs[0].profit;
		
		for (int i=1; i<jobs.length; i++){
			
			/**
			 * If we include current index i.e ith index profit
			 */
			int inclProfit = jobs[i].profit;
			
			/**
			 * Perform binary search to get index of non-overlapping job whose end time is less than current
			 * start time. 
			 */
			int l = getPrevNonConflictProfitByBinarySearch(jobs,i);
			
			if (l != -1){
				
				/**
				 * If we get any non-conflicting profit in DP array then add it to current profit. 
				 */
				inclProfit = inclProfit + dp[l];
			} 
			
			/**
			 * If we don't include current index i.e ith index profit then take dp[i-1] as the max profit. 
			 */
			int exclProfit = dp[i-1];
			
			/**
			 * Store the maximum of profit into DP array by including current job or by excluding current job
			 */
			dp[i] = Math.max(inclProfit,exclProfit);
		}
		return dp[dp.length-1];
	}
	
	private static int getPrevNonConflictProfitByBinarySearch(Job jobs[], int i){
		int lo = 0;
		int hi = i-1;
		
		while(lo <= hi){
			int mid = (lo + hi)/2;
			
			if (jobs[mid].end <= jobs[i].start){
				if (jobs[mid+1].end <= jobs[i].start){
					lo = mid + 1;
				}
				else{
					return mid;
				}
			}
			else{
			   hi = mid -1;
			}
		}
		
		return -1;
	}
	
	public static void main(String args[]){
		Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20), 
                new Job(6, 19, 100), new Job(2, 100, 200)}; 

        System.out.println("Optimal profit is " + findMaxProfitbyDP(jobs)); 
	}
}
