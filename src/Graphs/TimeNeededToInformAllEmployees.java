package Graphs;
import java.util.*;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company 
 * is the one with headID.Each employee has one direct manager given in the manager array where manager[i]
 * is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the 
 * subordination relationships have a tree structure.The head of the company wants to inform all the company
 * employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their
 * subordinates, and so on until all employees know about the urgent news.
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * 
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
 * 
 * Solution: 
 * Perform BFS
 * 
 * @author Manoj Kumar
 *
 */
public class TimeNeededToInformAllEmployees {
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n <=1 ){
            return 0;
        }
		Map<Integer, List<Integer>> graph = createGraph(n, manager);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID,informTime[headID]});
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                int[] data = queue.poll();
                int emp = data[0];
                int time = data[1];
                res = Math.max(res,time);
                List<Integer> reportees = graph.get(emp);
                if (reportees != null){
                    for (int rep : reportees){
                        queue.add(new int[]{rep,time + informTime[rep]});
                    }
                }
            }
        }
        return res;
    }

	private Map<Integer, List<Integer>> createGraph(int n, int[] manager) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (graph.get(manager[i]) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				graph.put(manager[i], list);
			} else {
				graph.get(manager[i]).add(i);
			}
		}
		return graph;
	}
}
