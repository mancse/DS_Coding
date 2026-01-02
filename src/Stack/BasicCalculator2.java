/**
 ** Problem: https://leetcode.com/problems/basic-calculator-ii/
 ** Idea: While scaning the input expression, if digit then form the number and once operator is encountered, push the number in the stack based on last operator and not 
 ** on current operator. So, if last operator is + or - then push in stack with it's sign else if last operator is * or / then pop from stack to get previous number and 
 ** apply * or / with current number and push again in the stack. When new operator is encountered, save it as last operator to be evaluated later. Also, evaluate operator
 ** calculation on last of the string. 
 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        //Consider + as default operator
        char lastOperator = '+'; 
        int num = 0;

        for (int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            
            //Note: i == s.length() -1 condition is to process the last operator for end of the input. 
            if (ch != ' ' && !Character.isDigit(ch) || i == s.length() -1){

                if (lastOperator == '+'){
                    st.push(num);
                    num = 0;
                }
                else if (lastOperator == '-'){
                    st.push(-1 * num);
                    num = 0; 
                 }
                else if (lastOperator == '*'){
                    int prevNum = st.pop();
                    st.push(prevNum * num);
                    num=0;
                }
                else if (lastOperator == '/'){
                    int prevNum = st.pop();
                    st.push(prevNum / num);
                    num = 0;
                }

                //Update current operator as lastOperator for next calculation.
                lastOperator = ch;
            }
        }

        int res = 0;

        while(!st.isEmpty()){
            res += st.pop();
        }

        return res;
    }
}
