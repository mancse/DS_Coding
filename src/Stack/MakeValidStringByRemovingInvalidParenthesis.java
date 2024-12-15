package Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses '(' or ')', in any positions  so that
the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
 * 
 * 
 * 
 * Idea is to traverse left to right of string one character at a time and do following:
 *   Notice that when traversing the string left to right, we only consider adding a closing
 *   bracket if openBracketCount > closedBracketCount.
 *   In this way we ommit invalid closed brackets,and half of the problem is solved, we need
 *   to do the same by validating open brackets, and we can validate the same by validating reverse
 *   of sting.
 * @author Manoj.K
 *
 */
public class MakeValidStringByRemovingInvalidParenthesis {
	   public static String minRemoveToMakeValid(String s) {
	        
	        StringBuilder sb = removeInvalidParenthesis(s,'(',')');
	        StringBuilder res = removeInvalidParenthesis(sb.reverse().toString(),')','(');
	        
	        return res.reverse().toString();
	    }
	    
	    
	    private static StringBuilder removeInvalidParenthesis(String s, char brace1, char brace2){
	        
	        StringBuilder sb = new StringBuilder();
	        int open=0; int close=0; 
	        for (int i=0; i<s.length(); i++){
	            if (s.charAt(i) == brace1){
	                sb.append(brace1);
	                open++;
	            }
	            else if(s.charAt(i)==brace2 && open>close){
	                sb.append(brace2);
	                close++;
	            }
	            else if (s.charAt(i) != brace1 && s.charAt(i) != brace2)
	            {
	                sb.append(s.charAt(i));
	            }
	        }
	        
	        return sb;
	    }
    
    public static void main(String args[]){
    	String input = "()())()";
    	String str = minRemoveToMakeValid(input);
    	System.out.println(" Valid string: "+str);
    }
}
