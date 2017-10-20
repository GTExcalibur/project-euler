package net.gtexcalibur.projecteuler;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 10:37 PM
 * <br> Problem 5 - Smallest multiple
 * <pre>
 *

 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 * </pre>
 * @author George Turner
 */
public class Problem_005 {

    private static boolean allFactors(long test, long maxFactor) {
        for(long l = 2; l <= maxFactor; l++) {
            if(test % l != 0) {
                return false;
            }
        }
        return true;
    }


    private static void sample() {
        long guess = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;

        for(long l = guess; l > 0; l--) {
            if(allFactors(l, 10)) {
                System.out.println(l);
            }
        }
    }

    public static void main(String[] args) {
//        sample();

//        long guess = 20 * 19 * 18 * 17 * 16 * 15 * 14 * 13 * 12 * 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
//        long guess = 9223372035434597040L;
//        long guess = 1163962800L;
        long guess = 232792560L;
//        long guess = Integer.MAX_VALUE;

        for(long l = guess; l > 0; l--) {
            if(allFactors(l, 20)) {
                System.out.println(l);
            }
        }
    }



}
