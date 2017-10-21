package net.gtexcalibur.util;

import net.gtexcalibur.stream.MultipleElementSpliterator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by George Turner on 10/20/2017.
 */
public final class FactorUtils {

    public static boolean isFactor(BigInteger number, BigInteger factor) {
        return number.mod(factor).equals(BigInteger.ZERO);
    }

    public static Stream<BigInteger> factors(BigInteger source) {
        Spliterator<BigInteger> smallFactors =
                new MultipleElementSpliterator<BigInteger>(Long.MAX_VALUE, Spliterator.NONNULL) {

            final List<BigInteger> largeFactors = new ArrayList<>();
            BigInteger next = BigInteger.ZERO;

            @Override
            protected boolean tryAdvanceMultiple(Consumer<? super BigInteger> action) {
                next = next.add(BigInteger.ONE);
                if (next.multiply(next).compareTo(source) >= 0) {
                    largeFactors.forEach(action);
                    return false;
                }
                if (isFactor(source, next)) {
                    largeFactors.add(0, source.divide(next));
                    action.accept(next);
                }
                return true;
            }
        };
        return StreamSupport.stream(smallFactors, false);
    }

    public static Stream<BigInteger> properDivisors(BigInteger source) {
        Spliterator<BigInteger> smallFactors =
                new MultipleElementSpliterator<BigInteger>(Long.MAX_VALUE, Spliterator.NONNULL) {

            final List<BigInteger> largeFactors = new ArrayList<>();
            BigInteger next = BigInteger.ZERO;

            @Override
            protected boolean tryAdvanceMultiple(Consumer<? super BigInteger> action) {
                next = next.add(BigInteger.ONE);
                if (next.multiply(next).compareTo(source) >= 0) {
                    if(!largeFactors.isEmpty()) {
                        largeFactors.subList(0, largeFactors.size()-1).forEach(action);
                    }
                    return false;
                }
                if (isFactor(source, next)) {
                    largeFactors.add(0, source.divide(next));
                    action.accept(next);
                }
                return true;
            }
        };
        return StreamSupport.stream(smallFactors, false);
    }
}
