package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 25 - 1000-digit Fibonacci number
 * <pre>
 *

 The Fibonacci sequence is defined by the recurrence relation:

     Fn = Fn?1 + Fn?2, where F1 = 1 and F2 = 1.

 Hence the first 12 terms will be:

     F1 = 1
     F2 = 1
     F3 = 2
     F4 = 3
     F5 = 5
     F6 = 8
     F7 = 13
     F8 = 21
     F9 = 34
     F10 = 55
     F11 = 89
     F12 = 144

 The 12th term, F12, is the first term to contain three digits.

 What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

 * </pre>
 */
public class Problem_025 {

    private static final Map<BigInteger, BigInteger> lazyFibonacci = new HashMap<>();
    private static final BigInteger TWO = new BigInteger("2");

    static {
        lazyFibonacci.put(BigInteger.ONE, BigInteger.ONE);
        lazyFibonacci.put(TWO, BigInteger.ONE);
    }

    private static BigInteger fibonacci(BigInteger n) {
        return lazyFibonacci.computeIfAbsent(n, safe -> fibonacci(safe.subtract(BigInteger.ONE)).add(
                fibonacci(safe.subtract(TWO)))
        );
    }

    public static void main(String[] args) {
        Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
//              .peek(i -> System.out.println(String.format("%d - %d", i, fibonacci(i))))
              .filter(i -> fibonacci(i).toString().length() >= 1000)
              .findFirst()
              .ifPresent(System.out::println);
    }
}
