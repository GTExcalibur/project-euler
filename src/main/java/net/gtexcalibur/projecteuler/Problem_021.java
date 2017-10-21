package net.gtexcalibur.projecteuler;

import net.gtexcalibur.util.FactorUtils;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 21 - Amicable numbers
 * <pre>
 *

 Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ? b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.

 * </pre>
 */
public class Problem_021 {

    private static boolean isAmicable(BigInteger seed) {
        BigInteger sumOfProper = FactorUtils.properDivisors(seed).reduce(BigInteger.ZERO, BigInteger::add);

        if(!sumOfProper.equals(seed)) {
            return seed.equals(FactorUtils.properDivisors(sumOfProper).reduce(BigInteger.ZERO, BigInteger::add));
        }
        return false;
    }

    public static void main(String[] args) {
        int sumOfAmicable = IntStream.range(1, 10000)
                .filter(r -> isAmicable(BigInteger.valueOf(r)))
                .sum();

        System.out.println(sumOfAmicable);
    }
}
