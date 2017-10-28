package net.gtexcalibur.projecteuler;

import java.io.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/27/2017, Time: 10:43 PM
 * <br> Problem 99 - Largest exponential
 * <pre>
 *

 Comparing two numbers written in index form like 211 and 37 is not difficult, as any calculator would confirm that 211 = 2048 < 37 = 2187.

 However, confirming that 632382518061 > 519432525806 would be much more difficult, as both numbers contain over three million digits.

 Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text file containing one thousand lines with a base/exponent pair on each line, determine which line number has the greatest numerical value.

 NOTE: The first two lines in the file represent the numbers in the example given above.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_099 {

    private static final Pattern COMMA = Pattern.compile(",");

    private static final List<String[]> DATA;
    static {
        try (InputStream is = Problem_099.class.getResourceAsStream("/p099_base_exp.txt")) {
            DATA = new BufferedReader(new InputStreamReader(is)).lines().map(COMMA::split).collect(Collectors.toList());

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {
        int maxIndex = 0;
        BigInteger maxValue = BigInteger.ZERO;

        for(int index = 0; index < DATA.size(); index++) {
            BigInteger newNumber = new BigInteger(DATA.get(index)[0]).pow(Integer.parseInt(DATA.get(index)[1]));

            if(newNumber.compareTo(maxValue) > 0) {
                maxIndex = index;
                maxValue = newNumber;
            }
        }

        System.out.println("answer: " + maxIndex);
    }
}
