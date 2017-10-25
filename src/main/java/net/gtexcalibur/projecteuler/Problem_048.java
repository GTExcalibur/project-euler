package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 9:29 PM
 * <br> Problem 48 - Self powers
 * <pre>
 *

 The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

 Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_048 {

    private static void sample() {
        BigInteger answer = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                  .map(value -> value.pow(value.intValue()))
                                  .limit(10)
                                  .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println("answer: " + answer);
    }

    public static void main(String[] args) {
//        sample();

        BigInteger answer = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                  .map(value -> value.pow(value.intValue()))
                                  .limit(1000)
                                  .reduce(BigInteger.ZERO, BigInteger::add);

        String longAnswer = answer.toString();
        System.out.println("answer: " + answer.substring(longAnswer.length()-10, longAnswer.length()));
    }
}
