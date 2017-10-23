package net.gtexcalibur.projecteuler;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 10:04 PM
 * <br> Problem 40 - Champernowne's constant
 * <pre>
 *

 An irrational decimal fraction is created by concatenating the positive integers:

 0.123456789101112131415161718192021...

 It can be seen that the 12th digit of the fractional part is 1.

 If dn represents the nth digit of the fractional part, find the value of the following expression.

 d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

 * </pre>
 *
 * @author George Turner
 */
public class Problem_040 {

    public static void main(String[] args) {
        Integer[] d = IntStream.range(1, 1000000).boxed()
                               .flatMap(i -> Integer.toString(i).chars().map(Character::getNumericValue).boxed())
                               .toArray(Integer[]::new);

        System.out.println("d1: " + d[1-1]);
        System.out.println("d10: " + d[10-1]);
        System.out.println("d100: " + d[100-1]);
        System.out.println("d1000: " + d[1000-1]);
        System.out.println("d10000: " + d[10000-1]);
        System.out.println("d100000: " + d[100000-1]);
        System.out.println("d1000000: " + d[1000000-1]);

        System.out.println("array: ");
        Arrays.stream(d).limit(100).forEach(System.out::print);
        System.out.println("");

        System.out.println("product: " +
                d[1-1] *
                d[10-1] *
                d[100-1] *
                d[1000-1] *
                d[10000-1] *
                d[100000-1] *
                d[1000000-1]
        );
    }




}
