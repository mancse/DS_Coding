package DP;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
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
}