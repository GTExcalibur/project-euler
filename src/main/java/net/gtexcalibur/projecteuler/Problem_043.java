package net.gtexcalibur.projecteuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 8:22 PM
 * <br> Problem 43 - Sub-string divisibility
 * <pre>
 *

 The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

 Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

 d2d3d4=406 is divisible by 2
 d3d4d5=063 is divisible by 3
 d4d5d6=635 is divisible by 5
 d5d6d7=357 is divisible by 7
 d6d7d8=572 is divisible by 11
 d7d8d9=728 is divisible by 13
 d8d9d10=289 is divisible by 17

 Find the sum of all 0 to 9 pandigital numbers with this property.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_043 {

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

    static boolean isSubStringDivisible(List<String> digits) {
        if(Integer.parseInt(digits.get(1) + digits.get(2) + digits.get(3)) % 2 != 0) {
            return false;
        }
        if(Integer.parseInt(digits.get(2) + digits.get(3) + digits.get(4)) % 3 != 0) {
            return false;
        }
        if(Integer.parseInt(digits.get(3) + digits.get(4) + digits.get(5)) % 5 != 0) {
            return false;
        }
        if(Integer.parseInt(digits.get(4) + digits.get(5) + digits.get(6)) % 7 != 0) {
            return false;
        }
        if(Integer.parseInt(digits.get(5) + digits.get(6) + digits.get(7)) % 11 != 0) {
            return false;
        }
        if(Integer.parseInt(digits.get(6) + digits.get(7) + digits.get(8)) % 13 != 0) {
            return false;
        }
        if(Integer.parseInt(digits.get(7) + digits.get(8) + digits.get(9)) % 17 != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BigInteger sumOfNumbers = combinations(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 10)
                .filter(digits -> !digits.get(0).equals("0"))
                .filter(Problem_043::isSubStringDivisible)
                .map(digits -> digits.stream().collect(Collectors.joining()))
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println("sum: " + sumOfNumbers);
    }





}
