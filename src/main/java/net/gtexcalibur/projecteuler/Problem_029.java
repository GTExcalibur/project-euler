package net.gtexcalibur.projecteuler;

import net.gtexcalibur.util.EnumerationUtils;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 7:45 PM
 * <br> Problem 29 - Distinct powers
 * <pre>
 *

 Consider all integer combinations of ab for 2 ? a ? 5 and 2 ? b ? 5:

 22=4, 23=8, 24=16, 25=32
 32=9, 33=27, 34=81, 35=243
 42=16, 43=64, 44=256, 45=1024
 52=25, 53=125, 54=625, 55=3125

 If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

 How many distinct terms are in the sequence generated by ab for 2 ? a ? 100 and 2 ? b ? 100?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_029 {

    private static void sample() {
        long count = EnumerationUtils.enumerations( IntStream.rangeClosed(2, 5).boxed().collect(Collectors.toList()), 2 )
                                     .map(pair -> BigInteger.valueOf(pair.get(0)).pow(pair.get(1)))
                                     .sorted().distinct().count();

        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
//        sample();

        long count = EnumerationUtils.enumerations( IntStream.rangeClosed(2, 100).boxed().collect(Collectors.toList()), 2 )
                                     .map(pair -> BigInteger.valueOf(pair.get(0)).pow(pair.get(1)))
                                     .sorted().distinct().count();

        System.out.println("count: " + count);
    }
}