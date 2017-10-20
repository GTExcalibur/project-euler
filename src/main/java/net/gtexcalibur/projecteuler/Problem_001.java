/**
 * Copyright (c) 2011 Intelligent Software Solutions
 * Unpublished-all rights reserved under the copyright laws of the United States.
 * <p>
 * This software was developed under sponsorship from the
 * Air Force Research Laboratory under FA8750-06-D-005 and FA8750-09-R-0022.
 * <p>
 * Contractor: Intelligent Software Solutions
 * 5450 Tech Center Drive, Suite 400
 * Colorado Springs, 80919
 * http://www.issinc.com
 * <p>
 * Intelligent Software Solutions has title to the rights in this computer
 * software. The Government's rights to use, modify, reproduce, release, perform,
 * display, or disclose these technical data are restricted by paragraph (b)(1) of
 * the Rights in Technical Data-Noncommercial Items clause contained in
 * Contract No. FA8750-06-D-005 and No. FA8750-09-R-0022.
 * Any reproduction of technical data or portions thereof marked with this legend
 * must also reproduce the markings.
 * <p>
 * Intelligent Software Solutions does not grant permission inconsistent with the
 * aforementioned unlimited government rights to use, disclose, copy, or make
 * derivative works of this software to parties outside the Government.
 */

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
