package net.gtexcalibur.projecteuler;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 6:58 PM
 * <br> Number spiral diagonals
 * <pre>
 *

 Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

 21 22 23 24 25
 20  7  8  9 10
 19  6  1  2 11
 18  5  4  3 12
 17 16 15 14 13

 It can be verified that the sum of the numbers on the diagonals is 101.

 What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_028 {

    private static final class GridMover {

        private int count = 1;
        private int x, y;

        public GridMover(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void up() {
            y--;
        }

        public void down() {
            y++;
        }

        public void left() {
            x--;
        }

        public void right() {
            x++;
        }

        public void assign(int[][] location) {
            location[y][x] = count++;
        }
    }

    private static void sample() {
        int size = 5;
        final int[][] data = new int[size][size];

        final int center = size / 2;
        GridMover gridMover = new GridMover(center, center);
        gridMover.assign(data);

        for(int loop = 0; loop < center; loop++) {
            gridMover.right();
            gridMover.assign(data);
            // move all the down that we need to go
            for(int down = 0; down < loop * 2 + 1; down++) {
                gridMover.down();
                gridMover.assign(data);
            }

            // move all the left that we need to go
            for(int left = 0; left < loop * 2 + 2; left++) {
                gridMover.left();
                gridMover.assign(data);
            }

            // move all the up that we need to go
            for(int up = 0; up < loop * 2 + 2; up++) {
                gridMover.up();
                gridMover.assign(data);
            }

            // move all the right that we need to go
            for(int right = 0; right < loop * 2 + 2; right++) {
                gridMover.right();
                gridMover.assign(data);
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(String.format("%1$2s ", data[i][j]));
            }
            System.out.println();
        }

        long sum = IntStream.range(0, size).map(v -> data[v][v] + data[size-v-1][v]).sum() - 1;
        System.out.println("sum: " + sum);
    }

    public static void main(String[] args) {
//        sample();

        int size = 1001;
        final int[][] data = new int[size][size];

        final int center = size / 2;
        GridMover gridMover = new GridMover(center, center);
        gridMover.assign(data);

        for(int loop = 0; loop < center; loop++) {
            gridMover.right();
            gridMover.assign(data);
            // move all the down that we need to go
            for(int down = 0; down < loop * 2 + 1; down++) {
                gridMover.down();
                gridMover.assign(data);
            }

            // move all the left that we need to go
            for(int left = 0; left < loop * 2 + 2; left++) {
                gridMover.left();
                gridMover.assign(data);
            }

            // move all the up that we need to go
            for(int up = 0; up < loop * 2 + 2; up++) {
                gridMover.up();
                gridMover.assign(data);
            }

            // move all the right that we need to go
            for(int right = 0; right < loop * 2 + 2; right++) {
                gridMover.right();
                gridMover.assign(data);
            }
        }

        long sum = IntStream.range(0, size).map(v -> data[v][v] + data[size-v-1][v]).sum() - 1;
        System.out.println("sum: " + sum);
    }
}
