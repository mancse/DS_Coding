package Stack;

import java.util.Stack;
/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid
 * (well-formed) parentheses
 * substring
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Idea is to maintain two stacks. One is for braces (storing open braces) and other is for storing
 * string index of the particulr braces.
 * a. Put -1 initially in the index stack. 
 * b. Iterate over string character and check 
 *    --if it is equal to '('
 *    	Push the index of open braces in the stack.
 *    --Else -- it is equal to ')'
 *      a. Then pop index from the stack
 *      b. Check if stack is empty. If it is empty then push the index of closing parenthesis into stack
 *         so that it ensure new marker and after this index new valid parethesis substring can be found.
 *      c. Else if stack is not empty then take difference of (i - stack.peek()) and keep on storing
 *         maximum as result.
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
        Stack<Integer> ist = new Stack<>();
        ist.push(-1); //Base case as marker
        int res = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                ist.push(i);
            }
            else{
                //If there is closing braces then pop the index of matching opening braces.
                ist.pop();
                if (ist.isEmpty()){
                    //If index stack is empty then push the index of closing braces in the stack so
                    // that substring after the current closing braces should be considered as
                    // candidate for new valid string.
                    ist.push(i);
                }
                else{
                    res = Math.max(res, (i-ist.peek()));
                }
            }
        }
        return res;
    }
}
