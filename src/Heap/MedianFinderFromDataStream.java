package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: A list of data stream having integer numbers coming as stream. Find the median of the list
 * at any point of time. 
 * @author Manoj.K
 * 
 * Idea: Idea here is to maintain two buckets let's say lowerBucket and higherBucket where lowerBucket is 
 * the maxHeap where as higherBucket is the minHeap. So, any number coming into the stream is added into 
 * appropriate bucket based on the condition that the value of the number is smaller or greater than peek()
 * value of the maxHeap.
 * 
 * - If number < maxHeap.peek() then add into maxHeap else add into minHeap. 
 * - On every addition check the size of both bucket. If difference of size of both bucket is greater than
 *   or equal to 2 then rebalance both bucket. So, remove the peek value from larger bucket into the smaller 
 *   bucket (Note: larger bucket can be either lowerBucket or higherBucket based on whose size is greater).
 * - Also, implement a function (findMedian) with logic that if size of two buckets are same then return 
 *   average value of the peek() element of both buckets else if sizes are different then return peek of the
 *   larger bucket as median.  
 */
class MedianFinderForDataStream 
{
    Queue<Integer> lowerBucket = null;
    Queue<Integer> higherBucket = null;
    
    public MedianFinderForDataStream() 
    {
        lowerBucket = new PriorityQueue<Integer>(Collections.reverseOrder());
        higherBucket = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) 
    {
        if (lowerBucket.size() == 0 || num < lowerBucket.peek()) 
        {
            lowerBucket.add(num);
        }
        else
        {
            higherBucket.add(num);
        }
        
        rebalance(lowerBucket,higherBucket);
    }
    
    public void rebalance(Queue<Integer> lowerBucket, Queue<Integer> higherBucket)
    {
        Queue<Integer> biggerBucket = lowerBucket.size() > higherBucket.size()? lowerBucket : higherBucket;
        Queue<Integer> smallerBucket = lowerBucket.size() < higherBucket.size()? lowerBucket : higherBucket;
        
        if (biggerBucket.size() - smallerBucket.size() >= 2)
        {
            smallerBucket.add(biggerBucket.remove());
        }
    }
    public double findMedian() 
    {
        double result;
        Queue<Integer> biggerBucket = lowerBucket.size() > higherBucket.size()? lowerBucket : higherBucket;
        Queue<Integer> smallerBucket = lowerBucket.size() < higherBucket.size()? lowerBucket  : higherBucket;
        if (biggerBucket.size() == smallerBucket.size())
        {
            result = (double)(smallerBucket.peek() + biggerBucket.peek())/2; 
        }
        else
        {
            result = biggerBucket.peek(); 
        }
        
        return result;
    }
    
    public static void main(String args[])
    {
    	
    }
}