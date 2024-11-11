package Stack;
import java.util.Stack;
/**
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being 
repeated exactly k times. Note that k is guaranteed to be a positive integer.

Assumptions:
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for 
those repeat numbers, k. For example, there won't be input like 3a or 2[4]
 * @author Manoj.K
 *
 *Idea: Maintain 2 stacks, one for string and other for integer. 
 *      -If character is normal character then ,Keep on creating string until we encounter opening braces 
 *       i.e '['. Once we encounter '[', push the already created string into string array. 
 *      -Keep on creating number when character is digit and push it to integer stack. 
 *      -When closing bracket is encounter, then do following:
 *       a. Create new string builder and pop the string stack top and append into sb. 
 *       b. Pop the integer stack top and loop up to it's value to repeate the already read string from
 *       last open bracket to current closing bracket. 
 *       c. After step b, append string formed in step b into sb of step a. 
 */
public class Decode {
    public static void main(String[] args) {
        String ip = "as3[a2[cd]]";
        Stack<String> st = new Stack<String>();
        Stack<Integer> cst = new Stack<Integer>();
        String res = "";

        for (int i = 0; i < ip.length(); i++) {

            char ch = ip.charAt(i);
            if (ch == ']') {
                int count = cst.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(st.pop());
                for(int j=0;j<count;j++){
                    sb.append(res);
                }
                res = sb.toString();

            }else if(Character.isDigit(ch)){
                int count = 0;
                while(Character.isDigit(ch)){
                    count = 10*count + ch - '0';
                    i++;
                    ch = ip.charAt(i);
                }
                i--;
                cst.push(count);
            }
            else if(ch == '[') 
            {
                st.push(res);
                res = "";
            }
            else {
                res += ch;
            }
        }

        System.out.print(res);
    }
}