package net.gtexcalibur.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 10:51 AM
 * <br> Utility class for Streaming the permutations in a given set.
 * @author George Turner
 */
public class PermutationUtils {

    private static final Map<Integer, Long> factorialCache = new HashMap<>();
    static {
        factorialCache.put(0, 1L);
        factorialCache.put(1, 1L);
        factorialCache.put(2, 2L);
    }

    public static <T> Stream<List<T>> streamOfPermutations(List<T> elements) {
        return LongStream.range(0, PermutationUtils.factorialLimited(elements.size()))
                         .mapToObj(it -> PermutationUtils.permutation(it, elements));
    }

    private static long factorialLimited(int value) {
        return factorialCache.computeIfAbsent(value, safe -> safe * factorialLimited(safe-1));
    }

    private static <T> List<T> permutation(long it, List<T> input) {
        return permutationImpl(it, new ArrayList<>(input), new ArrayList<>());
    }

    private static <T> List<T> permutationImpl(long it, List<T> in, List<T> out) {
        if(in.isEmpty()) {
            return out;
        }
        long subFactorial = factorialLimited(in.size() - 1);
        out.add(in.remove((int) (it / subFactorial)));
        return permutationImpl((int) (it % subFactorial), in, out);
    }
}
