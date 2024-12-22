package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<Integer> minHeap = new PriorityQueue<>();

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // Add current element to the correct heap
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            rebalance(maxHeap, minHeap);

            // Calculate the median when the window is full
            if (i >= k - 1) {
                if (k % 2 != 0) {
                    res[j++] = maxHeap.peek();
                } else {
                    res[j++] =  ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
                }

                // Remove the element that is sliding out of the window
                int elementToRemove = nums[i - k + 1];
                if (elementToRemove <= maxHeap.peek()) {
                    maxHeap.remove(elementToRemove);
                } else {
                    minHeap.remove(elementToRemove);
                }
                rebalance(maxHeap, minHeap);
            }
        }
        return res;
    }

    private void rebalance(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
