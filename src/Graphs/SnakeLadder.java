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

    /**
     * https://leetcode.com/problems/remove-invalid-parentheses/
     * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
     *
     * Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "()())()"
     * Output: ["(())()","()()()"]
     * Example 2:
     *
     * Input: s = "(a)())()"
     * Output: ["(a())()","(a)()()"]
     * This is not a stack solution.
     */
    public static class MakeAllValidParenthesisByRmovingMinimumInvalidParenthesis {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            Queue<String> que = new LinkedList<>();
            que.add(s);
            Set<String> visited = new HashSet<>();
            visited.add(s);
            boolean found = false;
            while(!que.isEmpty()){
                String str = que.poll();
                if (isValid(str)){
                    res.add(str);
                    found = true;
                }

                // If valid strings are found, do not process deeper levels
                if (found)
                    continue;

                for(int i=0; i<str.length(); i++){
                    if (str.charAt(i) == '(' || str.charAt(i) == ')'){
                        String str2 = str.substring(0,i) + str.substring(i+1);
                        if (!visited.contains(str2)){
                            visited.add(str2);
                            que.add(str2);
                        }
                    }
                }
            }
            return res;
        }

        public boolean isValid(String s){
            int count=0;
            for (int i=0; i<s.length(); i++){
                if (s.charAt(i) == '('){
                    count++;
                }
                else if (s.charAt(i) == ')'){
                    count--;
                    if (count < 0)
                        return false;
                }
            }
            return count == 0;
        }
    }
}

