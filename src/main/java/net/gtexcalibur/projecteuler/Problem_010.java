package net.gtexcalibur.projecteuler;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 11:35 PM
 * <br> Problem 10 - Summation of primes
 * <pre>
 *

 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

 Find the sum of all the primes below two million.

 * </pre>
 * @author George Turner
 */
public class Problem_010 {

    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;

        for(int i = 2; i < 2000000; i++) {
            BigInteger local = BigInteger.valueOf(i);
            if(local.isProbablePrime(20)) {
                sum = sum.add(local);
            }
        }
        System.out.println("total: " + sum);
    }
}
