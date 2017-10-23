package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 9:27 PM
 * <br> Problem 35 - Circular primes
 * <pre>
 *

 The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

 There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

 How many circular primes are there below one million?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_035 {

    static Stream<String> rotations(String seed) {
        int length = seed.length();
        return IntStream.range(0, length)
                        .mapToObj(count -> seed.substring(count) + seed.substring(0, count));
    }

    private static void sample() {
        Set<String> primeNumbers = IntStream.range(0, 100)
                                            .filter(v -> BigInteger.valueOf(v).isProbablePrime(20))
                                            .mapToObj(Integer::toString)
                                            .collect(Collectors.toCollection(TreeSet::new));

        long count = primeNumbers.stream()
                                 .filter(pn -> rotations(pn).allMatch(primeNumbers::contains))
                                 .peek(System.out::println)
                                 .count();

        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
//        sample();

        Set<String> primeNumbers = IntStream.range(0, 1000000)
                                            .filter(v -> BigInteger.valueOf(v).isProbablePrime(20))
                                            .mapToObj(Integer::toString)
                                            .collect(Collectors.toCollection(TreeSet::new));

        long count = primeNumbers.stream()
                                 .filter(pn -> rotations(pn).allMatch(primeNumbers::contains))
                                 .peek(System.out::println)
                                 .count();

        System.out.println("count: " + count);
    }
}
