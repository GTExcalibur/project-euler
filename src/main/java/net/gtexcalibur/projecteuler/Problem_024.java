package net.gtexcalibur.projecteuler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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

    private static final Map<Integer, Long> factorialCache = new HashMap<>();
    static {
        factorialCache.put(0, 1L);
        factorialCache.put(1, 1L);
        factorialCache.put(2, 2L);
    }

    private static long factorial(int value) {
        return factorialCache.computeIfAbsent(value, safe -> safe * factorial(safe-1));
    }

    private static <T> List<T> permutation(long it, List<T> input) {
        return permutationImpl(it, new ArrayList<>(input), new ArrayList<>());
    }

    private static <T> List<T> permutationImpl(long it, List<T> in, List<T> out) {
        if(in.isEmpty()) {
            return out;
        }
        long subFactorial = factorial(in.size() - 1);
        out.add(in.remove((int) (it / subFactorial)));
        return permutationImpl((int) (it % subFactorial), in, out);
    }

    private static void sample() {
        List<String> input = Arrays.asList("0", "1", "2");

        LongStream.range(0, factorial(input.size()))
                  .mapToObj(it -> permutation(it, input))
                  .map(it -> it.stream().collect(Collectors.joining()))
                  .sorted()
                  .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        sample();

        List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        String answer = LongStream.range(0, factorial(input.size()))
                .mapToObj(it -> permutation(it, input))
                .map(it -> it.stream().collect(Collectors.joining()))
                .sorted()
                .limit(1000000)
                .skip(999999)
                .findFirst()
                .orElse("N/A");

        System.out.println("answer: " + answer);
    }
}
