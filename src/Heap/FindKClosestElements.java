package Heap;
import java.util.*;
/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Leetcode: https://leetcode.com/problems/find-k-closest-elements/
 * @author Manoj.K
 *
 */
public class FindKClosestElements {
	private static class Pair{
        int gap; 
        int val;
        public Pair(int gap,int val){
            this.gap = gap;
            this.val = val;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Maintain max heap based on the gap so that once size of queue reaches k then root of heap will contain the element with 
    	//higher value of gap and that should be the one which should be removed first. 
        Queue<Pair> pQ = new PriorityQueue<Pair>((p1,p2) -> p2.gap - p1.gap);
        for (int i=0; i < arr.length ; i++){
            int gap = Math.abs(arr[i] -x);
            //If queue size is less than k then add element in the queue. 
            if (pQ.size() < k){
                pQ.add(new Pair(gap,arr[i]));
            }
            else{
            	//If queue size is greater than k, then check if current element is closer to the one at the root of max heap, then remove
            	//element from root and add the current element in heap. 
                if (gap < pQ.peek().gap)
                {
                    pQ.remove();
                    pQ.add(new Pair(gap,arr[i]));
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pQ.isEmpty()){
            Pair p = pQ.remove();
            result.add(p.val);
        }
        Collections.sort(result);
        return result;
    }
}
