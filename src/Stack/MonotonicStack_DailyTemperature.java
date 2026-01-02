package Stack;

import java.util.Stack;

/**
 * Share Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how 
many days you would have to wait until a warmer temperature. If there is no future day for which this is 
possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be 
[1, 1, 4, 2, 1, 1, 0, 0].
 * @author Manoj.K
 *
 */
public class DailyTemperature 
{
	 public static int[] dailyTemperatures(int[] a) 
	 {
	     Stack<Integer> stack = new Stack<Integer>();
	        
	     int result[] = new int[a.length];
	          
	     for (int i=a.length -1; i >= 0; i--)
	     {
	    	/**
	    	 *    Idea: Stack top maintains the index of array element such that stack.peek() > array current 
	    	 *    element is true always.
	    	 *      -So, if array's current indexed element is greater than or equal to stack top indexed 
	    	 *    element then remove the stack top element till the time the current array index 
	    	 *    element is less than stack top element. 
	    	 *      -Check if stack is empty then add 0 in result array at current index else add stack top 
	    	 *    index - current index in the answer array.
	    	 *      -Push the current index into the stack.
	    	 *    
	    	 */
	        while(!stack.isEmpty() && a[i] >= a[stack.peek()])
	        {
	            stack.pop();
	        }
	        result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
	        stack.push(i);
	     }
	        
	     return result;
	 }
	 
	 public static void main(String args[]){
		 int [] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		 int res[] =  dailyTemperatures(temperatures);
		 
		 for (int i: res){
			 System.out.print(" "+i);
		 }
	 }
}
