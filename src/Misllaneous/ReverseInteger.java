package Misllaneous;
/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0

Leetcode: https://leetcode.com/problems/reverse-integer/
 * @author Manoj.K
 *
 */
public class ReverseInteger {
public int reverse(int x) {
        int rev = 0;
        
        while (x !=0){
            int rem = x % 10;
            
            if ((rev > Integer.MAX_VALUE/10) 
            || (rev == Integer.MAX_VALUE && rem > Integer.MAX_VALUE % 10))
            return 0;
            
            if ((rev < Integer.MIN_VALUE/10)
            || (rev == Integer.MIN_VALUE && rem < Integer.MIN_VALUE % 10))
            return 0;
            
            x = x/10;
            rev = rev * 10 + rem;
        }
        return rev;
        
    }
}
