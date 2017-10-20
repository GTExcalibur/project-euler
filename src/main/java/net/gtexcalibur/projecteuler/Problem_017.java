package net.gtexcalibur.projecteuler;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;
import java.util.stream.IntStream;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 17 - Number letter counts
 * <pre>
 *

 If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

 If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

 NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

 * </pre>
 */
public class Problem_017 {

    private static String convertLongToBritishString(long number) {
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat( new Locale("EN", "US"), RuleBasedNumberFormat.SPELLOUT );
        String format = ruleBasedNumberFormat.format(number);
        format = format.replace(" hundred ", " hundred and ");
        return format;
    }

    private static void sample() {
        long sum = IntStream.rangeClosed(1, 5)
                .mapToObj(Problem_017::convertLongToBritishString)
                .mapToLong(bs -> bs.chars().filter(Character::isAlphabetic).count())
                .sum();

        System.out.println(sum);
    }

    public static void main(String[] args) {
//        sample();

        long sum = IntStream.rangeClosed(1, 1000)
                .mapToObj(Problem_017::convertLongToBritishString)
                .peek(System.out::println)
                .mapToLong(bs -> bs.chars().filter(Character::isAlphabetic).count())
                .sum();

        System.out.println(sum);
    }
}
