package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;
import net.gtexcalibur.util.CombinationUtils;
import net.gtexcalibur.util.EnumerationUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 8:14 PM
 * <br> Problem 32 - Pandigital products
 * <pre>
 *

 We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

 The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

 Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_032 {

    static boolean isPandigital(String element) {
        if(element.length() != 9) {
            return false;
        }

        long[] bitSwitch = { 0 };

        element.chars().map(Character::getNumericValue).forEach(i -> bitSwitch[0] = bitSwitch[0] | 1<<i);
        return bitSwitch[0] == 1022; // 1024 - 2;
    }

    public static <E> Stream<List<E>> combinations(List<E> input, int size) {
        if (size == 0) {
            return Stream.of(Collections.emptyList());
        } else {
            return IntStream.range(0, input.size()).boxed().
                    flatMap(i -> {
                        E value = input.get(i);
                        return combinations(input.stream().filter(v -> v != value).collect(Collectors.toList()), size - 1).map(t -> pipe(value, t));
                    });
        }
    }

    private static <E> List<E> pipe(E head, List<E> tail) {
        List<E> newList = new ArrayList<>(tail);
        newList.add(0, head);
        return newList;
    }

    public static void main(String[] args) {
        long sum = Stream.of(
                combinations(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), 3),
                combinations(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), 4),
                combinations(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), 5),
                combinations(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), 6),
                combinations(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), 7)
        )
                                .flatMap(Function.identity())
                                .mapToLong(digits -> Long.parseLong(digits.stream().collect(Collectors.joining())))
//                                .peek(System.out::println)
                                .filter(Problem_032::isMultiplicandMultiplierAndProduct_isPandigital)
                                .peek(System.out::println)
                                .sum();

        System.out.println("sum: " + sum);
    }

    static boolean isMultiplicandMultiplierAndProduct_isPandigital(long product) {
        return divisors(product).anyMatch(tuple -> isPandigital("" + tuple.getLeft() + tuple.getRight() + product));
    }

    private static Stream<Tuple> divisors(long source) {
        Spliterator<Tuple> result = new MultipleElementSpliterator<Tuple>(Long.MAX_VALUE, Spliterator.NONNULL) {
            long next = 0;

            @Override
            protected boolean tryAdvanceMultiple(Consumer<? super Tuple> action) {
                next++;
                long nextSquare = next * next;
                if(nextSquare > source) {
                    return false;
                } else if(nextSquare == source) {
                    action.accept(new Tuple(next, next));
                    return false;
                } else if(source % next == 0) {
                    action.accept(new Tuple(next, source / next));
                }
                return true;
            }
        };
        return StreamSupport.stream(result, false);
    }

    private static final class Tuple {
        private final long left;
        private final long right;

        public Tuple(long left, long right) {
            this.left = left;
            this.right = right;
        }

        public long getLeft() {
            return left;
        }

        public long getRight() {
            return right;
        }
    }
}
