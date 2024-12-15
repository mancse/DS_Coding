package Stack;

import java.util.Stack;

public class ValidParenthesis
{
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		boolean ret = false;
		for (int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '['){
				st.push(ch);
			}
			else{
				if (st.isEmpty()){
					return false;
				}
				else{
					if (!isMatched(st.peek(),ch)){
						return false;
					}
					st.pop();
				}
			}
		}
		if (st.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isMatched(char open, char closed){
		if (open == '(' && closed == ')'){
			return true;
		}
		else if (open == '{' && closed == '}'){
			return true;
		}
		else if (open == '[' && closed == ']'){
			return true;
		}
		else{
			return false;
		}
	}
}
