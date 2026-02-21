/**
** Problem: https://leetcode.com/problems/remove-k-digits/

** Idea: Whole idea is that if a a bigger digit is present in the left of smaller digit then the the value of the the number will be bigger. So, if a bigger digit present in the left of smaller digit then we need to remove the left bigger one. 

So, in short, once current digit is smaller than previous digit then remove the previous bigger digit. Monotonic increasing stack is used for this. 
 */
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for (int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && st.peek() > ch && k > 0){
                st.pop();
                k--;
            }

            //This condition for the case like input 10200 where, stack has entry as '1' and on arriaval of char '0', 1 is removed. then stack becomes empty and then character '0' would be the left most digit which doesn't need to preserve as left most 0 doesn't has any significance. like in 0200, leftmost 0 has no significance.  
            if (st.isEmpty() && ch == '0'){
                continue;
            }
            st.push(num.charAt(i));
        }

        /**
        ** This is for edge case when k > 0 and stack still has entries. So, remove entries from top until k == 0 which ensures that all bigger digits removed. 
         */
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}
