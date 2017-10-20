package net.gtexcalibur.projecteuler;

import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 9:03 PM
 * <br> Problem 1 - Multiples of 3 and 5
 * <pre>
 *

 If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

 Find the sum of all the multiples of 3 or 5 below 1000.

 * </pre>
 * @author George Turner
 */
public class Problem_001 {

    private static void sample() {
        int sum = IntStream.range(1, 10)
                           .filter(i -> (i % 3 == 0) || (i % 5 == 0))
                           .sum();

        System.out.println("sum: " + sum);
    }



    public static void main(String[] args) {
        //sample();

        int sum = IntStream.range(1, 1000)
                           .filter(i -> (i % 3 == 0) || (i % 5 == 0))
                           .sum();

        System.out.println("sum: " + sum);
    }
}
