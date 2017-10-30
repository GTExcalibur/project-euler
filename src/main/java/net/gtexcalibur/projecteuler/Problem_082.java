package net.gtexcalibur.projecteuler;

import java.io.*;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/29/2017, Time: 8:29 PM
 * <br> Problem 82 - Path sum: three ways
 * <pre>
 *    NOTE: This problem is a more challenging version of Problem 81.

 The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left column and finishing in any cell in the right column, and only moving up, down, and right, is indicated in red and bold; the sum is equal to 994.
 ????????131201630537805673968036997322343427464975241039654221213718150111956331????????

 Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."), a 31K text file containing a 80 by 80 matrix, from the left column to the right column.
 * </pre>
 *
 * @author George Turner
 */
public class Problem_082 {

    private static class RectangleNode {
        final long value;
        private final Supplier<RectangleNode> up, down, right;

        private transient Long minSum;

        public RectangleNode(long value, Supplier<RectangleNode> up, Supplier<RectangleNode> down, Supplier<RectangleNode> right) {
            this.value = value;
            this.up = up;
            this.down = down;
            this.right = right;
        }

        public long findMinSum() {
            if(minSum == null) {
                minSum = (long) Integer.MAX_VALUE;
                if(right != null) {
                    long rightSum = value + right.get().findMinSum();
                    if(rightSum < minSum) {
                        minSum = rightSum;
                    }
                }
                if(up != null) {
                    long upSum = value + up.get().findMinSum();
                    if(upSum < minSum) {
                        minSum = upSum;
                    }
                }
                if(down != null) {
                    long downSum = value + down.get().findMinSum();
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
            super(value, null, null, null);
        }

        @Override
        public long findMinSum() {
            return value;
        }
    }

    private static final Pattern COMMA = Pattern.compile(",");

    private static final long[][] DATA;
    static {
        try (InputStream inputStream = Problem_081.class.getResourceAsStream("/p082_matrix.txt")) {
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
        path[0][4] = new SolutionNode(SAMPLE_DATA[0][4]);
        path[1][4] = new SolutionNode(SAMPLE_DATA[1][4]);
        path[2][4] = new SolutionNode(SAMPLE_DATA[2][4]);
        path[3][4] = new SolutionNode(SAMPLE_DATA[3][4]);
        path[4][4] = new SolutionNode(SAMPLE_DATA[4][4]);

        for(int i = 4; i >= 0; i--) {
            for(int j = 4; j >= 0; j--) {
                Supplier<RectangleNode> up = getEdgeCase(4, i-1, j, path);
                Supplier<RectangleNode> down = getEdgeCase(4, i+1, j, path);
                Supplier<RectangleNode> right = getEdgeCase(4, i, j+1, path);

                if(path[i][j] == null) {
                    path[i][j] = new RectangleNode(SAMPLE_DATA[i][j], up, down, right);
                }
            }
        }

        long answer = IntStream.range(0, 5)
                               .mapToLong(a -> path[a][0].findMinSum())
                               .min()
                               .orElse(Integer.MAX_VALUE);

        System.out.println("answer: " + answer);
    }

    private static Supplier<RectangleNode> getEdgeCase(int size, int di, int dj, RectangleNode[][] nodes) {
        if(di > size || dj > size || di < 0 || dj < 0) {
            return () -> new RectangleNode(Integer.MAX_VALUE, null, null, null);
        } else {
            return () -> nodes[di][dj];
        }
    }

    public static void main(String[] args) {
//        sample();

        int totalSize = DATA.length;
        RectangleNode[][] path = new RectangleNode[totalSize][totalSize];
        IntStream.range(0, totalSize)
                 .forEach(a -> path[a][totalSize-1] = new SolutionNode(DATA[a][totalSize-1]));

        for(int i = totalSize - 1; i >= 0; i--) {
            for(int j = totalSize - 1; j >= 0; j--) {
                Supplier<RectangleNode> up = getEdgeCase(totalSize - 1, i-1, j, path);
                Supplier<RectangleNode> down = getEdgeCase(totalSize - 1, i+1, j, path);
                Supplier<RectangleNode> right = getEdgeCase(totalSize - 1, i, j+1, path);

                if(path[i][j] == null) {
                    path[i][j] = new RectangleNode(DATA[i][j], up, down, right);
                }
            }
        }

        long answer = IntStream.range(0, totalSize)
                               .mapToLong(a -> path[a][0].findMinSum())
                               .min()
                               .orElse(Integer.MAX_VALUE);

        System.out.println("answer: " + answer);
    }
}
