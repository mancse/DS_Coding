package Stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParenthesis {
	public static  List<String> removeInvalidParentheses(String s) {
        Set<String> uniqValidParenthesis = new HashSet<>();
        int minIvalidParenthesis = getMinInvalidParenthesis(s);
        removeInvalidParenthesis(s, minIvalidParenthesis, uniqValidParenthesis);
        
        List<String> result = new ArrayList<>();
        
        for (String str : uniqValidParenthesis){
            result.add(str);
        }
        
        return result;
    }
    
    private static void removeInvalidParenthesis(String s, int minInvParenthesis, Set<String> uniqValidParenthesis){
        
        if (minInvParenthesis == 0){
            
            int currInvParenthCount = getMinInvalidParenthesis(s);
            if (currInvParenthCount == 0){
                if (!uniqValidParenthesis.contains(s)){
                    uniqValidParenthesis.add(s);
                }
            }
            return;
        }
        
        for (int i=0; i<s.length(); i++){
            String part1 = s.substring(0,i);
            String part2 = s.substring(i+1);
            
            removeInvalidParenthesis(part1+part2, minInvParenthesis-1, uniqValidParenthesis);
        }
    }
    private static int getMinInvalidParenthesis(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if (ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
            	//When stack is empty and current char is ')' then it is invalid. Insert it into 
            	//stack so that it will cause invalid number of parenthesis in stack. 
                if (st.isEmpty()){
                    st.push(ch);
                }
                else if(st.peek() == '('){
                    st.pop();
                }
                else if (st.peek() == ')'){
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
    
    public static void main(String args[]){
    	List<String> result = removeInvalidParentheses("((()(((s(((()");
    	System.out.println(result);
    }
}
