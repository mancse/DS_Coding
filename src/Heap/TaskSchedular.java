package Heap;

import java.util.PriorityQueue;
import java.util.Queue;
/**
** https://leetcode.com/problems/task-scheduler/description/
 *
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
 *
 * Return the minimum number of CPU intervals required to complete all tasks.
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 *
 * Output: 8
 *
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.
 *
 * Example 2:
 *
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 *
 * Output: 6
 *
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 *
 * With a cooling interval of 1, you can repeat a task after just one other task.
*/
public class TaskSchedular {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks){
            map[task - 'A']++;
        }
        //Max priority queue to get maximum freq task for execution.
        Queue<Integer> taskExecQ = new PriorityQueue<Integer>((a, b)->Integer.compare(b,a));

        for (int freq: map){
            if (freq > 0){
                taskExecQ.offer(freq);
            }
        }

        //Min priority queue is to store an already executed task for interval until next execution. It maintains task's (remainingFreq and nextExecTime). Min priority queue is based on nextExecTime.
        Queue<int[]> taskWatingQ = new PriorityQueue<int[]>((a,b)->Integer.compare(a[1],b[1]));

        int time = 0;

        //Continue to process until taskExecQ and taskWaitingQ are not empty.
        while(!taskExecQ.isEmpty() || !taskWatingQ.isEmpty()){
            //Check if task in the waiting queue is eligible for execution i.e if it's nextExecTime <= current time, then remove from waiting queue and add in the task execution queue.
            if (!taskWatingQ.isEmpty() && taskWatingQ.peek()[1] <= time){
                int remainingFreq = taskWatingQ.poll()[0];
                taskExecQ.offer(remainingFreq);
            }

            //Now, this is the time for execution. Check if task is there in the execution queue then remove it from execution queue and check if it's frequency is still greater than zero then add again into waiting queue by adding cooling interval.
            if (!taskExecQ.isEmpty()){
                int taskFreq = taskExecQ.poll();
                int remainingFreq = taskFreq -1;
                int nextExecTime = time + n+1;

                if (remainingFreq > 0){
                    taskWatingQ.offer(new int[]{remainingFreq,nextExecTime});
                }
            }

            //Increment execution time in each task execution.
            time++;
        }

        return time;
    }
}
