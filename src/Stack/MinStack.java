package Stack;

import java.util.Stack;
/**
 * Idea: Maintain 2 stacks i.e stack1 and stack2  where stack1 will maintain all elements where as stack2 will 
 *       maintain only smallest element at the top of stack. So perform following steps inside respective stack method:
 *       a. Inside push method: 
 *          push element into stack1 but push the element into stack2 only when either stack2 is empty or element value
 *          is smaller than top of stack2.
 *       b. Inside pop method:
 *          pop element from stack1 and if that popped element from stack1 is equal to stack2.peek() then pop from stack2
 *          as well. 
 *              
 * @author Manoj.K
 *
 */
class MinStack 
{
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;
        
    /** initialize your data structure here. */
    public MinStack()
    {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) 
    {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x)
           stack2.push(x);
    }
    
    public void pop() 
    {
        int top = stack1.pop();
        if (top == stack2.peek())
        {
            stack2.pop();
        }
    }
    
    public int top()
    {
        return !stack1.isEmpty() ? stack1.peek() : -1; 
    }
    
    public int getMin() 
    {
        return !stack2.isEmpty() ? stack2.peek() : -1;
    }
}

