package net.gtexcalibur.projecteuler;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 6:22 PM
 * <br> Problem 26 - Reciprocal cycles
 * <pre>
 *

 A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

 1/2	= 	0.5
 1/3	= 	0.(3)
 1/4	= 	0.25
 1/5	= 	0.2
 1/6	= 	0.1(6)
 1/7	= 	0.(142857)
 1/8	= 	0.125
 1/9	= 	0.(1)
 1/10	= 	0.1

 Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

 Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_026 {

    private static long findLongestRepeatingSubString(String input) {
        int length = input.length();

        long[][] dp = new long[length+1][length+1];

        for(int i = 1; i <= length; i++) {
            for(int j = 1; j <= length; j++) {
                if(input.charAt(i-1) == input.charAt(j-1) && i != j) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[length-1][length-1];
    }

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(102);

        for(int d = 2; d < 10; d++) {
            BigDecimal divide = BigDecimal.ONE.divide(BigDecimal.valueOf(d), 102, BigDecimal.ROUND_HALF_UP);
            System.out.println("count: " + findLongestRepeatingSubString(numberFormat.format(divide).substring(1)) + "  divide: " + numberFormat.format(divide));
        }
    }
}
