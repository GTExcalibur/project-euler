package net.gtexcalibur.projecteuler;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 11:26 PM
 * <br> Problem 9 - Special Pythagorean triplet
 * <pre>
 *

 A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 a2 + b2 = c2

 For example, 32 + 42 = 9 + 16 = 25 = 52.

 There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 Find the product abc.

 * </pre>
 * @author George Turner
 */
public class Problem_009 {

    public static void main(String[] args) {
        for(int a = 1; a < 1000; a++) {
            for(int b = a + 1; b < 1000; b++) {
                for(int c = b + 1; c < 1000; c++) {
                    if(1000 != a + b + c) {
                        continue;
                    }
                    if(a * a + b * b != c * c) {
                        continue;
                    }
                    System.out.println(String.format("a: %d   b: %d   c: %d    product: %d", a, b, c, a * b * c));
                }
            }
        }
    }
}
