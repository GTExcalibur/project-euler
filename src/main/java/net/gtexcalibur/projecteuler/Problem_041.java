package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 10:23 PM
 * <br> Problem 41 - Pandigital prime
 * <pre>
 *

 We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

 What is the largest n-digit pandigital prime that exists?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_041 {

    /*static boolean isPandigital(String element) {
        if(element.length() != 9) {
            return false;
        }

        long[] bitSwitch = { 0 };

        element.chars().map(Character::getNumericValue).forEach(i -> bitSwitch[0] = bitSwitch[0] | 1<<i);
        return bitSwitch[0] == 1022; // 1024 - 2;
    }*/

    public static <E> Stream<List<E>> combinations(List<E> input, int size) {
        if (size == 0) {
            return Stream.of(Collections.emptyList());
        } else {
            return IntStream.range(0, input.size()).boxed().
                    flatMap(i -> {
                        E value = input.get(i);
                        return combinations(input.stream().filter(v -> v != value).collect(Collectors
                                .toList()), size - 1).map(t -> pipe(value, t));
                    });
        }
    }

    private static <E> List<E> pipe(E head, List<E> tail) {
        List<E> newList = new ArrayList<>(tail);
        newList.add(0, head);
        return newList;
    }

    public static void main(String[] args) {
        int answer =
                Stream.of(
                        combinations(Arrays.asList("9", "8", "7", "6", "5", "4", "3", "2", "1"), 9),
                        combinations(Arrays.asList("8", "7", "6", "5", "4", "3", "2", "1"), 8),
                        combinations(Arrays.asList("7", "6", "5", "4", "3", "2", "1"), 7),
                        combinations(Arrays.asList("6", "5", "4", "3", "2", "1"), 6),
                        combinations(Arrays.asList("5", "4", "3", "2", "1"), 5),
                        combinations(Arrays.asList("4", "3", "2", "1"), 4),
                        combinations(Arrays.asList("3", "2", "1"), 3),
                        combinations(Arrays.asList("2", "1"), 2),
                        combinations(Arrays.asList("1"), 1)
                ).flatMap(Function.identity())

                      .map(tuple -> Integer.parseInt(tuple.stream().collect(Collectors.joining())))
                      .peek(System.out::println)
                      .filter(v -> BigInteger.valueOf(v).isProbablePrime(20))
//                      .filter(pn -> isPandigital(Integer.toString(pn)))
                      .findFirst()
                      .orElseThrow(IllegalStateException::new);

        System.out.println("answer: " + answer);
    }
}
