package Heap;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Example 1:
   Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
   Output: 13
   Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

 * Solution: Idea here is to maintain a min priority queue of based on matrix value and also keep row and col index. 
 * 1. First add all elements and row and col indexes of first row of matrix. 
 * 2. Loop through queue and keep on removing the root element from priority queue and add next row element from the
 * matrix in the queue. 
 * @author Manoj Kumar
 *
 */
public class KthSmallestInSorted2DArray {
    public int kthSmallest(int[][] matrix, int k) {
        
        if (matrix[0].length==1 && matrix[0].length==1)
            return matrix[0][0];
        
        Queue<int[]> priorityQ = new PriorityQueue<int[]>((e1,e2) -> e1[0] - e2[0]);
        for (int i=0; i<matrix[0].length; i++){
        	int[] elem = new int[] {matrix[0][i],0,i};
            priorityQ.add(elem);
        }
        
        int cnt=0;
        
        while(!priorityQ.isEmpty()){
            
            if (cnt == k-1){
                break;
            }
            
            int[] elem = priorityQ.remove();
            cnt++;
            int nextrow = elem[1] + 1;
            int nextcol = elem[2];
            if (nextrow < matrix.length) {
            	int[] nextElem = new int[] {matrix[nextrow][nextcol],nextrow,nextcol};
                if (nextrow < matrix.length)
                    priorityQ.add(nextElem);
            }
        }
        
        int res[] = priorityQ.peek();
        
        return res != null ? res[0] : -1;
        
    }
}
