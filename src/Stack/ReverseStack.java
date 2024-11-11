package Stack;
import java.util.Stack;
/**
 * Stack contains elements 1,2,3 where 1 is at top and 3 is at bottom.
 * Reverse the stack so that it should store elements like 3,2,1 where 3 will be at top and 1 at bottom.
 * 
 * Debugging Steps:
 * stack- 1,2,3
 * reverseStack(stack)-->stack.isEmpty()=false-->tmp=stack.pop()=1
 * stack- 2,3  tmp=1
 * reverseStack(stack)-->stack.isEmpty()=false-->tmp=stack.pop()=2
 * stack- 3    tmp=2
 * reverseStack(stack)-->stack.isEmpty()=false-->tmp=stack.pop()=3
 * stack- _    tmp=3
 * reverseStack(stack)-->stack.isEmpty()=true --> return stack
 * stack- _ tmp=3
 * insertAtBottomOfStack(stack,tmp)-->stack.isEmpty()=true-->stack.push(3)
 * stack-3, tmp=2
 * insertAtBottomOfStack(stack,tmp)-->stack.isEmpty()=false-->tmp1=stack.pop()
 * stack- tmp=2  tmp1=3--> stack.isEmpty()-->true-->stack.push(tmp)-->stack.push(2)
 * stack-2  stack.push(tmp1)--> stack.push(3)
 * stack-3,2  tmp=1-->`insertAtBottomOfStack(stack,tmp)-->insertAtBottomOfStack(stack,1)
 * stack.isEmpty()=false-->tmp1=stack.pop()=3-->insertAtBottomOfStack(stack,1)-->stack.isEmpty()=false
 * stack=2 , tmp1=stack.pop()-->tmp1=2-->insertAtBottomOfStack(stack,1)-->stack.isEmpty()=true
 * stack.push(1)-->stack=1, stack.push(tmp1)=stack.push(2)-->stack=2,1-->stack.push(tmp1)-->stack.push(3)
 * stack=3,2,1
 * @author Manoj.K
 *
 */
public class ReverseStack {

	public static Stack<Integer> reverseStack(Stack<Integer> stack){
		if (stack.isEmpty()){
			return stack;
		}
		
		int tmp = stack.pop();
		reverseStack(stack);
		insertAtBottomOfStack(stack,tmp);
		return stack;
	}
	private static void insertAtBottomOfStack(Stack<Integer> stack, int k){
	    if (stack.isEmpty()){
	    	stack.push(k);
	    	return;
	    }
	    int tmp1 = stack.pop();
	    insertAtBottomOfStack(stack,k);
	    stack.push(tmp1);
	}
	
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		Stack<Integer> st = reverseStack(stack);
		System.out.println("Reversed stack is: ");
		while(!st.isEmpty()){
			int i = st.pop();
			System.out.print(" "+i);
		}
	}
}
