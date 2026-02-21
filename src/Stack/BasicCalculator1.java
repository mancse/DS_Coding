/**
** Problem: https://leetcode.com/problems/basic-calculator/
** 
*/
class Solution {
    public int calculate(String s) {
        int sign = 1;
        int num = 0;
        int res = 0;
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch != ' '){
                if (Character.isDigit(ch)){
                    num = num * 10 + ch - '0';
                }

                if (ch == '+'){
                    res = res + sign * num;
                    num = 0;
                    sign = 1;
                }
                
                else if (ch == '-'){
                    res = res + sign * num;
                    num = 0; 
                    sign = -1;
                }

                else if (ch == '('){
                    st.push(res);
                    st.push(sign);
                    num = 0;
                    res = 0;
                    sign = 1;
                }

                else if (ch == ')'){
                    res = res + num * sign;
                    int prevSign = st.pop();
                    int prevRes = st.pop();
                    res = prevRes + res * prevSign;
                    num = 0;
                }
            }
        }
        // Finally at end of string
        return res + num * sign;
    }
}
