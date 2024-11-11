package RecursionBackTracking;
/**
 * Given an m x n board and a word, find if the word exists in the grid.The word can be constructed from letters of sequentially adjacent cells, 
 * where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * @author Manoj.K
 *
 */
public class WordSearch {
	public static boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
            	/**
            	 * Check if first character of word matches with board[i][j] character then further check if the word exists in the board 
            	 * in any direction from that position on the board i.e from board[i][j]
            	 */
                if (word.charAt(0) == board[i][j] && wordExist(board,word,i,j,0))
                    return true;
            }
        }
        return false;
     }
     private static boolean wordExist(char board[][],String word,int i, int j, int pos){
        /**
         * Check if position is equal to word length. If yes, then word exists in the board and so return true.
         */
    	if (pos == word.length()) 
            return true;
        
    	/**
    	 * Check if broad traversal reaches board boundaries. 
    	 */
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        
        /**
         * Check if character at current position in the word matches with board current position i.e board[i][j]. 
         */
        if (word.charAt(pos) != board[i][j])
            return false;
         
        char tmp = board[i][j];
        
        /**
         * This assignment to some other character out of allowed lower/upper character set works like visited sell marker.
         */
        board[i][j] = '#';
        
        boolean searchFront = wordExist(board,word,i,j+1,pos+1);
        boolean searchBack  = wordExist(board,word,i,j-1,pos+1);
        boolean searchUp = wordExist(board,word,i-1,j,pos+1);
        boolean searchDown = wordExist(board,word,i+1,j,pos+1);
        
        if (searchFront || searchBack || searchUp || searchDown) 
            return true;
        //Backtrack. So reset to original character so that it should work for next bigining character on board for the word. 
        board[i][j] = tmp;
        
        return false;
    }
     
    public static void main(String args[]){
    	char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	boolean exist = exist(board,"SEE");
    	System.out.println(exist);
    }
}
