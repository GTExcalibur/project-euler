package net.gtexcalibur.projecteuler;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 10:22 PM
 * <br> Problem 4
 * @author George Turner
 */
public class Problem_004 {

    static boolean isPalindromic(BigInteger bigInteger) {
        String asString = bigInteger.toString();
        int length = asString.length();
        for(int i = 0; i < length; i++) {
            if(asString.charAt(i) != asString.charAt(length-i-1)) {
                return false;
            }
        }
        return true;
    }

    private static void sample() {
        BigInteger greatest = BigInteger.ZERO;

        for(int i = 99; i > 9; i--) {
            for(int j = 99; j > 9; j--) {
                BigInteger product = BigInteger.valueOf(i * j);
                if(isPalindromic(product) && greatest.compareTo(product) < 0) {
                    greatest = product;
                }
            }
        }

        System.out.println("greatest: " + greatest);
    }

    public static void main(String[] args) {
//        sample();

        BigInteger greatest = BigInteger.ZERO;

        for(int i = 999; i > 99; i--) {
            for(int j = 999; j > 99; j--) {
                BigInteger product = BigInteger.valueOf(i * j);
                if(isPalindromic(product) && greatest.compareTo(product) < 0) {
                    greatest = product;
                }
            }
        }

        System.out.println("greatest: " + greatest);
    }
}
