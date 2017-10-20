package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 10:56 PM
 * <br> Problem 7 - 10001st prime
 * <pre>
 *

 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

 What is the 10 001st prime number?

 * </pre>
 * @author George Turner
 */
public class Problem_007 {


    private static void sample() {
        Stream.iterate(BigInteger.valueOf(2), bi -> bi.add(BigInteger.ONE))
              .filter(bi -> bi.isProbablePrime(20))
              .limit(6)
              .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        sample();

        Stream.iterate(BigInteger.valueOf(2), bi -> bi.add(BigInteger.ONE))
              .filter(bi -> bi.isProbablePrime(20))
              .limit(10001)
              .forEach(System.out::println);
    }
}
