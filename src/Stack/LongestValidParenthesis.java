package Stack;

import java.util.Stack;
/**
 * Idea is to maintain two stacks. One is for braces (storing open braces) and other is for storing string index of the particulr braces.
 * a. Put -1 initially in the index stack. 
 * b. Iterate over string character and check 
 *    --if it is equal to '('
 *    	push open bracket in the character stack and index of that bracket inside index stack.
 *    --Else
 *     		 Check if character stack is not empty
 *      			pop entries from both the stack
 *           		Also. calculate max length till now, by comparing previous max length and difference of current index i and peek() of index stack.
 *           If character stack is empty
 *                  push current index into integer stack. 
 *                   	
 * @author Manoj.K
 *
 */
public class LongestValidParenthesis 
{
	public static void main(String args[])
	{
		int res = longestValidParentheses(")()())()");
		System.out.println(res);
	}
	public static int longestValidParentheses(String s) 
    {
        Stack<Character> cst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        /**
         * Insert -1 in the ist stack initially to avoid empty stack exception in case stack.peek() is called and there is no valid entry (i.e no index of 
         * open or close braces present in the stack.)
         * 
         */
        ist.push(-1);
        int res = 0;
        for (int i=0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                cst.push(c);
                ist.push(i);
            }
            else
            {
                if (!cst.isEmpty())
                {
                    cst.pop();
                    ist.pop();
                    
                    if (i - ist.peek() > res){
                    	res = i - ist.peek();
                    	System.out.println("ist.peek(): "+ist.peek());
                    	System.out.println("string:  "+s.substring(i+1-res, i+1));
                    }
                }
                else
                {
                    ist.push(i);
                }
            }
        }
        return res;
    }
}
