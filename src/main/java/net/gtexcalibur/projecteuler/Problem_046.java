package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 8:46 PM
 * <br> Problem 46 - Goldbach's other conjecture
 * <pre>
 *

 It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

 9 = 7 + 2×12
 15 = 7 + 2×22
 21 = 3 + 2×32
 25 = 7 + 2×32
 27 = 19 + 2×22
 33 = 31 + 2×12

 It turns out that the conjecture was false.

 What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_046 {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    static boolean canWriteAsSumOfPrimeAndTwiceASquare(long test) {
        long limit = (long) Math.sqrt(test) + 1;
        return LongStream.range(1, limit)
                         .filter(square -> BigInteger.valueOf(test - (square * square * 2)).isProbablePrime(20))
                         .findFirst()
                         .isPresent();
    }

    public static void main(String[] args) {
        OptionalLong answer = LongStream.iterate(9L, i -> i + 2)
                                        .filter(num -> !BigInteger.valueOf(num).isProbablePrime(20))
                                        .filter(num -> !canWriteAsSumOfPrimeAndTwiceASquare(num))
                                        .findFirst();
        System.out.println("answer: " + answer);
    }


}
