package net.gtexcalibur.projecteuler;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 7:48 PM
 * <br> Problem 39 - Integer right triangles
 * <pre>
 *

 If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

 {20,48,52}, {24,45,51}, {30,40,50}

 For which value of p ? 1000, is the number of solutions maximised?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_039 {

    public static void main(String[] args) {
        int[] triangles = new int[1001];

        for(int a = 1; a < 1000; a++) {
            for(int b = a + 1; b < 1000; b++) {
                for(int c = b + 1; c < 1000; c++) {
                    int total = a + b + c;
                    if(1000 < total) {
                        continue;
                    }
                    if(a * a + b * b != c * c) {
                        continue;
                    }
                    triangles[total]++;
                }
            }
        }

        int best = 0;
        int bestIndex = 0;
        for(int index = 0; index < 1001; index++) {
            if(triangles[index] > best) {
                best = triangles[index];
                bestIndex = index;
            }
        }
        System.out.println("bestIndex: " + bestIndex);
    }
}
