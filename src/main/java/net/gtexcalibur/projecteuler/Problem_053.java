package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by George Turner on 10/21/2017.
 * <br> Problem 53 - Combinatoric selections
 * <pre>
 *

 There are exactly ten ways of selecting three from five, 12345:

 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

 In combinatorics, we use the notation, 5C3 = 10.

 In general,
 nCr =
 n!
 r!(n?r)!
 	,where r ? n, n! = n×(n?1)×...×3×2×1, and 0! = 1.

 It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

 How many, not necessarily distinct, values of  nCr, for 1 ? n ? 100, are greater than one-million?

 * </pre>
 */
public class Problem_053 {

    private static final Map<BigInteger, BigInteger> factorialCache = new HashMap<>();
    static {
        factorialCache.put(BigInteger.ZERO, BigInteger.ONE);
        factorialCache.put(BigInteger.ONE, BigInteger.ONE);
    }

    private static BigInteger factorial(BigInteger seed) {
        return factorialCache.computeIfAbsent(seed, safe -> safe.multiply(factorial(safe.subtract(BigInteger.ONE))));
    }

    private static BigInteger nChooseR(int n, int r) {
        return factorial(BigInteger.valueOf(n)).divide(
                factorial(BigInteger.valueOf(r)).multiply(factorial(BigInteger.valueOf(n - r)))
        );
    }

    public static void main(String[] args) {
        BigInteger oneMillion = BigInteger.valueOf(1000000);

        long overOneMillion = 0;

        for(int n = 1; n <= 100; n++) {
            for(int r = 1; r <= n; r++) {
                if(oneMillion.compareTo(nChooseR(n, r)) < 0) {
                    overOneMillion++;
                }
            }
        }
        System.out.println(overOneMillion);
    }
}
