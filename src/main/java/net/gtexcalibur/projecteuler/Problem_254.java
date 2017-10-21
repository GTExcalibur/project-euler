package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by George Turner on 10/21/2017.
 * <br> Problem 254 - Sums of Digit Factorials
 * <pre>
 *

 Define f(n) as the sum of the factorials of the digits of n. For example, f(342) = 3! + 4! + 2! = 32.

 Define sf(n) as the sum of the digits of f(n). So sf(342) = 3 + 2 = 5.

 Define g(i) to be the smallest positive integer n such that sf(n) = i. Though sf(342) is 5, sf(25) is also 5, and it can be verified that g(5) is 25.

 Define sg(i) as the sum of the digits of g(i). So sg(5) = 2 + 5 = 7.

 Further, it can be verified that g(20) is 267 and ??sg(i) for 1 ? i ? 20 is 156.

 What is ??sg(i) for 1 ? i ? 150?

 * </pre>
 */
public class Problem_254 {

    private static final Map<BigInteger, BigInteger> factorialCache = new HashMap<>();
    static {
        factorialCache.put(BigInteger.ZERO, BigInteger.ONE);
        factorialCache.put(BigInteger.ONE, BigInteger.ONE);
    }
    private static final Map<BigInteger, BigInteger> function_sfCache = new HashMap<>();

    private static BigInteger factorial(BigInteger seed) {
        return factorialCache.computeIfAbsent(seed, safe -> safe.multiply(factorial(safe.subtract(BigInteger.ONE))));
    }

    private static BigInteger function_f(BigInteger n) {
        return n.toString().chars().map(Character::getNumericValue).mapToObj(v -> factorial(BigInteger.valueOf(v))).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private static BigInteger function_sf(BigInteger n) {
        return BigInteger.valueOf( function_f(n).toString().chars().map(Character::getNumericValue).sum() );
    }

    private static BigInteger function_g(BigInteger n) {
        return Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                     .filter(local -> function_sfCache.computeIfAbsent(local, Problem_254::function_sf).equals(n))
                     .findFirst()
                     .orElseThrow(IllegalStateException::new);
    }

    private static BigInteger function_sg(BigInteger n) {
        return BigInteger.valueOf( function_g(n).toString().chars().map(Character::getNumericValue).sum() );
    }

    private static void sample() {
        BigInteger answer = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                .limit(20)
                .map(Problem_254::function_sg)
                .reduce(BigInteger.ZERO, BigInteger::add);
        System.out.println(answer);
    }

    public static void main(String[] args) {
//        sample();

        BigInteger answer = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                .limit(150)
                .map(Problem_254::function_sg)
                .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println(answer);
    }
}
