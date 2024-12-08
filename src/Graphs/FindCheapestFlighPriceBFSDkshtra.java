package Graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * Idea: Use Dijkshtra's shortest distance algorithm to solve this problem using BFS approach.
 */
public class FindCheapestFlighPriceBFSDkshtra {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Create graph and price map
        Map<Integer, List<Integer>> graph = createGraph(flights);
        Map<String, Integer> priceMap = getPriceMap(flights);

        // Step 2: Priority queue (city, cost, stops)
        Queue<int[]> pQueue = new PriorityQueue<>((p, q) -> p[1] - q[1]);
        pQueue.offer(new int[]{src, 0, 0}); // Start from the source

        // Step 3: Track the minimum cost to each city with a given number of stops. Hence, store cost to reach up to a city in each stop.

        int[][] priceToCity = new int[n][k + 2];
        for (int[] row : priceToCity) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        priceToCity[src][0] = 0;

        // Step 4: BFS with priority queue
        while (!pQueue.isEmpty()) {
            int[] elem = pQueue.poll();
            int currCity = elem[0];
            int price = elem[1];
            int stops = elem[2];

            // Skip paths exceeding the stop limit
            if (stops > k) {
                continue;
            }

            // Explore neighbors
            List<Integer> nCities = graph.get(currCity);
            if (nCities != null) {
                for (int nextCity : nCities) {
                    int charge = priceMap.get(currCity + "-" + nextCity);
                    int newCost = price + charge;

                    // Process the neighbor if the new cost is cheaper
                    if (newCost < priceToCity[nextCity][stops+1]) {
                        priceToCity[nextCity][stops+1] = newCost;
                        pQueue.offer(new int[]{nextCity, newCost, stops + 1});
                    }
                }
            }
        }

        // Find the minimum cost to reach the destination with at most k stops
        int result = Integer.MAX_VALUE;
        for (int stops = 0; stops <= k + 1; stops++) {
            result = Math.min(result, priceToCity[dst][stops]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static Map<Integer, List<Integer>> createGraph(int[][] flights) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }
        return graph;
    }

    private static Map<String, Integer> getPriceMap(int[][] flights) {
        Map<String, Integer> priceMap = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            priceMap.put(from + "-" + to, price);
        }
        return priceMap;
    }
}

