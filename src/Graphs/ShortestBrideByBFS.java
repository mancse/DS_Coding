package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-bridge/
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 * Idea:
 * -----
 * Find iceland boundary cells of any one of the iceland using BFS/DFS
 * From each boundary cells of the iceland, perform another BFS parallelly layer by laery to get the minimum layer when we hit the first cell of value 1 of another icelan and return the value of the minimum layar as answer.
 *
 */
public class ShortestBrideByBFS {
    public int shortestBridge(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> islandBoundary = new LinkedList<>();

        // 1. Find the first island and collect its boundary
        findFirstIslandBoundary(grid, visited, islandBoundary);

        // 2. Multi-source BFS to find the shortest bridge
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int layers = 0;

        while (!islandBoundary.isEmpty()) {
            int size = islandBoundary.size();
            for (int i = 0; i < size; i++) {
                int[] cell = islandBoundary.poll();
                int x = cell[0], y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            return layers; // Found the second island
                        }
                        if (grid[nx][ny] == 0) {
                            islandBoundary.offer(new int[]{nx, ny});
                        }
                        visited[nx][ny] = true; // Mark as visited
                    }
                }
            }
            layers++;
        }
        return -1; // No valid bridge found (should not happen in valid inputs)
    }

    private void findFirstIslandBoundary(int[][] grid, boolean[][] visited, Queue<int[]> boundary) {
        int rows = grid.length, cols = grid[0].length;
        boolean found = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < rows && !found; i++) {
            for (int j = 0; j < cols && !found; j++) {
                if (grid[i][j] == 1) {
                    // Perform BFS to find all island cells and its boundary
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        boolean isBoundary = false;

                        for (int[] dir : directions) {
                            int nx = x + dir[0], ny = y + dir[1];
                            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                                if (grid[nx][ny] == 0) {
                                    isBoundary = true; // Adjacent to water
                                } else if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                                    queue.offer(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                        if (isBoundary) {
                            boundary.offer(new int[]{x, y});
                        }
                    }
                    found = true; // Stop after finding the first island
                }
            }
        }
    }
}
