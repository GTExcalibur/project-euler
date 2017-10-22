package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 3:27 PM
 * <br> Problem 31 - Coin sums
 * <pre>
 *

 In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

 It is possible to make £2 in the following way:

 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

 How many different ways can £2 be made using any number of coins?

 * </pre>
 *
 * @author George Turner
 */
public class Problem_031 {

    enum Coin {
        £2(200),
        £1(100),
        p50(50),
        p20(20),
        p10(10),
        p5(5),
        p2(2),
        p1(1);

        private final int count;

        Coin(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        long ways = StreamSupport.stream(new CoinRestrictedEnumerationsSpliterator(), false)
                                 .count();
        System.out.println(ways);
    }

    private static class CoinRestrictedEnumerationsSpliterator extends MultipleElementSpliterator<List<Coin>> {

        private final List<Coin> seed = Arrays.asList(Coin.values());

        public CoinRestrictedEnumerationsSpliterator() {
            super(Long.MAX_VALUE, Spliterator.NONNULL);
        }

        @Override
        protected boolean tryAdvanceMultiple(Consumer<? super List<Coin>> action) {
            recursiveConsumer(Collections.emptyList(), seed, action);
            return false;
        }

        private void recursiveConsumer(List<Coin> head, List<Coin> allowed, Consumer<? super List<Coin>> action) {
            int sum = head.stream().mapToInt(Coin::getCount).sum();
            if(sum == 200) {
                action.accept(head);
            } else if(sum < 200) {
                for (Coin coin : allowed) {
                    final List<Coin> newAllowed = allowed.stream().filter(m -> coin.compareTo(m) <= 0).collect(Collectors.toList());
                    recursiveConsumer(Stream.concat(head.stream(), Stream.of(coin)).collect(Collectors.toList()), newAllowed, action);
                }
            }
        }

    }
}


