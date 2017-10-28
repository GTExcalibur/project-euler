package net.gtexcalibur.projecteuler;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/27/2017, Time: 11:02 PM
 * <br> Problem 92 - Square digit chains
 * <pre>
 *

 A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

 For example,

 44 ? 32 ? 13 ? 10 ? 1 ? 1
 85 ? 89 ? 145 ? 42 ? 20 ? 4 ? 16 ? 37 ? 58 ? 89

 Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

 How many starting numbers below ten million will arrive at 89?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_092 {


    private static long sumOfSquareOfDigits(long number) {
        return Long.toString(number).chars().map(Character::getNumericValue).map(i -> i*i).sum();
    }

    private static boolean loopContains89(long start) {
        Set<Long> visitedNumbers = new LinkedHashSet<>();

        LongStream.iterate(start, Problem_092::sumOfSquareOfDigits)
                  .filter(num -> !visitedNumbers.add(num))
                  .findFirst();

        return visitedNumbers.contains(89L);
    }


    public static void main(String[] args) {
        long answer = LongStream.range(1, 10000000)
                                .filter(Problem_092::loopContains89)
                                .count();

        System.out.println("answer: " + answer);
    }
}
