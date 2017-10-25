package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 12:33 AM
 * <br> Problem 78 - Coin partitions
 * <pre>
 *

 Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five coins can be separated into piles in exactly seven different ways, so p(5)=7.
 OOOOO
 OOOO   O
 OOO   OO
 OOO   O   O
 OO   OO   O
 OO   O   O   O
 O   O   O   O   O

 Find the least value of n for which p(n) is divisible by one million.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_078 {

    /*private static void sample() {
        *//*long count = StreamSupport.stream(new DynamicCoinRestrictedEnumerationSpliterator(5), false)
                                  .count();*//*
        long count = countMathematically(5);
        System.out.println("count: " + count);
    }*/

    private static boolean testBruteForce(int value) {
        return StreamSupport.stream(new DynamicCoinRestrictedEnumerationSpliterator(value), false)
                            .skip(999999)
                            .findFirst()
                            .isPresent();
    }

    private static boolean testCalculation(int value) {
        long count = countPartitions(value, value);
        System.out.println("value: " + value + " - " + count);
        return count % 1000000 == 0;
    }

    private static long countPartitions(long start, long max) {
        if(start <= 0) {
            return 1L;
        }

        long sum = 0;
        for(long iter = Math.min(start, max); iter > 0; iter--) {
            sum += countPartitions(start-iter, iter);
        }
        return sum;
    }

    public static void main(String[] args) {
//        sample();
        /*System.out.println(countPartitions(1, 1));
        System.out.println(countPartitions(2, 2));
        System.out.println(countPartitions(3, 3));
        System.out.println(countPartitions(4, 4));
        System.out.println(countPartitions(5, 5));*/

        OptionalInt answer = IntStream.range(1, 1000)
//                                      .skip(55)
                                      .filter(i -> testCalculation(i))
                                      .findFirst();

        System.out.println("answer: " + answer);
    }

    private static final class DynamicCoinRestrictedEnumerationSpliterator extends MultipleElementSpliterator<List<Integer>> {

        private final int size;

        public DynamicCoinRestrictedEnumerationSpliterator(int size) {
            super(Long.MAX_VALUE, Spliterator.NONNULL);
            this.size = size;
        }

        @Override
        protected boolean tryAdvanceMultiple(Consumer<? super List<Integer>> action) {
            List<Integer> seed = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());

            recursiveConsumer(Collections.emptyList(), seed, action);
            return false;
        }

        private void recursiveConsumer(List<Integer> head, List<Integer> allowed, Consumer<? super List<Integer>> action) {
            int sum = head.stream().mapToInt(i -> i).sum();
            if(sum == size) {
                action.accept(head);
            } else if(sum < size) {
                for (Integer coin : allowed) {
                    final List<Integer> newAllowed = allowed.stream().filter(m -> coin.compareTo(m) <= 0).collect(Collectors
                            .toList());
                    recursiveConsumer(Stream.concat(head.stream(), Stream.of(coin)).collect(Collectors.toList()), newAllowed, action);
                }
            }
        }
    }

    private static final class Partition {
        private final long p;
        private final long n;

        public Partition(long p, long n) {
            this.p = p;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Partition partition = (Partition) o;

            if (p != partition.p) return false;
            return n == partition.n;
        }

        @Override
        public int hashCode() {
            int result = (int) (p ^ (p >>> 32));
            result = 31 * result + (int) (n ^ (n >>> 32));
            return result;
        }
    }
}
