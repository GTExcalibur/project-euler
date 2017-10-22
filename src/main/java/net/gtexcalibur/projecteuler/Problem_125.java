package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 3:42 PM
 * <br> Problem 125 - Palindromic sums
 * <pre>
 *

 The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 62 + 72 + 82 + 92 + 102 + 112 + 122.

 There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, and the sum of these palindromes is 4164. Note that 1 = 02 + 12 has not been included as this problem is concerned with the squares of positive integers.

 Find the sum of all the numbers less than 108 that are both palindromic and can be written as the sum of consecutive squares.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_125 {

    static boolean isPalindromic(String asString) {
        int length = asString.length();
        for(int i = 0; i < length; i++) {
            if(asString.charAt(i) != asString.charAt(length-i-1)) {
                return false;
            }
        }
        return true;
    }

    static boolean canWriteAsSumOfConsecutiveSquares(long test) {
        long sqrt = (long) Math.sqrt(test);

        for(long skip = 0; skip <= sqrt; skip++) {
            innerLoop:
            for(long limit = 2; limit <= (sqrt - skip); limit++) {
                long localSum = LongStream.rangeClosed(1, sqrt).skip(skip).limit(limit).map(l -> l * l).sum();

                if(localSum == test) {
                    return true;
                } else if(localSum > test) {
                    // break inner loop
                    break innerLoop;
                }
            }
        }
        return false;
    }

    private static void sample() {
        long sum = LongStream.range(1, 1000)
                             .filter(i -> isPalindromic(Long.toString(i)))
                             .filter(Problem_125::canWriteAsSumOfConsecutiveSquares)
                             .peek(System.out::println)
                             .sum();
        System.out.println("sum: " + sum);
    }

    public static void main(String[] args) throws InterruptedException {
//        sample();

        // other way ...
         BigInteger sum = BigInteger.ZERO;
         Set<Long> duplicates = new HashSet<>();

         long totalLimit = (long) Math.pow(10, 8);
//         long totalLimit = 1000;
         long sqrt = (long) Math.pow(totalLimit, 0.5);

         for(long skip = 0; skip <= sqrt; skip++) {
             innerLoop:
             for(long limit = 2; limit <= (sqrt - skip); limit++) {
                 long localSum = LongStream.rangeClosed(1, sqrt).skip(skip).limit(limit).map(l -> l * l).sum();

                 if(isPalindromic(Long.toString(localSum)) && localSum <= totalLimit && duplicates.add(localSum)) {
                     sum = sum.add(BigInteger.valueOf(localSum));
                 } else if(localSum > totalLimit) {
                     break innerLoop;
                 }
             }
         }

         System.out.println("sum: " + sum);
    }

    private static void bruteForce() throws InterruptedException {
        final Object lock = new Object();
        final AtomicLong jobCount = new AtomicLong(0);
        BigInteger[] sum = { BigInteger.ZERO };

        ExecutorService executorService = Executors.newFixedThreadPool(25);

        LongStream.range(1, (long) Math.pow(10, 8))
                  .peek(l -> {
                      if(l % 10000 == 0) {
                          System.out.println("progress: " + l);
                      }
                  })
                  .filter(i -> isPalindromic(Long.toString(i)))
                  .peek(ignore -> jobCount.incrementAndGet())
                  .forEach(l -> executorService.submit(() -> {
                      try {
                          if(canWriteAsSumOfConsecutiveSquares(l)) {
                              synchronized (lock) {
                                  sum[0] = sum[0].add(BigInteger.valueOf(l));
                              }
                          }
                      } finally {
                          long jobLocal = jobCount.decrementAndGet();
                          if(jobLocal % 1000 == 0) {
                              System.out.println("job: " + jobLocal);
                          }
                      }
                  }));

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("sum: " + sum[0]);
    }
}
