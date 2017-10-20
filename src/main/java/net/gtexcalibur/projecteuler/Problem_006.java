package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 10:49 PM
 * <br> Problem 6 - Sum square difference
 * <pre>
 *

 The sum of the squares of the first ten natural numbers is,
 12 + 22 + ... + 102 = 385

 The square of the sum of the first ten natural numbers is,
 (1 + 2 + ... + 10)2 = 552 = 3025

 Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

 Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

 * </pre>
 * @author George Turner
 */
public class Problem_006 {

    private static BigInteger sumOfSquares(int bound) {
        BigInteger sum = BigInteger.ZERO;

        for(int i = 1; i <= bound; i++) {
            sum = sum.add(BigInteger.valueOf(i*i));
        }
        return sum;
    }

    private static BigInteger squareOfSums(int bound) {
        int sum = IntStream.rangeClosed(1, bound).sum();
        return BigInteger.valueOf(sum*sum);
    }

    private static void sample() {
        System.out.println(squareOfSums(10).subtract(sumOfSquares(10)));
    }

    public static void main(String[] args) {
//        sample();

        System.out.println(squareOfSums(100).subtract(sumOfSquares(100)));
    }


}
