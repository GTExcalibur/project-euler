package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by George Turner on 10/21/2017.
 * <br> Problem 254 - Sums of Digit Factorials
 * <pre>
 *

 Define f(n) as the sum of the factorials of the digits of n. For example, f(342) = 3! + 4! + 2! = 32.

 Define sf(n) as the sum of the digits of f(n). So sf(342) = 3 + 2 = 5.

 Define g(i) to be the smallest positive integer n such that sf(n) = i. Though sf(342) is 5, sf(25) is also 5, and it can be verified that g(5) is 25.

 Define sg(i) as the sum of the digits of g(i). So sg(5) = 2 + 5 = 7.

 Further, it can be verified that g(20) is 267 and ??sg(i) for 1 ? i ? 20 is 156.

 What is ??sg(i) for 1 ? i ? 150?

 * </pre>
 */
public class Problem_254 {

    private static final Map<BigInteger, BigInteger> function_sfCache = new HashMap<>();

    private static final int[] simpleFactorial = new int[10];
    static {
        simpleFactorial[0] = 1;
        simpleFactorial[1] = 1;
        simpleFactorial[2] = 2 * simpleFactorial[1];
        simpleFactorial[3] = 3 * simpleFactorial[2];
        simpleFactorial[4] = 4 * simpleFactorial[3];
        simpleFactorial[5] = 5 * simpleFactorial[4];
        simpleFactorial[6] = 6 * simpleFactorial[5];
        simpleFactorial[7] = 7 * simpleFactorial[6];
        simpleFactorial[8] = 8 * simpleFactorial[7];
        simpleFactorial[9] = 9 * simpleFactorial[8];
    }

    static BigInteger function_f(BigInteger n) {
        return BigInteger.valueOf( n.toString().chars().map(Character::getNumericValue).map(v -> simpleFactorial[v]).sum() );
    }

    static BigInteger function_sf(BigInteger n) {
        return BigInteger.valueOf( function_f(n).toString().chars().map(Character::getNumericValue).sum() );
    }

    static Map<BigInteger, BigInteger> tempMap;

    static BigInteger function_g(BigInteger n) {
        // here's the brute force ... WAY TOO SLOW!
        /*return Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                     .filter(local -> function_sfCache.computeIfAbsent(local, Problem_254::function_sf).equals(n))
                     .findFirst()
                     .orElseThrow(IllegalStateException::new);*/

        /*return enumerationsLimited(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 25)
                .map(local -> new BigInteger(local.stream().collect(Collectors.joining())))
                .skip(1)
                .filter(local -> function_sfCache.computeIfAbsent(local, Problem_254::function_sf).equals(n))
                .findFirst()
                .orElseThrow(IllegalStateException::new);*/


        if(tempMap == null) {
            tempMap = new ConcurrentHashMap<>();

            // prepopulate the map once ... and even this is too SLOW!
            /*enumerationsLimited(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 15)
                    .skip(1)
                    .map(local -> new BigInteger(local.stream().collect(Collectors.joining())))
                    .forEach(local -> tempMap.putIfAbsent(function_sf(local), local));*/

            ExecutorService executorService = Executors.newFixedThreadPool(25);
            AtomicLong peek = new AtomicLong(0);

            StreamSupport.stream(new RestrictedEnumerationsSpliterator(300), false)
                    .skip(1)
//                    .map(BigInteger::new);
//                    .forEach(local -> tempMap.putIfAbsent(function_sf(local), local));
                    .peek(local -> {
                        if(peek.incrementAndGet() % 100000 == 0) {
                            System.out.println("mapSize: " + tempMap.size() + "   - local: " + new BigInteger(local));
                        }
                    })
                    .peek(local -> {
                        executorService.submit(() -> {
                            BigInteger value = new BigInteger(local);
                            BigInteger keyValue = function_sf(value);

                            tempMap.compute(keyValue, (oldKey, oldValue) -> {
                                if(oldValue == null || oldValue.compareTo(value) > 0) {
                                    return value;
                                } else {
                                    return oldValue;
                                }
                            });
                        });
                    })
                    .filter(ignore -> tempMap.size() > 150)
                    .findFirst();

            try {
                executorService.shutdown();
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(tempMap);
        }
        return tempMap.get(n);
    }

    static BigInteger function_sg(BigInteger n) {
        return BigInteger.valueOf( function_g(n).toString().chars().map(Character::getNumericValue).sum() );
    }

    private static void sample() {
        BigInteger answer = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                .limit(20)
                .map(Problem_254::function_sg)
                .reduce(BigInteger.ZERO, BigInteger::add);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        sample();

        BigInteger answer = Stream.iterate(BigInteger.ONE, BigInteger.ONE::add)
                .limit(150)
                .map(Problem_254::function_sg)
                .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println(answer);
    }
}

class RestrictedEnumerationsSpliterator extends MultipleElementSpliterator<String> {

    private final List<String> seed = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private final int length;

    public RestrictedEnumerationsSpliterator(int length) {
        super(Long.MAX_VALUE, Spliterator.NONNULL);
        this.length = length;
    }

    @Override
    protected boolean tryAdvanceMultiple(Consumer<? super String> action) {
        recursiveConsumer("", seed, length, action);
        return false;
    }

    private void recursiveConsumer(String head, List<String> allowed, int length, Consumer<? super String> action) {
        if(length > 0) {
            for (String element : allowed) {
                final List<String> newAllowed = allowed.stream().filter(m -> element.compareTo(m) <= 0).collect(Collectors.toList());
                recursiveConsumer(head + element, newAllowed, length - 1, action);
            }
        } else {
            action.accept(head);
        }
    }

}
