package Graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 *
 * Idea: Approach
 * 1. Breadth-First Search (BFS):
 * Start with the original string and generate all possible strings by removing one parenthesis at a time.
 * Check if a generated string is valid. If valid, stop further processing for that string length.
 * Use a queue to perform BFS and a set to avoid processing duplicate strings.
 * 2. Validity Check:
 * Count open and close parentheses:
 * Increment for ( and decrement for ).
 * If the count goes negative, the string is invalid.
 * 3. Complexity:
 * The BFS ensures we explore all strings of minimal removals first.
 * Time complexity is exponential in the number of parentheses to remove, but pruning invalid strings early reduces unnecessary computations.
 *
 */
public class RemoveMinimumInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        que.add(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        boolean found = false;
        while(!que.isEmpty()){
            String str = que.poll();
            if (isValid(str)){
                res.add(str);
                found = true;
            }

            // If valid strings are found, do not process deeper levels so that maximum valid
            //parenthesis are found. Eg. for input "()())()" closing brace at i=1 is removed and closing brace at indes at index 4 removed in previous call and queue has valid strings
            // "(())()" and "()()()" are already added in que in previous call so just add them as result and skip further removal of braces to get shorter string.
            if (found)
                continue;

            for(int i=0; i<str.length(); i++){
                if (str.charAt(i) == '(' || str.charAt(i) == ')'){
                    String str2 = str.substring(0,i) + str.substring(i+1);
                    if (!visited.contains(str2)){
                        visited.add(str2);
                        que.add(str2);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s){
        int count=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                count++;
            }
            else if (s.charAt(i) == ')'){
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
