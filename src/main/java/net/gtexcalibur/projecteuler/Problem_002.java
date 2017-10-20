package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 9:10 PM
 * <br> Problem 2
 * @author George Turner
 */
public class Problem_002 {

    private static final Map<BigInteger, BigInteger> lazyFibonacci = new HashMap<>();

    private static BigInteger fibonacci(BigInteger n) {
        return lazyFibonacci.computeIfAbsent(n, safe -> {
            if(safe.compareTo(BigInteger.ONE) > 0) {
                return fibonacci(safe.subtract(BigInteger.ONE)).add(
                        fibonacci(safe.subtract(new BigInteger("2")))
                );
            } else {
                return BigInteger.ONE;
            }
        });
    }

    private static void sample() {
        System.out.println(fibonacci(BigInteger.ONE));
        System.out.println(fibonacci(new BigInteger("2")));
        System.out.println(fibonacci(new BigInteger("3")));
        System.out.println(fibonacci(new BigInteger("4")));
        System.out.println(fibonacci(new BigInteger("5")));
        System.out.println(fibonacci(new BigInteger("6")));
        System.out.println(fibonacci(new BigInteger("7")));
        System.out.println(fibonacci(new BigInteger("8")));
        System.out.println(fibonacci(new BigInteger("9")));
        System.out.println(fibonacci(new BigInteger("10")));
    }

    public static void main(String[] args) {
        //sample();

        BigInteger max = new BigInteger("4000000");
        BigInteger sum = BigInteger.ZERO;
        BigInteger lastFib;
        long counter = 1;

        do {
            lastFib = fibonacci(BigInteger.valueOf(counter));
            if(lastFib.getLowestSetBit() != 0) {
                sum = sum.add(lastFib);
            }
            System.out.println(String.format("i: %d      v: %d         s: %s", counter, lastFib, sum));
            counter++;
        } while(lastFib.compareTo(max) <= 0);


        System.out.println("sum: " + sum);
    }
}
