package RecursionBackTracking;

public class NumberOfIcelands 
{
   public static void main(String args[])
   {
	   char grid [][] = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
	   int count = numIslands(grid);
	   System.out.println("Count : "+count);
   }
   
   public static int numIslands(char[][] grid)
   {
       int count =0;
       
       if (grid == null || grid.length == 0)
       {
           return 0;
       }
       
       for (int i=0; i < grid.length; i++)
       {
           for (int j=0; j<grid[i].length; j++)
           {
               if (grid[i][j] == '1')
               {
                   count = count + traverseDFS(grid,i,j);
               }
           }
       }
       return count;
   }
       
   private static int traverseDFS(char[][]grid, int i, int j)
   {
       if (i < 0 || j<0 || i >= grid.length || j >= grid[i].length || grid[i][j]=='0')
       {
           return 0;
       }
       
       grid[i][j]= '0';
           
       traverseDFS(grid,i+1,j);
       traverseDFS(grid,i-1,j);
       traverseDFS(grid,i,j+1);
       traverseDFS(grid,i,j-1);
       
       return 1;
   }

}
