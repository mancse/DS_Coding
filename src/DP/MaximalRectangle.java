package DP;

import java.util.Stack;

public class MaximalRectangle {
	
	 public static int maximalRectangle(char[][] matrix) {
	        int maxarea = 0;
	        if (matrix.length == 0)
	            return maxarea;
	        int histogram[] = new int[matrix[0].length];
	        for (int i=0; i<matrix.length; i++){
	            if (i==0){
	                histogram = convertCharToIntArray(matrix[0]);
	                int area = largestRectangleArea(histogram);
	                maxarea = Math.max(maxarea,area);
	            }
	            else{
	                for (int j=0; j<histogram.length; j++){
	                    if (matrix[i][j] == '1')
	                        histogram[j] = histogram[j] + Integer.parseInt(String.valueOf(matrix[i][j]));
	                    else
	                    	histogram[j] = 0;
	                }
	                int area = largestRectangleArea(histogram);
	                maxarea = Math.max(maxarea,area);
	            }
	        }
	        System.out.println("historgram array: ");
	        for (int i=0; i<histogram.length; i++){
	            System.out.print(" "+histogram[i]);
	        }
	        return maxarea;
	    }
	    
	    private static int[] convertCharToIntArray(char[] arr){
	        int result[] = new int[arr.length];
	        for (int i=0; i<arr.length; i++){
	            result[i] = Integer.parseInt(String.valueOf(arr[i]));
	        }
	        return result;
	    }
	    private static int largestRectangleArea(int[] heights) {
	        int maxarea = 0;
	        int left[] = new int[heights.length];
	      
	        Stack<Integer> st = new Stack();
	        
	        left[0] = 0;
	        st.push(0);
	        
	        for (int i=1; i<left.length; i++){
	            while(st.size() > 0 && heights[st.peek()] >= heights[i]){
	                st.pop();
	            }
	            if (st.size() > 0)
	                left[i] = st.peek() + 1;
	            else 
	                left[i] = 0;
	            st.push(i);
	        }
	               
	        int right[] = new int[heights.length];
	        st.clear();
	        right[heights.length -1] = heights.length -1;
	        st.push(heights.length -1);
	        
	        
	        for (int i=right.length -2; i>=0; i--){
	            while(st.size()>0 && heights[st.peek()] >= heights[i]){
	                st.pop();
	            }
	            
	            if (st.size() > 0)
	                right[i] = st.peek() -1;
	            else
	                right[i] = heights.length-1;
	            
	            st.push(i);
	        }
	                
	        for (int i=0; i<left.length;i++){
	            int l = left[i];
	            int r = right[i];
	            
	            int area = (r - l +1) * heights[i];
	            maxarea = Math.max(maxarea,area);
	        }
	        
	        return maxarea;
	    }
	    
	    public static void main(String args[]){
	    	char input[][]={{'0','1'},{'1','0'}};
	    	maximalRectangle(input);
	    }
}
