package arrays;

public class RotateMatrix 
{
    public static void main(String args[])
    {
    	int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	rotateAnticlockWise(a);
    	rotateClockWise(a);
    }
    
    private static void rotateAnticlockWise(int a[][])
    {
    	int N = a.length;
    	
    	for (int i=0; i < N/2; i++)
    	{
    		for (int j=i; j < N-1-i; j++)
    		{
    			int tmp = a[i][j];
    			a[i][j] = a[j][N-1-i];
    			a[j][N-1-i] = a[N-1-i] [N-1-j];
    			a[N-1-i] [N-1-j] = a[N-1-j][i];
    			a[N-1-j][i] = tmp;
    		}
    	}
    	
    	System.out.println("Anticlockwise: ");
    	for (int i=0; i<N; i++)
    	{
    		for (int j=0; j<N; j++)
    		{
    			System.out.print(" "+a[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    /**
     * 1,	2,	3,	4
     * 2,	3,	4,	5
     * 6,	7,	8,	9
     * 10,	11, 12, 13
     * 
     * 
     * Matrix after clockwise rotation: 
     * 10,	6,	2,	1
     * 11,	7,	3,	2
     * 12,	8,	4,	3
     * 13,	9,	5,	4
     * @param a
     */
    private static void rotateClockWise(int a[][])
    {
    	int N = a.length;
    	/*
    	 * Idea is to first transpose the matrix and then swap left and right indexed matrix element of
    	 * all rows of matrix where left increments from start index and right increments from last end 
    	 * 
    	 * Original matrix is:
    	 * 1,	2,	3,	4
    	 * 2,	3,	4,	5
    	 * 6,	7,	8,	9
    	 * 10,	11, 12, 13
    	 * 
    	 * Transpose:
    	 * 1,	2,   6,	`10
    	 * 2,   3,   7,  11
    	 * 3,   4,   8,  12 
    	 * 4,   5,   9,  13
    	 * 
    	 * Desired result after Swapping left and right indexed element of each row
    	 * 10,	6,	2,	1
    	 * 11,	7,	3,	2
    	 * 12,	8,	4,	3
    	 * 13,	9,	5,	4
    	 */
    	
    	System.out.println("Original matrix is: ");
    	for (int i=0; i<N; i++)
    	{
    		for (int j=0; j<N; j++)
    		{
    			System.out.print(" "+a[i][j]);
    		}
    		System.out.println();
    	}
    	for (int i=0; i<N ; i++)
    	{
    		for(int j=i; j<N; j++)
    		{
    			int tmp = a[i][j];
    			a[i][j] = a[j][i];
    			a[j][i] = tmp;
    		}
    	}
    	
    	System.out.println("Transposed matrix is: ");
    	for (int i=0; i<N; i++)
    	{
    		for (int j=0; j<N; j++)
    		{
    			System.out.print(" "+a[i][j]);
    		}
    		System.out.println();
    	}
    	
    	for (int i=0; i<N; i++)
    	{
    		for (int j=0; j<N/2; j++)
    		{
    			int tmp = a[i][N-1-j];
    			a[i][N-1-j] = a[i][j];
    			a[i][j] = tmp;
    		}
    	}
    	
    	System.out.println("Clockwise rotated matrix is: ");
    	for (int i=0; i<N; i++)
    	{
    		for (int j=0; j<N; j++)
    		{
    			System.out.print(" "+a[i][j]);
    		}
    		System.out.println();
    	}
    }
}
