package net.gtexcalibur.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 11:29 AM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class CombinationUtils {

    public static <E> Stream<List<E>> combinations(List<E> input, int size) {
        if (size == 0) {
            return Stream.of(Collections.emptyList());
        } else {
            return IntStream.range(0, input.size()).boxed().
                    flatMap(i -> combinations(input.subList(i + 1, input.size()), size - 1).map(t -> pipe(input.get(i), t)));
        }
    }

    private static <E> List<E> pipe(E head, List<E> tail) {
        List<E> newList = new ArrayList<>(tail);
        newList.add(0, head);
        return newList;
    }
}
