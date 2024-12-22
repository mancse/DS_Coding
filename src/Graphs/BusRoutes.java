class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer,List<Integer>> stopToBuses = new HashMap<>();
        if (source == target){
            return 0;
        }
        for (int i=0; i < routes.length; i++){
            for (int j=0; j<routes[i].length; j++){
                List<Integer> buses = stopToBuses.getOrDefault(routes[i][j],new ArrayList<Integer>());
                buses.add(i);
                stopToBuses.put(routes[i][j],buses);
            }
        }

        Set<Integer> busVisited = new HashSet<>();
        Set<Integer> stopVisited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        stopVisited.add(source);

        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i=0; i<size; i++){
                int currStop = queue.poll();
                if (currStop == target){
                    return level;
                }
                //Find all the bus routes from current stop and check if any bus is picked to go to the route. if not then pick the bus i.e mark the bus as visited. 
                List<Integer> buses = stopToBuses.get(currStop);

                if (buses == null) continue;

                for (int bus : buses){
                    //If bus is not picked then pick the bus and get all subsequent stops from the current bus. 
                    if (!busVisited.contains(bus)){
                        busVisited.add(bus);

                        //Now get all the next stops from the current bus routes and add it in the queue for further processing if not already visited. 
                        int[] otherStops = routes[bus];
                        for (int otherStop : otherStops){
                            if (!stopVisited.contains(otherStop)){
                                stopVisited.add(otherStop);
                                queue.add(otherStop);
                            }
                        }

                    }
                }
            }
            //Here number of levels of BFS execution ensures the minimum number of buses required to compelete all stops. 
            level++;
        }
        return -1;
    }
}