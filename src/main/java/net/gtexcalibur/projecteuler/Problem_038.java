package net.gtexcalibur.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 7:24 PM
 * <br> Problem 38 - Pandigital multiples
 * <pre>
 *

 Take the number 192 and multiply it by each of 1, 2, and 3:

 192 × 1 = 192
 192 × 2 = 384
 192 × 3 = 576

 By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

 The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

 What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_038 {

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

    static boolean canCreateConcatenatedProduct(List<String> numbers) {
        String composite = numbers.stream().collect(Collectors.joining());

        for(int sub = 1; sub <= numbers.size(); sub++) {
            int seed = Integer.parseInt(composite.substring(0, sub));

            int t1 = seed;
            int t2 = seed * 2;
            int t3 = seed * 3;
            int t4 = seed * 4;
            int t5 = seed * 5;
            int t6 = seed * 6;
            int t7 = seed * 7;
            int t8 = seed * 8;
            int t9 = seed * 9;

            if(("" + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2 + t3 + t4 + t5 + t6 + t7).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2 + t3 + t4 + t5 + t6).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2 + t3 + t4 + t5).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2 + t3 + t4).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2 + t3).equals(composite)) {
                return true;
            }
            if(("" + t1 + t2).equals(composite)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String answer = combinations(Arrays.asList("9", "8", "7", "6", "5", "4", "3", "2", "1"), 9)
                .filter(Problem_038::canCreateConcatenatedProduct)
                .map(numbers -> numbers.stream().collect(Collectors.joining()))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        System.out.println("answer: " + answer);
    }
}
