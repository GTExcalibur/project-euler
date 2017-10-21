package net.gtexcalibur.projecteuler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 34 - Digit factorials
 * <pre>
 *

 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

 Find the sum of all numbers which are equal to the sum of the factorial of their digits.

 Note: as 1! = 1 and 2! = 2 are not sums they are not included.

 * </pre>
 */
public class Problem_034 {

    private static final Map<Integer, Long> factorialCache = new HashMap<>();
    static {
        factorialCache.put(0, 1L);
        factorialCache.put(1, 1L);
        factorialCache.put(2, 2L);
    }

    private static long factorial(int value) {
        return factorialCache.computeIfAbsent(value, safe -> safe * factorial(safe-1));
    }

    private static boolean curiousNumber(long value) {
        return value == String.valueOf(value).chars().map(Character::getNumericValue).mapToLong(Problem_034::factorial).sum();
    }

    public static void main(String[] args) {
        long sum = LongStream.range(3, 100000) // hoping this is a big enough number
                .filter(Problem_034::curiousNumber)
                .sum();
        System.out.println(sum);
    }
}
