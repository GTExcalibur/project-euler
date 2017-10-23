package net.gtexcalibur.projecteuler;

import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 9:45 PM
 * <br> Problem 36 - Double-base palindromes
 * <pre>
 *

 The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

 Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

 (Please note that the palindromic number, in either base, may not include leading zeros.)

 * </pre>
 *
 * @author George Turner
 */
public class Problem_036 {

    static boolean isPalindromic(String asString) {
        int length = asString.length();
        for(int i = 0; i < length; i++) {
            if(asString.charAt(i) != asString.charAt(length-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int sum = IntStream.range(0, 1000000)
                           .filter(num -> isPalindromic(Integer.toString(num)) && isPalindromic(Integer
                                   .toString(num, 2)))
                           .sum();
        System.out.println("sum: " + sum);
    }
}
