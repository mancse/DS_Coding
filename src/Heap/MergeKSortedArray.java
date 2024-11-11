package Heap;

import java.util.PriorityQueue;

public class MergeKSortedArray {
    
	static class CustomArray{
    	int[] arr;
    	int index;
    	
    	public CustomArray(int [] arr, int index){
    		this.arr = arr;
    		this.index = index;
    	}
    }
    
    public static int[] mergeKSortedArrays(int a[][]){
    	int [] result = new int[a.length * a[0].length];
    	
    	PriorityQueue<CustomArray> minHeap = new PriorityQueue<CustomArray>((c1,c2)->c1.arr[c1.index] - c2.arr[c2.index]);
    	
    	for (int i=0;i<a.length; i++){
    		CustomArray cArray = new CustomArray(a[i],0);
    		minHeap.add(cArray);
    	}
    	int k=0;
    	while(!minHeap.isEmpty()){
    		CustomArray cArray = minHeap.poll();
    		result[k++] = cArray.arr[cArray.index];
    		
    		/**
    		 * Create a new custom array object with same array contained by cArray but the next index value.
    		 */
    		if (cArray.index < cArray.arr.length-1)
    		{
    			CustomArray nCArr = new CustomArray(cArray.arr,cArray.index+1);
    			minHeap.add(nCArr);
    		}
    	}
    	return result;
    }
    
    public static void main(String args[]){
    	int a[][] = {{3,5,9},{4,7,15},{2,8,11}};
    	int result[] = mergeKSortedArrays(a);
    	
    	System.out.println("Result: ");
    	
    	for (int i : result)
    	{
    		System.out.print(" "+i);
    	}
    }
}
