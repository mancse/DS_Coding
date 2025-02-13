import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int[] oneDBoard = convertToOneDBoard(board);
        Set<Integer> visited = new HashSet<>();
        int n = board.length;
        //Queue element is 2 length array where first index contains current position and second index is the moves. 
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        visited.add(1);

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i=0; i<size; i++){
                int[] elem = queue.poll();
                int currPos = elem[0];
                int move = elem[1];

                if (currPos == n * n){
                    return move;
                }

                for (int dice=1; dice<=6; dice++){
                    int nextPos = currPos + dice;
                    //Valid range of position is between 1 to n*n
                    if (nextPos <= n * n){
                        //This is to jump to snake or ladder position. So, nextPos will change accordingly.
                        if (oneDBoard[nextPos] != -1){
                            nextPos = oneDBoard[nextPos];
                        }

                        //Again check if nextPos is under valid range. 
                        if (nextPos <= n * n && !visited.contains(nextPos)){
                            visited.add(nextPos);
                            queue.offer(new int[]{nextPos, move + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int[] convertToOneDBoard(int[][] board) {
        int n = board.length;
        int[] oneDBoard = new int[n * n + 1];
        int idx = 1;
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
}
