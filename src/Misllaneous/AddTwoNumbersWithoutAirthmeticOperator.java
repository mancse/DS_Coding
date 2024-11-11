package Misllaneous;
/**
 * sum(10,3)
 * 
 *a=    1010
 *b=    0011
 *      ----
 * a^b= 1001
 * a&b= 0010
 * carry= a&b<<1= 0100    
 * 
 *a=      1001     
 *b=      0100
 *        ----
 * a^b=   1101
 * a&b=   1001
 *        0100
 *        ----
 *        0000
 *        
 *a=	1101
 *b=0 so return a as answer. So, answer =1101=13 
 * 
 * @author Manoj.K
 *
 */
public class AddTwoNumbersWithoutAirthmeticOperator {
	
	public static int addTwoNumbers(int a, int b){
		if (b==0){
			return a;
		}
		
		int partialSum = a ^ b;
		int carry = (a & b) << 1;
		
		return addTwoNumbers(partialSum, carry);
	}
	
	public static void main(String args[]){
		int a = 2;
		int b = 3;
		
		System.out.println(addTwoNumbers(a,b));
	}
}
