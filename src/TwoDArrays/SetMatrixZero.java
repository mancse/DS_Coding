package TwoDArrays;

public class SetMatrixZero {
	class Solution {
	    public void setZeroes(int[][] matrix) {
	        int row = matrix.length;
	        int col = matrix[0].length;
	        
	        boolean firstrowzero = false;
	        boolean firstcolzero = false;
	        
	        for (int i=0; i< col; i++){
	            if (matrix[0][i] == 0)
	            {
	                firstrowzero = true;
	                break;
	            }
	        }
	        
	        for (int i=0; i< row; i++){
	            if (matrix[i][0] ==0)
	            {
	                firstcolzero = true;
	                break;
	            }
	        }
	        for (int i=0; i<row; i++){
	            for(int j=0; j<col; j++){
	                if (matrix[i][j] == 0){
	                    matrix[i][0] = 0;
	                    matrix[0][j] = 0;
	                    
	                }
	            }
	        }
	        
	        for(int i=1; i<row; i++){
	            for (int j=1; j<col; j++){
	                if (matrix[i][0] == 0 || matrix[0][j] == 0){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for (int i=0; i< row; i++){
	            if (firstcolzero){
	                matrix[i][0] = 0;
	            }
	        }
	        
	        for (int i=0; i< col; i++){
	            if (firstrowzero){
	                matrix[0][i] = 0;
	            }
	        }
	    }
	}
}
