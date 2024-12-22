package Graphs;

/**
 * https://leetcode.com/problems/network-delay-time/description/
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
class NetworkDelayTimeDkshtra {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res = 0;
        Map<Integer,ArrayList<int[]>> graph = createGraph(times);

        //Array to store minimum time to reach to particular node
        int[] weights = new int[n+1];

        Arrays.fill(weights,Integer.MAX_VALUE);

        weights[k] = 0;

        // Min-heap priority queue to process nodes based on shortest distance
        Queue<int[]> queue = new PriorityQueue<int[]>((a,b)->Integer.compare(a[1],b[1]));

        queue.add(new int[]{k,0});

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int src = node[0];
            int wt = node[1];
            ArrayList<int[]> nbrs = graph.get(src);
            if (nbrs != null){
                for (int[] nbr : nbrs){
                    int dst = nbr[0];
                    int nwt =  wt + nbr[1] ;

                    // Process the neighbor if the new cost is cheaper
                    if (nwt < weights[dst]){
                        weights[dst] = nwt;
                        queue.offer(new int[]{dst,nwt});
                    }
                }
            }
        }
        //Note here we iterate from 1 because index 0 is just dummy and doesn't represent any vertex.
        for (int i=1; i<weights.length; i++){
            if (weights[i] == Integer.MAX_VALUE){
                res = -1;
                break;
            }
            else{
                res = Math.max(res,weights[i]);
            }
        }
        return res;
    }

    private Map<Integer,ArrayList<int[]>> createGraph(int[][] times){
        Map<Integer,ArrayList<int[]>> graph = new HashMap<>();
        for (int[] time : times){
            int src = time[0];
            int dst = time[1];
            int wt = time[2];
            ArrayList<int[]> list = graph.getOrDefault(src,new ArrayList<int[]>());
            list.add(new int[]{dst,wt});
            graph.put(src,list);
        }
        return graph;
    }
}
