package net.gtexcalibur.projecteuler;

import java.io.*;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/29/2017, Time: 7:43 PM
 * <br> Problem 81 - Path sum: two ways
 * <pre>
 *       In the 5 by 5 matrix below, the minimal path sum from the top right to the bottom down, by only moving to the down and down, is indicated in bold red and is equal to 2427.
 ????????131201630537805673968036997322343427464975241039654221213718150111956331????????

 Find the minimal path sum, in matrix.txt (down click and "Save Link/Target As..."), a 31K text file containing a 80 by 80 matrix, from the top right to the bottom down by only moving down and down.
 * </pre>
 *
 * @author George Turner
 */
public class Problem_081 {

    private static class RectangleNode {
        final long value;
        private final RectangleNode down, right;

        private transient Long minSum;

        public RectangleNode(long value, RectangleNode down, RectangleNode right) {
            this.value = value;
            this.down = down;
            this.right = right;
        }

        public long findMinSum() {
            if(minSum == null) {
                minSum = (long) Integer.MAX_VALUE;
                if(right != null) {
                    long rightSum = value + right.findMinSum();
                    if(rightSum < minSum) {
                        minSum = rightSum;
                    }
                }
                if(down != null) {
                    long downSum = value + down.findMinSum();
                    if(downSum < minSum) {
                        minSum = downSum;
                    }
                }
            }
            return minSum;
        }
    }

    private static final class SolutionNode extends RectangleNode {
        public SolutionNode(long value) {
            super(value, null, null);
        }

        @Override
        public long findMinSum() {
            return value;
        }
    }

    private static final Pattern COMMA = Pattern.compile(",");

    private static final long[][] DATA;
    static {
        try (InputStream inputStream = Problem_081.class.getResourceAsStream("/p081_matrix.txt")) {
            DATA = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .map(line -> COMMA.splitAsStream(line).mapToLong(Long::parseLong).toArray())
                    .toArray(long[][]::new);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void sample() {

        long[][] SAMPLE_DATA = {
                { 131, 673, 234, 103,  18 },
                { 201,  96, 342, 965, 150 },
                { 630, 803, 746, 422, 111 },
                { 537, 699, 497, 121, 956 },
                { 805, 732, 524,  37, 331 }
        };

        RectangleNode[][] path = new RectangleNode[5][5];
        path[4][4] = new SolutionNode(SAMPLE_DATA[4][4]);

        for(int i = 4; i >= 0; i--) {
            for(int j = 4; j >= 0; j--) {
                RectangleNode right = getEdgeCase(4, i+1, j, path);
                RectangleNode down = getEdgeCase(4, i, j+1, path);

                if(path[i][j] == null) {
                    path[i][j] = new RectangleNode(SAMPLE_DATA[i][j], right, down);
                }
            }
        }

        System.out.println("answer: " + path[0][0].findMinSum());
    }

    private static RectangleNode getEdgeCase(int size, int di, int dj, RectangleNode[][] nodes) {
        if(di > size || dj > size) {
            return new RectangleNode(Integer.MAX_VALUE, null, null);
        } else {
            return nodes[di][dj];
        }
    }

    public static void main(String[] args) {
//        sample();

        int totalSize = DATA.length;
        RectangleNode[][] path = new RectangleNode[totalSize][totalSize];
        path[totalSize-1][totalSize-1] = new SolutionNode(DATA[totalSize-1][totalSize-1]);

        for(int i = totalSize - 1; i >= 0; i--) {
            for(int j = totalSize - 1; j >= 0; j--) {
                RectangleNode right = getEdgeCase(totalSize - 1, i+1, j, path);
                RectangleNode down = getEdgeCase(totalSize - 1, i, j+1, path);

                if(path[i][j] == null) {
                    path[i][j] = new RectangleNode(DATA[i][j], right, down);
                }
            }
        }

        System.out.println("answer: " + path[0][0].findMinSum());
    }
}
