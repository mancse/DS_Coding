package Graphs;
/**
 * https://leetcode.com/problems/flood-fill/?envType=study-plan&id=graph-i
 * @author Manoj Kumar
 *An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
 */
public class FloodFill {
	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        dfs (image,sr,sc,image[sr][sc],newColor);
	        return image;
	    }
	    
	    private void dfs(int[][] image,int sr, int sc, int origColor,int newColor){
	        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] == newColor || image[sr][sc] != origColor){
	            return;
	        }
	        if (image[sr][sc] == origColor)
	            image[sr][sc] = newColor;
	        
	        dfs(image,sr+1,sc,origColor,newColor);
	        dfs(image,sr-1,sc,origColor,newColor);
	        dfs(image,sr,sc+1,origColor,newColor);
	        dfs(image,sr,sc-1,origColor,newColor);
	    }
}
