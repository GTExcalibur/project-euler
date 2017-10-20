package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 16 - Power digit sum
 * <pre>
 *

 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

 What is the sum of the digits of the number 21000?

 * </pre>
 */
public class Problem_016 {

    private static void sample() {
        Integer sumOfDigits = IntStream.range(1, 16)
                .mapToObj(ignore -> BigInteger.valueOf(2))
                .reduce(BigInteger.ONE, BigInteger::multiply)
                .toString()
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.summingInt(i -> i));

        System.out.println(sumOfDigits);
    }

    public static void main(String[] args) {
        Integer sumOfDigits = IntStream.range(1, 1001)
                .mapToObj(ignore -> BigInteger.valueOf(2))
                .reduce(BigInteger.ONE, BigInteger::multiply)
                .toString()
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.summingInt(i -> i));

        System.out.println(sumOfDigits);
    }
}
