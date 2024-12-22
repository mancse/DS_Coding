package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream{
    Queue<Integer> maxHeap = null;
    Queue<Integer> minHeap = null;
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>((i, j)->Integer.compare(j,i));
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        rebalance(maxHeap,minHeap);
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else{
            return ((long)maxHeap.peek() + (long)minHeap.peek())/2.0;
        }
    }

    private static void rebalance(Queue<Integer> maxHeap, Queue<Integer> minHeap){
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
}
