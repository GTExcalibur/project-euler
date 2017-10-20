package net.gtexcalibur.projecteuler;

import java.math.BigInteger;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 15 - Lattice paths
 * <pre>
 *

 Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

 How many such routes are there through a 20×20 grid?

 * </pre>
 */
public class Problem_015 {

    private static interface Navigatable {
        BigInteger navigate();
    }

    private static final class GridElement implements Navigatable {
        private final Navigatable right;
        private final Navigatable down;
        private transient BigInteger sum;

        public GridElement(Navigatable right, Navigatable down) {
            this.right = right;
            this.down = down;
        }

        @Override
        public BigInteger navigate() {
            if(sum == null) {
                sum = BigInteger.ZERO;

                if(right != null) {
                    sum = sum.add(right.navigate());
                }
                if(down != null) {
                    sum = sum.add(down.navigate());
                }
            }

            return sum;
        }
    }

    private static Navigatable createSquareGrid(final int size) {
        Navigatable[][] grid = new Navigatable[size][size];
        grid[size-1][size-1] = new GridElement(() -> BigInteger.ZERO, () -> BigInteger.ZERO);
        grid[size-1][size-2] = new GridElement(() -> BigInteger.ZERO, () -> BigInteger.ONE);
        grid[size-2][size-1] = new GridElement(() -> BigInteger.ONE, () -> BigInteger.ZERO);

        for(int i = size - 1; i >= 0; i--) {
            for(int j = size - 1; j >= 0; j--) {
                // all but the 1st
                if(grid[i][j] == null) {
                    Navigatable right = (i+1 >= size) ? null : grid[i+1][j];
                    Navigatable down = (j+1 >= size) ? null : grid[i][j+1];

                    grid[i][j] = new GridElement(right, down);
                }
            }
        }

        return grid[0][0];
    }

    private static void sample() {
        System.out.println(createSquareGrid(2+1).navigate());
    }

    public static void main(String[] args) {
        sample();

        System.out.println(createSquareGrid(20+1).navigate());
    }
}
