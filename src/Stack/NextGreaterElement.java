package Stack;

import java.util.Stack;

public class NextGreaterElement {
	
	public static void main(String args[]){
		int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		int res[]=getNextGreaterElement(nums);
		for (int i: res){
			System.out.print(" "+i);
		}
	}
	
	/**
	 *    Idea: Stack top maintains the array element such that stack.peek() greater than array current 
	 *    element is true always.
	 *      -So, if array's current indexed element is greater than or equal to stack top indexed 
	 *    element then remove the stack top element till the time the current array index 
	 *    element is less than stack top element. 
	 *      -Check if stack is empty then add 0 in result array at current index else add stack top 
	 *    index - current index in the answer array.
	 *      -Push the current index into the index.
	 *    
	 */
	private static int[] getNextGreaterElement(int nums[]){
		int res[] = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		
		for (int i=nums.length-1; i>=0;i--){
			
			while(!st.isEmpty() && nums[i] >= st.peek()){
				st.pop();
			}
			if (st.isEmpty()){
				res[i] = -1;
			}
			else{
				res[i] = st.peek();
			}
			st.push(nums[i]);
		}
		return res;
	}
}

