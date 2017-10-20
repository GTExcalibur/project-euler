package net.gtexcalibur.projecteuler;

import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 9:03 PM
 * <br> Problem 1
 * @author George Turner
 */
public class Problem_001 {

    private static void sample() {
        int sum = IntStream.range(1, 10)
                           .filter(i -> (i % 3 == 0) || (i % 5 == 0))
                           .sum();

        System.out.println("sum: " + sum);
    }



    public static void main(String[] args) {
        //sample();

        int sum = IntStream.range(1, 1000)
                           .filter(i -> (i % 3 == 0) || (i % 5 == 0))
                           .sum();

        System.out.println("sum: " + sum);
    }
}
