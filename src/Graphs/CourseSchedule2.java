package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

https://leetcode.com/problems/course-schedule-ii/

 * @author Manoj Kumar
 *
 */
public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = createGraph(prerequisites);
        int [] indegrees = new int[numCourses];
        for (int i=0; i < numCourses; i++){
            List<Integer> nbrs = graph.get(i);
            if (nbrs != null){
                for (int nbr : nbrs){
                    indegrees[nbr]++;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegrees.length; i++){
            if (indegrees[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        int res[] = new int[numCourses];
        int i=0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            res[i++] = v;
            List<Integer> nbrs = graph.get(v);
            if (nbrs != null){
                 for (int nbr : nbrs){
                     indegrees[nbr]--;
                     if (indegrees[nbr] == 0){
                         queue.add(nbr);
                     }
                     count++;
                 }
            }
        }
        
        if (count != prerequisites.length){
            return new int[]{};
        }
        
        return res;
    }
    
    private Map<Integer,List<Integer>> createGraph(int[][] dependents){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i=0; i<dependents.length; i++){
            int src = dependents[i][0];
            int dst = dependents[i][1];
            List<Integer> list = graph.get(dst);
            if (list == null){
                list = new ArrayList<>();
                graph.put(dst,list);
            }
            list.add(src);
        }
        return graph;
    }
}
