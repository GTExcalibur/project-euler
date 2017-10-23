package net.gtexcalibur.projecteuler;

import net.gtexcalibur.util.EnumerationUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 7:53 PM
 * <br> Problem 30 - Digit fifth powers
 * <pre>
 *

 Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

 1634 = 14 + 64 + 34 + 44
 8208 = 84 + 24 + 04 + 84
 9474 = 94 + 44 + 74 + 44

 As 1 = 14 is not a sum it is not included.

 The sum of these numbers is 1634 + 8208 + 9474 = 19316.

 Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_030 {

    private static void sample() {

        long sum = EnumerationUtils.enumerations(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 4)
                                   .skip(2)
                                   .filter(tuple -> Long
                                           .parseLong(tuple.stream().collect(Collectors.joining())) == tuple.stream()
                                                                                                            .map(Long::parseLong)
                                                                                                            .mapToLong(v -> (long) Math.pow(v, 4))
                                                                                                            .sum())
                                   .mapToLong(tuple -> Long.parseLong(tuple.stream().collect(Collectors.joining())))
                                   .sum();

        System.out.println("sum: " + sum);
    }

    public static void main(String[] args) {
        sample();

        long sum = EnumerationUtils.enumerations(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 6)  // all numbers, not just 5 digits
                                   .skip(2)
                                   .filter(tuple -> Long
                                           .parseLong(tuple.stream().collect(Collectors.joining())) == tuple.stream()
                                                                                                            .map(Long::parseLong)
                                                                                                            .mapToLong(v -> (long) Math.pow(v, 5))
                                                                                                            .sum())
                                   .peek(System.out::println)
                                   .mapToLong(tuple -> Long.parseLong(tuple.stream().collect(Collectors.joining())))
                                   .sum();

        System.out.println("sum: " + sum);
    }

}
