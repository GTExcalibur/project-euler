package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 4:32 PM
 * <br> <br> Problem 104 - Pandigital Fibonacci ends
 * <pre>
 *

 The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn?1 + Fn?2, where F1 = 1 and F2 = 1.

 It turns out that F541, which contains 113 digits, is the first Fibonacci number for which the last nine digits are 1-9 pandigital (contain all the digits 1 to 9, but not necessarily in order). And F2749, which contains 575 digits, is the first Fibonacci number for which the first nine digits are 1-9 pandigital.

 Given that Fk is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 pandigital, find k.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_104 {

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

    static boolean isPandigital(String element) {
        if(element.length() < 9) {
            return false;
        }

        long[] bitSwitch = { 0 };

        element.chars().map(Character::getNumericValue).forEach(i -> bitSwitch[0] = bitSwitch[0] | 1<<i);
        return bitSwitch[0] == 1022; // 1024 - 2;
    }

    private static void sample() {
        BigInteger result = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                  .filter(index -> {
                                      String fibonacci = fibonacci(index).toString();
                                      return fibonacci.length() > 8 && isPandigital(fibonacci.substring(fibonacci.length() - 9));
                                  })
                                  .findFirst()
                                  .orElseThrow(IllegalStateException::new);
        System.out.println("index: " + result);

        result = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                       .filter(index -> {
                           String fibonacci = fibonacci(index).toString();
                           return fibonacci.length() > 8 && isPandigital(fibonacci.substring(0, 9));
                       })
                       .findFirst()
                       .orElseThrow(IllegalStateException::new);
        System.out.println("index: " + result);
    }


    public static void main(String[] args) {
//        sample();

        // this takes about 1-2 hours to run

        BigInteger result = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                  .filter(index -> {
                                      String fibonacci = fibonacci(index).toString();
                                      return fibonacci.length() > 8 &&
                                              isPandigital(fibonacci.substring(0, 9)) &&
                                              isPandigital(fibonacci.substring(fibonacci.length() - 9));
                                  })
                                  .findFirst()
                                  .orElseThrow(IllegalStateException::new);
        System.out.println("index: " + result);
    }




}
