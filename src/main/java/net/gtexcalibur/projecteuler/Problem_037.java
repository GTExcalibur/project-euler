package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 9:52 PM
 * <br> Problem 37 - Truncatable primes
 * <pre>
 *

 The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

 Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

 NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_037 {

    private static boolean isTruncatablePrime(Set<String> primes, String test) {
        final int length = test.length();
        return IntStream.range(0, length)
                        .allMatch(c -> primes.contains(test.substring(c)) && primes.contains(test.substring(0, length - c)));
    }

    public static void main(String[] args) {
        Set<String> primeNumbers = IntStream.range(0, 1000000)
                                            .filter(v -> BigInteger.valueOf(v).isProbablePrime(20))
                                            .mapToObj(Integer::toString)
                                            .collect(Collectors.toCollection(LinkedHashSet::new));

        long sum = primeNumbers.stream()
                               .skip(4)
                               .filter(pn -> isTruncatablePrime(primeNumbers, pn))
                               .peek(System.out::println)
                               .mapToLong(Long::parseLong)
                               .sum();

        System.out.println("sum: " + sum);
    }



}
