package net.gtexcalibur.projecteuler;

import net.gtexcalibur.util.EnumerationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 8:55 PM
 * <br> Problem 33 - Digit cancelling fractions
 * <pre>
 *

 The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

 We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

 There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

 If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

 * </pre>
 *
 * @author George Turner
 */
public class Problem_033 {

    static boolean isCuriousFraction(List<String> tuple) {
        return tuple.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() >= 2)
                    .anyMatch(entry -> {
                        List<String> top = new ArrayList<>(tuple.subList(0, 2));
                        List<String> bottom = new ArrayList<>(tuple.subList(2, 4));
                        top.removeIf(entry.getKey()::equals);
                        bottom.removeIf(entry.getKey()::equals);

                        if(!top.isEmpty() && !bottom.isEmpty()) {
                            double normal = Double.parseDouble(tuple.get(0) + tuple.get(1)) / Double.parseDouble(tuple.get(2) + tuple.get(3));
                            double reduced = Double.parseDouble(top.get(0)) / Double.parseDouble(bottom.get(0));

                            return normal == reduced;
                        }
                        return false;
                    });
    }

    public static void main(String[] args) {
        Tuple reduce = EnumerationUtils.enumerations(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), 4)
                                        .filter(tuple -> Double.parseDouble(tuple.get(0) + tuple.get(1)) / Double
                                                .parseDouble(tuple.get(2) + tuple.get(3)) < 1)
                                        .filter(Problem_033::isCuriousFraction)
                                        .peek(tuple -> System.out
                                                .println("" + tuple.get(0) + tuple.get(1) + " / " + tuple.get(2) + tuple
                                                        .get(3)))
                                        .map(tuple -> new Tuple(Long.parseLong(tuple.get(0) + tuple.get(1)), Long.parseLong(tuple.get(2) + tuple.get(3))))
                                        .reduce(new Tuple(1, 1), (l, r) ->
                                            new Tuple(l.getTop() * r.getTop(), l.getBottom() * r.getBottom())
                                        );
        System.out.println("reduced: " + reduce);
    }

    private static final class Tuple {
        private final long top;
        private final long bottom;

        public Tuple(long top, long bottom) {
            this.top = top;
            this.bottom = bottom;
        }

        public long getTop() {
            return top;
        }

        public long getBottom() {
            return bottom;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Tuple{");
            sb.append("top=").append(top);
            sb.append(", bottom=").append(bottom);
            sb.append('}');
            return sb.toString();
        }
    }

}
