package net.gtexcalibur.projecteuler;

import net.gtexcalibur.util.PermutationUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 24 - Lexicographic permutations
 * <pre>
 *

 A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

 012   021   102   120   201   210

 What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

 * </pre>
 */
public class Problem_024 {

    private static void sample() {
        List<String> input = Arrays.asList("0", "1", "2");

        PermutationUtils.streamOfPermutations(input)
                        .map(it -> it.stream().collect(Collectors.joining()))
                        .sorted()
                        .forEach(System.out::println);
    }

    public static void main(String[] args) {
        sample();

        List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        String answer = PermutationUtils.streamOfPermutations(input)
                                        .map(it -> it.stream().collect(Collectors.joining()))
                                        .sorted()
                                        .limit(1000000)
                                        .skip(999999)
                                        .findFirst()
                                        .orElse("N/A");

        System.out.println("answer: " + answer);
    }
}
