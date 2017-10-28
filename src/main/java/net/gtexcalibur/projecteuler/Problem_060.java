package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;
import net.gtexcalibur.util.CombinationUtils;
import net.gtexcalibur.util.EnumerationUtils;
import net.gtexcalibur.util.PermutationUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/27/2017, Time: 9:24 PM
 * <br> Problem 60 - Prime pair sets
 * <pre>
 *

 The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

 Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_060 {

    static boolean canWriteAsConcatenatedPrimes(List<BigInteger> set) {
        for(int i = 0; i < set.size(); i++) {
            for(int j = 0; j < set.size(); j++) {
                if(i == j) {
                    continue;
                }

                boolean allowed = new BigInteger(set.get(i).toString() + set.get(j).toString()).isProbablePrime(20);
                if(!allowed) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<BigInteger> primeSet = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                                          .filter(pp -> pp.isProbablePrime(20))
                                          .limit(2500)
                                          .collect(Collectors.toList());

        Function<List<BigInteger>, String> toStringFunction = i -> i.stream().map(Objects::toString)
                                                                    .collect(Collectors.joining(", ")) + "          - sum - " + i
                .stream()
                .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println("primes: " + primeSet);

        Optional<List<BigInteger>> answer = StreamSupport.stream(new ConcatenatedPrimesSpliterator(primeSet), false)
                .filter(Problem_060::canWriteAsConcatenatedPrimes)
                .peek(set -> System.out.println("possible answer: " + toStringFunction.apply(set)))
                .sorted(Comparator.comparing(set -> set.stream().reduce(BigInteger.ZERO, BigInteger::add)))
                .findFirst();

        String asString = answer
                .map(toStringFunction)
                .orElseThrow(IllegalStateException::new);
        System.out.println("answer: " + asString);
    }

    private static class ConcatenatedPrimesSpliterator extends MultipleElementSpliterator<List<BigInteger>> {

        private final List<BigInteger> seed;

        public ConcatenatedPrimesSpliterator(List<BigInteger> seed) {
            super(Long.MAX_VALUE, Spliterator.NONNULL);
            this.seed = Objects.requireNonNull(seed);
        }

        @Override
        protected boolean tryAdvanceMultiple(Consumer<? super List<BigInteger>> action) {
            recursiveConsumer(Collections.emptyList(), seed, action);
            return false;
        }

        private void recursiveConsumer(List<BigInteger> head, List<BigInteger> allowed, Consumer<? super List<BigInteger>> action) {
            if(head.size() == 5) {
                action.accept(head);
            } else {
                for (BigInteger prime : allowed) {
                    final List<BigInteger> newAllowed = allowed.stream().filter(m -> prime.compareTo(m) < 0).collect(Collectors.toList());

                    List<BigInteger> newHead = Stream.concat(head.stream(), Stream.of(prime))
                                                     .collect(Collectors.toList());
                    if(canWriteAsConcatenatedPrimes(newHead)) {
                        recursiveConsumer(newHead, newAllowed, action);
                    }
                }
            }
        }

    }
}
