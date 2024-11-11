package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1] Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?
 * @author Manoj.K
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }
        int indegrees[] = new int[numCourses];
        int dependents = prerequisites.length;
        Map<Integer,ArrayList<Integer>> graph = constructGraph(prerequisites);
        
        for (int i=0; i<numCourses; i++){
            ArrayList<Integer> nbrs = graph.get(i);
            if (nbrs != null){
                for (int nbr: nbrs){
                indegrees[nbr]++;
               }
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i=0; i<numCourses; i++){
            if (indegrees[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            ArrayList<Integer> nbrs = graph.get(v);
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
        return (count == dependents) ? true : false;
    }
    
    private Map<Integer,ArrayList<Integer>> constructGraph(int[][] prerequisites){
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for (int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][0];
            int dst = prerequisites[i][1];
            
            ArrayList<Integer> list = graph.get(dst);
            if (list == null){
                list = new ArrayList<>();
                graph.put(dst,list);
            }
            list.add(src);
        }
        return graph;
    }
}
