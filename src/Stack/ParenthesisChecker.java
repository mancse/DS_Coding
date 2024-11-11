package Stack;

public class ParenthesisChecker 
{
    static class stack
    {
    	int top = -1;
    	int STACK_SIZE = 100;
    	char [] items = new char[STACK_SIZE];
    	
    	public void push(char c)
    	{
    		if (top == STACK_SIZE)
    		{
    			System.out.println("Stack is full");
    		}
    		else
    		{
    			items[++top] = c;
    		}
    	}
    	
    	public char pop()
    	{
    		char ret = ' ';
    		if (top == -1)
    		{
    			System.out.println("Stack is empty");
    		}
    		else
    		{
    			ret = items[top--];
    		}
    		return ret;
    	}
    	
    	public boolean isEmpty()
    	{
    		return top == -1 ? true: false;
    	}
    }
    
    public static boolean  isValid(String str) 
    {
        boolean ret = false;
    	stack st = new stack();
    	
    	int i = 0;
    	while (i < str.length())
    	{
            char ch = str.charAt(i);
    		if ( ch == '[' || ch == '{' || ch == '(')
    		{
    			st.push(ch);
    		}
    		
    		else if (ch == ']' || ch == '}' || ch == ')')
    		{
    			if (st.isEmpty())
    			{
    		        ret = false;
    			    return ret;
    			}
    			char top = st.pop();
    			if (!isMatching(top ,ch))
    			{
    				ret = false;
    				return ret;
    			}
    		}
    		i++;
    	}
    	
    	if (! st.isEmpty())
    		ret = false;
    	else 
    		ret = true;
    	
    	return ret;
    }
    
    
    public static boolean isMatching(char c1 , char c2)
    {
    	if (c1 == '(' && c2 == ')')
    		return true;
    	else if (c1 == '{' && c2 == '}')
    		return true;
    	else if (c1 == '[' && c2 == ']')
    		return true;
    	else
    		return false;
    }
    
    public static void main (String args[])
    {
        boolean isBalanced = isValid("{{()}}[]");
    	System.out.println(" "+ (isBalanced ? "Balanced" : "Not Balanced"));
    }
}
