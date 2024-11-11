package Misllaneous;
/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 

Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-2^31, 2^31 - 1], the final result is 42.
 * @author Manoj.K
 *
 */
public class StringToInteger {
	public int myAtoi(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        char[] chars = s.trim().toCharArray();
        int sign = chars[0] == '-' ? -1 : 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chars.length; i++) {
            if ((chars[i] == '+' || chars[i] == '-') && i == 0) {
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                sb.append(chars[i]);
            } else {
                break;
            }
        }

        chars = sb.toString().toCharArray();
        long sum = 0L;

        if(chars.length != 0) {
            sb = new StringBuilder();
            int i = 0;

            while (i < chars.length && chars[i] == '0') {
                i++;
            }

            for (; i < chars.length; i++) {
                sb.append(chars[i]);
            }

            chars = sb.toString().toCharArray();

            int n = chars.length;

            for (i = 0; i < n; i++) {
                sum = sum * 10 + (chars[i] - '0');
                if (sign == -1 && sum > Integer.MAX_VALUE) {
                    sum = Integer.MAX_VALUE + 1;
                    break;
                }
                if(sum > Integer.MAX_VALUE -1) {
                   sum = Integer.MAX_VALUE;
                }
            }
            sum *= sign;
        }
        return (int) sum;
   }
}
