package Misllaneous;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        // if dividend is divided by 1 or is 0 - return dividend.
        if (divisor == 1 || dividend == 0) {
            return dividend;
        }

        // If dividend is the min value and divisor is -1, answer would overflow
        // hence return max positive integer
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // original signs of the numbers.
        boolean isNegativeDividend = dividend < 0;
        boolean isNegativeDivisor = divisor < 0;

        // We want both dividend and divisor to be of the same sign
        // Easier to keep them both negative instead of positive (due to overflow usecase)
        int a = isNegativeDividend ? dividend : -dividend;
        int b = isNegativeDivisor ? divisor : -divisor;
        int result = divideNegatives(a, b);

        // if one is negative and other is positive, answer has to be negative.
        // We can also use XOR operator "^" - but who uses that, really?
        // isNegativeA ^ isNegativeB
        return isNegativeDividend != isNegativeDivisor ? -result : result;
    }

    private int divideNegatives(int a, int b) {
        // a / b = c
        int c = 0;
        // because `a` and `b` both are always negative
        // we need to subtract `b` from `a` until `a <= b`
        while (a <= b) {
            a -= b;
            c++;
        }
        return c;
    }
}
