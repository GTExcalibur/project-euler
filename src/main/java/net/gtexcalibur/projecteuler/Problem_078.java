package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 12:33 AM
 * <br> Problem 78 - Coin partitions
 * <pre>
 *

 Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five coins can be separated into piles in exactly seven different ways, so p(5)=7.
 OOOOO
 OOOO   O
 OOO   OO
 OOO   O   O
 OO   OO   O
 OO   O   O   O
 O   O   O   O   O

 Find the least value of n for which p(n) is divisible by one million.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_078 {

    private static final Map<BigInteger, BigInteger> permutationCache = new HashMap<>();
    static {
        permutationCache.putIfAbsent(BigInteger.ZERO, BigInteger.ONE);
    }

    static BigInteger permutationFunction(BigInteger n) {
        return permutationCache.computeIfAbsent(n, safe -> {
            BigInteger sum = BigInteger.ZERO;

            Iterator<BigInteger> generalPentagonalNumbers = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                                                  .flatMap(i -> Stream.of(i, BigInteger.valueOf(-1).multiply(i)))
                                                                  .iterator();

            BigInteger element = generalPentagonalNumbers.next();

            BigInteger pentagonNumber = applyPentagonalFormula(element);

            while(pentagonNumber.compareTo(safe) <= 0) {
                boolean add = Math.pow(-1, Math.abs(element.longValue()) - 1) > 0;
                if(add) {
                    sum = sum.add(permutationFunction(safe.subtract(pentagonNumber)));
                } else {
                    sum = sum.subtract(permutationFunction(safe.subtract(pentagonNumber)));
                }

                element = generalPentagonalNumbers.next();
                pentagonNumber = applyPentagonalFormula(element);
            }

            return sum;

        });
    }

    private static BigInteger applyPentagonalFormula(BigInteger n) {
        return n.multiply(BigInteger.valueOf(3)).subtract(BigInteger.ONE).multiply(n).divide(BigInteger.valueOf(2));
    }

    /*private static boolean testCalculation(int value) {
        long count = countPartitions(value, value);
        System.out.println("value: " + value + " - " + count);
        return count % 1000000 == 0;
    }

    private static long countPartitions(long start, long max) {
        if(start <= 0) {
            return 1L;
        }

        long sum = 0;
        for(long iter = Math.min(start, max); iter > 0; iter--) {
            sum += countPartitions(start-iter, iter);
        }
        return sum;
    }*/

    public static void main(String[] args) {
        /*System.out.println(permutationFunction(BigInteger.valueOf(1)));
        System.out.println(permutationFunction(BigInteger.valueOf(2)));
        System.out.println(permutationFunction(BigInteger.valueOf(3)));
        System.out.println(permutationFunction(BigInteger.valueOf(4)));
        System.out.println(permutationFunction(BigInteger.valueOf(5)));*/

        OptionalInt answer = IntStream.range(1, 100000)
                                      .filter(i -> permutationFunction(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000000)).equals(BigInteger.ZERO))
                                      .findFirst();

        System.out.println("answer: " + answer);
    }
}
