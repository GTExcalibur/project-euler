package net.gtexcalibur.projecteuler;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/27/2017, Time: 10:56 PM
 * <br> Problem 97 - Large non-Mersenne prime
 * <pre>
 *

 The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 26972593?1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p?1, have been found which contain more digits.

 However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×27830457+1.

 Find the last ten digits of this prime number.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_097 {

    public static void main(String[] args) {
        BigInteger answer = BigInteger.valueOf(2).pow(7830457).multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE);
        String asString = answer.toString();
        System.out.println("answer: " + asString.substring(asString.length()-10));
    }
}
