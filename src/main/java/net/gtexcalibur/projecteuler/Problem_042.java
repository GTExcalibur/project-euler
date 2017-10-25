package net.gtexcalibur.projecteuler;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 7:54 PM
 * <br> Problem 42 - Coded triangle numbers
 * <pre>
 *

 The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

 By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

 Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_042 {

    private static final Pattern COMMA = Pattern.compile(",");

    private static final List<String> DATA;
    static {
        try (InputStream is = Problem_022.class.getResourceAsStream("/words.txt")) {
            DATA = COMMA.splitAsStream(new Scanner(is).useDelimiter("\\A").next())
                        .map(s -> s.replace("\"", ""))
                        .collect(Collectors.toList());

            System.out.println("Longest: " + DATA.stream().mapToInt(String::length).max());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /*private static final Set<Long> ALL_TRIANGLE_NUM;
    static {
        ALL_TRIANGLE_NUM = LongStream.range(0, (long) Math.pow(26, 14 + 1))
                                     .map(n -> n * (n + 1) / 2)
                                     .boxed()
                                     .collect(Collectors.toSet());
    }*/

    static boolean isTriangleNumber(long number) {
        // reversing tn = ½n(n+1) ... (sqrt(8*tn+1) - 1)/2

        long trial = (long) Math.sqrt(number);
        long start = (long) ((Math.sqrt(8 * number + 1) - 1) / 2) - 1;

        // in order to remove rounding errors, try numbers that are around the 'estimate'
        return LongStream.rangeClosed(start, start + trial)
                         .filter(local -> local * (local + 1) / 2 == number )
                         .findFirst()
                         .isPresent();
    }

    public static void main(String[] args) {
        long totalCount = DATA.stream()
                              .map(word -> word.chars().mapToLong(c -> c - 'A' + 1).sum())
                              .filter(Problem_042::isTriangleNumber)
                              .count();
        System.out.println("totalCount: " + totalCount);
    }
}
