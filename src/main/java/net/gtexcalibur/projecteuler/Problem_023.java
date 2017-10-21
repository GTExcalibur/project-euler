package net.gtexcalibur.projecteuler;

import net.gtexcalibur.util.FactorUtils;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 23 - Non-abundant sums
 * <pre>
 *

 A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

 * </pre>
 */
public class Problem_023 {

    private static boolean isAbundant(long seed) {
        BigInteger source = BigInteger.valueOf(seed);
        return FactorUtils.properDivisors(source).reduce(BigInteger.ZERO, BigInteger::add).compareTo(source) > 0;
    }

    private static boolean canSumWithTwoAbundantNumbers(List<Integer> abundantNumbers, int test) {
        List<Integer> possibleTests = abundantNumbers.stream().filter(v -> v <= test).collect(Collectors.toList());
        for (Integer sum1 : possibleTests) {
            for (Integer sum2 : possibleTests) {
                if(sum1 + sum2 == test) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> abundantNumbers = IntStream.rangeClosed(1, 28123)
                .filter(Problem_023::isAbundant)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        BigInteger sumOfAllNumbers = IntStream.rangeClosed(1, 28123)
                .filter(v -> !canSumWithTwoAbundantNumbers(abundantNumbers, v))
//                .peek(System.out::println)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);
        System.out.println("answer: " + sumOfAllNumbers);
    }

}
