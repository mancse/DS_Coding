package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k (only once)
 * where k > 0. The task is to minimize the difference between the heights of the longest and the shortest tower after 
 * modifications, and output this difference.
 * @author Manoj.K
 *Input : arr[] = {1, 5, 15, 10} 
 *      k = 3   
 *		Output : Maximum difference is 8
 *		arr[] = {4, 8, 12, 7} 
 */
public class MinimizeMaximumTowersDifferences {
	
	static class Pair implements Comparable<Pair>{
		public int value;
		public int index;
		public Pair(int value, int index){
			this.value = value;
			this.index = index;
		}
		
		public int compareTo(Pair p){
			return this.value - p.value;
		}
	}
	
	/**
	 * Idea here is to create a list of pair objects having value and index as two variables where value is the add or subtract value of k from arr[i] only
	 * when its value is more than 0 and index is the value of array index i. 
	 * -After creating such list sort the list on basis of value.
	 * -Maintain a visited array of index of size equal to arr.length which will keep track of index which are considered by right or left pointer of sliding 
	 *  window. 
	 * -Use sliding window technique with left=0 and right=0. Also, maintain a count variable which will keep track of how many elements are considered so far. 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int getMaxTowersDifference(int arr[], int k){
		int res = -1;
		if (arr.length <=1)
			return res;
		List<Pair> list = new ArrayList<>(); 
		int n = arr.length;
	    int [] visited = new int[n];
	    for (int i=0; i<arr.length; i++){
			if (arr[i] - k > 0){
				list.add(new Pair(arr[i]-k, i));
			}
			list.add(new Pair(arr[i]+k, i));
			visited[i] = 0;
			
	    }
	    Collections.sort(list);
			
		/**
		 * Use sliding window technique
		*/
		int left =0;
		int right =0;
		int count = 0;
		int size = list.size();
			
		while(count < n && right < size){
		    if (visited[list.get(right).index] == 0)
		    	count++;
			visited[list.get(right).index]++;
			right++;
		}
			
		res = list.get(right - 1).value - list.get(left).value;
			
		while (right < size){
			if (visited[list.get(left).index] == 1)
				count--;
			visited[list.get(left).index]--;
			left++;
				
			while (count < n && right < size){
				if (visited[list.get(right).index] == 0)
			    	count++;
				visited[list.get(right).index]++;
				right++;
			}
			if (count == n)
				res = Math.min(res, list.get(right-1).value - list.get(left).value);
		}
		return res;
	}
	
	public static void main(String args[]){
		int arr[] = {1, 5, 15, 10};
		int k=3;
		int res = getMaxTowersDifference(arr,k);
		System.out.println(res);
	}
}
