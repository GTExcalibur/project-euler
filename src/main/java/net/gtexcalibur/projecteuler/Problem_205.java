package net.gtexcalibur.projecteuler;

/**
 * Created by George Turner on 10/21/2017.
 * <br> Problem 205 - Dice Game
 * <pre>
 *

 Peter has nine four-sided (pyramidal) dice, each with faces numbered 1, 2, 3, 4.
 Colin has six six-sided (cubic) dice, each with faces numbered 1, 2, 3, 4, 5, 6.

 Peter and Colin roll their dice and compare totals: the highest total wins. The result is a draw if the totals are equal.

 What is the probability that Pyramidal Pete beats Cubic Colin? Give your answer rounded to seven decimal places in the form 0.abcdefg

 * </pre>
 */
public class Problem_205 {

    private static void bruteForce() {
        long totalCount = 0;
        long winCount = 0;

        for (int p1 = 1; p1 <= 4; p1++) {
            for (int p2 = 1; p2 <= 4; p2++) {
                for (int p3 = 1; p3 <= 4; p3++) {
                    for (int p4 = 1; p4 <= 4; p4++) {
                        for (int p5 = 1; p5 <= 4; p5++) {
                            for (int p6 = 1; p6 <= 4; p6++) {
                                for (int p7 = 1; p7 <= 4; p7++) {
                                    for (int p8 = 1; p8 <= 4; p8++) {
                                        for (int p9 = 1; p9 <= 4; p9++) {

                                            for (int c1 = 1; c1 <= 6; c1++) {
                                                for (int c2 = 1; c2 <= 6; c2++) {
                                                    for (int c3 = 1; c3 <= 6; c3++) {
                                                        for (int c4 = 1; c4 <= 6; c4++) {
                                                            for (int c5 = 1; c5 <= 6; c5++) {
                                                                for (int c6 = 1; c6 <= 6; c6++) {
                                                                    totalCount++;

                                                                    int peter = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
                                                                    int colin = c1 + c2 + c3 + c4 + c5 + c6;

                                                                    if(peter > colin) {
                                                                        winCount++;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println((double) winCount / totalCount);
    }


    public static void main(String[] args) {
        bruteForce();
    }
}
