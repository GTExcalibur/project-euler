package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/27/2017, Time: 10:24 PM
 * <br> Problem 50 - Consecutive prime sum
 * <pre>
 *

 The prime 41, can be written as the sum of six consecutive primes:
 41 = 2 + 3 + 5 + 7 + 11 + 13

 This is the longest sum of consecutive primes that adds to a prime below one-hundred.

 The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

 Which prime, below one-million, can be written as the sum of the most consecutive primes?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_050 {

    private static BigInteger matchingPrime(List<BigInteger> primeSet, long maxSum) {
        BigInteger maxLength = BigInteger.ZERO;
        BigInteger answer = BigInteger.ZERO;

        for(long skip = 0; skip < Math.sqrt(maxSum); skip++) {
            innerLoop:

            for(long length = 2; length < Math.sqrt(maxSum); length++) {
                BigInteger newPossPrime = primeSet.stream().skip(skip)
                                                  .limit(length)
                                                  .reduce(BigInteger.ZERO, BigInteger::add);
                if(newPossPrime.compareTo(BigInteger.valueOf(maxSum)) > 0) {
                    break innerLoop;
                }
                if(newPossPrime.isProbablePrime(20) && BigInteger.valueOf(length).compareTo(maxLength) > 0) {
                    maxLength = BigInteger.valueOf(length);
                    answer = newPossPrime;
                }
            }
        }
        return answer;
    }

    private static void sample() {
        List<BigInteger> primeSet = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                          .filter(pp -> pp.isProbablePrime(20))
                                          .limit(1000)
                                          .collect(Collectors.toList());

        System.out.println("primeSet: " + primeSet);

        System.out.println("answer - 100: " + matchingPrime(primeSet, 100));
        System.out.println("answer - 1000: " + matchingPrime(primeSet, 1000));
    }


    public static void main(String[] args) {
//        sample();

        List<BigInteger> primeSet = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                          .filter(pp -> pp.isProbablePrime(20))
                                          .limit(5000)
                                          .collect(Collectors.toList());

        System.out.println("primeSet: " + primeSet);

        System.out.println("answer - 1000000: " + matchingPrime(primeSet, 1000000));
    }
}
