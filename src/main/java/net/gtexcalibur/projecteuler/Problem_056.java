package net.gtexcalibur.projecteuler;

import java.math.BigInteger;

/**
 * Created by George Turner on 10/21/2017.
 * <br> Problem 56 - Powerful digit sum
 * <pre>
 *

 A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

 Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?

 * </pre>
 */
public class Problem_056 {

    public static void main(String[] args) {
        long maxDigitSum = 0;

        for(int a = 0; a < 100; a++) {
            for(int b = 0; b < 100; b++) {
                int digitSum = BigInteger.valueOf(a).pow(b).toString().chars().map(Character::getNumericValue).sum();
                if(digitSum > maxDigitSum) {
                    maxDigitSum = digitSum;
                }
            }
        }

        System.out.println(maxDigitSum);
    }
}
