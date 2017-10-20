package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 9:48 PM
 * <br> Problem 3 - Largest prime factor
 * <pre>
 *

 The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?

 * </pre>
 * @author George Turner
 */
public class Problem_003 {

    private static final Map<BigInteger, Boolean> isPrimeCache = new HashMap<>();
    static {
        isPrimeCache.put(BigInteger.valueOf(2L), true);
        isPrimeCache.put(BigInteger.valueOf(3L), true);
        isPrimeCache.put(BigInteger.valueOf(4L), false);
        isPrimeCache.put(BigInteger.valueOf(5L), true);
    }

    private static boolean isFactor(BigInteger number, BigInteger factor) {
        return number.mod(factor).equals(BigInteger.ZERO);
    }

    private static boolean isPrime(BigInteger number) {
        return isPrimeCache.computeIfAbsent(number, safe -> {
            if(safe.isProbablePrime(20)) {
                /*// do the heavy weight check
                for(BigInteger bi = safe.subtract(BigInteger.ONE);
                    bi.compareTo(BigInteger.ONE) > 0;
                    bi = bi.subtract(BigInteger.ONE)) {
                    if(isFactor(safe, bi)) {
                        return false;
                    }
                }*/
                return true;
            }
            return false;
        });
    }


    private static void sample() {
        BigInteger start = BigInteger.valueOf(13195);

        for(BigInteger bi = BigInteger.valueOf((long) Math.pow(start.longValue(), 0.5) + 1);
            bi.compareTo(BigInteger.ONE) > 0;
            bi = bi.subtract(BigInteger.ONE)) {
            if(isPrime(bi) && isFactor(start, bi)) {
                System.out.println("Prime Factor: " + bi);
            }
        }
    }

    public static void main(String[] args) {
//        sample();

        BigInteger start = new BigInteger("600851475143");

        for(BigInteger bi = BigInteger.valueOf((long) Math.pow(start.longValue(), 0.5) + 1);
            bi.compareTo(BigInteger.ONE) > 0;
            bi = bi.subtract(BigInteger.ONE)) {
            if(isPrime(bi) && isFactor(start, bi)) {
                System.out.println("Prime Factor: " + bi);
            }
        }
    }
}
