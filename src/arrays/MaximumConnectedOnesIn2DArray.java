package arrays;

public class MaximumConnectedOnesIn2DArray 
{
	public static void main(String args[])
	{
		//int arr[][]= {{1,0,0,0,1,1},{1,0,1,1,0,0},{0,1,0,1,0,1},{1,0,1,1,0,0},{0,1,0,0,1,0}};
		int arr[][]= {{0,1,1,1},{0,0,0,0},{0,1,1,1}};
	    int marked[][]= {{0,0,0,0},{0,0,0,0},{0,0,0,0}};;
	    
	    int size = 0;
	    int maxsize = 0;
	    
		for (int i=0; i < 3; i++)
		{
			for (int j=0; j < 4; j++)
			{
				if (arr[i][j] == 1)
				{
					size = 1;
					marked[i][j] = 1;
					maxsize = findMaxConnectedOnesLength(arr,i,j,3,4,marked,size,maxsize);
				}
			}
		}
		System.out.println("Max connected ones: "+maxsize);
	}
	
	public static int findMaxConnectedOnesLength(int arr[][],int r,int c,int L,int H,int marked [][],int size,int maxsize)
	{
		if (r < 0 || c < 0 || r > L || c>H)
			return maxsize;
		
		marked[r][c]=1;
		
		int moves [][]= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		
		for (int i=0 ; i< 8; i++)
		{
			int tr = r +  moves[i][0];
			int tc = c +  moves[i][1];
			if (canMove(arr,tr,tc,L,H,marked))
			{
				size++;
				if (size > maxsize)
					maxsize = size;
				
				maxsize = findMaxConnectedOnesLength(arr,tr,tc,L,H,marked,size,maxsize);
			}
		}
		return maxsize;
	}
	
	private static boolean canMove(int arr[][], int r, int c,int L,int H, int marked [][])
	{
		boolean retVal = false;
		if (r < 0 || c< 0 || r > L-1 || c > H-1)
			retVal = false;
		else if (arr[r][c] == 1 && marked[r][c] == 0)
		   retVal = true;
		return retVal;
	}
}
