package net.gtexcalibur.projecteuler;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 22 - Names scores
 * <pre>
 *

 Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

 What is the total of all the name scores in the file?

 * </pre>
 */
public class Problem_022 {

    private static final Pattern COMMA = Pattern.compile(",");

    private static final List<String> DATA;
    static {
        try (InputStream is = Problem_022.class.getResourceAsStream("/p022_names.txt")) {
            DATA = COMMA.splitAsStream(new Scanner(is).useDelimiter("\\A").next())
                        .map(s -> s.replace("\"", ""))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    static long getAlphabeticalValue(String name) {
        return name.chars()
                   .map(c -> c - 'A' + 1)
                   .sum() ;
    }

    public static void main(String[] args) {
        Collections.sort(DATA);

        BigInteger totalSum = IntStream.range(1, DATA.size() + 1)
                .mapToObj(index -> {
                    long alphabeticalValue = getAlphabeticalValue(DATA.get(index - 1));
                    BigInteger score = BigInteger.valueOf(index).multiply(
                            BigInteger.valueOf(alphabeticalValue)
                    );
                    System.out.println(String.format("p: %d        name: %s           score: %s", index, DATA.get(index - 1), score));
                    return score;
                })
                .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println(totalSum);
    }
}
