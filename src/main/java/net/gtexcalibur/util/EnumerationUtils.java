package net.gtexcalibur.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 11:42 AM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class EnumerationUtils {

    public static <E> Stream<List<E>> enumerations(List<E> input, int size) {
        if (size == 0) {
            return Stream.of(Collections.emptyList());
        } else {
            return IntStream.range(0, input.size()).boxed().
                    flatMap(i -> enumerations(input, size - 1).map(t -> pipe(input.get(i), t)));
        }
    }

    private static <E> List<E> pipe(E head, List<E> tail) {
        List<E> newList = new ArrayList<>(tail);
        newList.add(0, head);
        return newList;
    }
}
