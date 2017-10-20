package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 14 - Longest Collatz sequence
 * <pre>
 *

 The following iterative sequence is defined for the set of positive integers:

 n ? n/2 (n is even)
 n ? 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:
 13 ? 40 ? 20 ? 10 ? 5 ? 16 ? 8 ? 4 ? 2 ? 1

 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.

 * </pre>
 */
public class Problem_014 {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    private static Stream<BigInteger> collatz(BigInteger start) {
        return Stream.concat(
                Stream.of(start),
                StreamSupport.stream(
                        new MultipleElementSpliterator<BigInteger>(Long.MAX_VALUE, Spliterator.NONNULL) {
                            BigInteger current = start;

                            @Override
                            protected boolean tryAdvanceMultiple(Consumer<? super BigInteger> action) {
                                if (current.getLowestSetBit() != 0) {
                                    current = current.divide(TWO);
                                } else {
                                    current = current.multiply(THREE).add(BigInteger.ONE);
                                }
                                action.accept(current);
                                return !BigInteger.ONE.equals(current);
                            }
                        },
                        false
                )
        );
    }

    private static void sample() {
        System.out.println(collatz(BigInteger.valueOf(13)).map(Objects::toString).collect(Collectors.joining(",")));
        System.out.println(collatz(BigInteger.valueOf(13)).count());
    }

    public static void main(String[] args) {
//        sample();

        long maxSeed = 0;
        long maxCount = 0;

        for(long seed = 1; seed < 1000000; seed++) {
            long localCount = collatz(BigInteger.valueOf(seed)).count();
            if(localCount > maxCount) {
                maxSeed = seed;
                maxCount = localCount;
            }
        }

        System.out.println(String.format("seed: %d   - count: %d", maxSeed, maxCount));
    }
}
