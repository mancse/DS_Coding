package SearchingAndSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumSwapsToSortArray {
	static class Pair{
		int element;
		int index;
		public Pair(int element, int index){
			this.element = element;
			this.index = index;
		}
	}
	
	static class PairComparator implements Comparator<Pair>{
		public int compare(Pair p1, Pair p2){
			return p1.element - p2.element;
		}
	}
	/**
	 * Idea is to create a list of Pair objects where Pair contains array element and it's index in original array.
	 * Sort the list with element value. So, the list contains sorted order of element. 
	 * Now, try to convert the sorted list to the order as per order of elements in original array. 
	 * @param nums
	 * @return
	 */
	public static int findMinimumSwaps(int nums[]){
		int count = 0;
		List<Pair> list = new ArrayList<>();
		
		for (int i=0; i<nums.length; i++){
			list.add(new Pair(nums[i],i));
		}
		Collections.sort(list,new PairComparator());
		
		for (int i=0; i<nums.length; i++){
			/*
			 * If index of any element in sorted list is equal to the index in original array, it means that element is at
			 * it's correct position itself. So, don't do anything. 
			 */
			if (list.get(i).index == i){
				continue;
			}
			else{
			/*
			 * Else increment number of swap count and swap the list element. 
			 */
				count++;
				Collections.swap(list, i, list.get(i).index);
				/* Decrement the index i because swapping of the list will cause element swapped from left to right at its correct position.
				 * But, it's not necessary that element swapped from right to left is at it's correct position. 
				 */
				i--;
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		int nums[] = {10, 19, 6, 3, 5};
		int res = findMinimumSwaps(nums);
		System.out.println("Number of swaps: "+res);
	}
}
