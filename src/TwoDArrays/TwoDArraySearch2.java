package TwoDArrays;

public class TwoDArraySearch2 
{
	/**
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has 
	 * the following properties Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0)
            return false;
        
        int i=0; 
        int j=matrix[i].length-1;
        
        while (i< matrix.length && j >=0)
        {
            if (matrix[i][j] == target)
            {
                return true;
            }
            
            else if (matrix[i][j] < target)
            {
                i++;
            }
            
            else if (matrix[i][j] > target)
            {
                j--;
            }
        }
        return false;
    }
	
	public static void main(String args[])
	{
		int arr[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		boolean ret = searchMatrix(arr,8);
		System.out.println("Element found status: "+ret);
	}
}
