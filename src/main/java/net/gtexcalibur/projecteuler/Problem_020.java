package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 20 - Factorial digit sum
 * <pre>
 *

 n! means n × (n ? 1) × ... × 3 × 2 × 1

 For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

 Find the sum of the digits in the number 100!

 * </pre>
 */
public class Problem_020 {

    private static final Map<BigInteger, BigInteger> factorialCache = new HashMap<>();
    static {
        factorialCache.put(BigInteger.ONE, BigInteger.ONE);
    }

    private static BigInteger factorial(BigInteger seed) {
        return factorialCache.computeIfAbsent(seed, safe -> safe.multiply(factorial(safe.subtract(BigInteger.ONE))));
    }

    private static void sample() {
        int digitsSum = factorial(BigInteger.valueOf(10))
                            .toString()
                            .chars()
                            .map(Character::getNumericValue)
                            .sum();
        System.out.println(digitsSum);
    }

    public static void main(String[] args) {
//        sample();

        int digitsSum = factorial(BigInteger.valueOf(100))
                            .toString()
                            .chars()
                            .map(Character::getNumericValue)
                            .sum();
        System.out.println(digitsSum);
    }

}
