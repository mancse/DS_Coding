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
 * Idea: Use a stack to store indices.
 * Push -1 initially as a base for length calculation.
 * When '(' → push its index.
 * When ')':
 * pop once
 * if stack becomes empty → push current index (new base)
 * else → calculate length = i - stack.peek()
 * Why -1?
 * It helps calculate valid length when the substring starts at index 0.
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
