package Graphs;

import java.util.*;

class SnakeLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] oneDBoard = convertToOneDBoard(board);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.offer(0);
        visited[0] = true;
        int rolls = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n - 1) {
                    return rolls;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next < n * n) {
                        if (oneDBoard[next] != -1) {
                            next = oneDBoard[next];
                        }
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
            rolls++;
        }
        return -1;
    }

    private int[] convertToOneDBoard(int[][] board) {
        int n = board.length;
        int[] oneDBoard = new int[n * n];
        int idx = 0;
        boolean leftToRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    oneDBoard[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    oneDBoard[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        return oneDBoard;
    }
