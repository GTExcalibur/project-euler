package net.gtexcalibur.projecteuler;

import net.gtexcalibur.stream.MultipleElementSpliterator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 10:48 AM
 * <br> Test harnes
 * @author George Turner
 */
public class Problem_254_Test {

    @Test
    public void test_function_f() {
        Assert.assertEquals(BigInteger.valueOf(32), Problem_254.function_f(BigInteger.valueOf(342)));
    }

    @Test
    public void test_function_sf() {
        Assert.assertEquals(BigInteger.valueOf(5), Problem_254.function_sf(BigInteger.valueOf(342)));
    }

    @Test
    public void test_function_g() {
        Assert.assertEquals(BigInteger.valueOf(1), Problem_254.function_g(BigInteger.valueOf(1)));                   // sg(i) = 1
        Assert.assertEquals(BigInteger.valueOf(2), Problem_254.function_g(BigInteger.valueOf(2)));                   // sg(i) = 2
        Assert.assertEquals(BigInteger.valueOf(5), Problem_254.function_g(BigInteger.valueOf(3)));                   // sg(i) = 5
        Assert.assertEquals(BigInteger.valueOf(15), Problem_254.function_g(BigInteger.valueOf(4)));                  // sg(i) = 6
        Assert.assertEquals(BigInteger.valueOf(25), Problem_254.function_g(BigInteger.valueOf(5)));                  // sg(i) = 7
        Assert.assertEquals(BigInteger.valueOf(3), Problem_254.function_g(BigInteger.valueOf(6)));                   // sg(i) = 3
        Assert.assertEquals(BigInteger.valueOf(13), Problem_254.function_g(BigInteger.valueOf(7)));                  // sg(i) = 4
        Assert.assertEquals(BigInteger.valueOf(23), Problem_254.function_g(BigInteger.valueOf(8)));                  // sg(i) = 5
        Assert.assertEquals(BigInteger.valueOf(6), Problem_254.function_g(BigInteger.valueOf(9)));                   // sg(i) = 6
        Assert.assertEquals(BigInteger.valueOf(16), Problem_254.function_g(BigInteger.valueOf(10)));                 // sg(i) = 7
        Assert.assertEquals(BigInteger.valueOf(26), Problem_254.function_g(BigInteger.valueOf(11)));                 // sg(i) = 8
        Assert.assertEquals(BigInteger.valueOf(44), Problem_254.function_g(BigInteger.valueOf(12)));                 // sg(i) = 8
        Assert.assertEquals(BigInteger.valueOf(144), Problem_254.function_g(BigInteger.valueOf(13)));                // sg(i) = 9
        Assert.assertEquals(BigInteger.valueOf(256), Problem_254.function_g(BigInteger.valueOf(14)));                // sg(i) = 13
        Assert.assertEquals(BigInteger.valueOf(36), Problem_254.function_g(BigInteger.valueOf(15)));                 // sg(i) = 9
        Assert.assertEquals(BigInteger.valueOf(136), Problem_254.function_g(BigInteger.valueOf(16)));                // sg(i) = 10
        Assert.assertEquals(BigInteger.valueOf(236), Problem_254.function_g(BigInteger.valueOf(17)));                // sg(i) = 11
        Assert.assertEquals(BigInteger.valueOf(67), Problem_254.function_g(BigInteger.valueOf(18)));                 // sg(i) = 13
        Assert.assertEquals(BigInteger.valueOf(167), Problem_254.function_g(BigInteger.valueOf(19)));                // sg(i) = 14
        Assert.assertEquals(BigInteger.valueOf(267), Problem_254.function_g(BigInteger.valueOf(20)));                // sg(i) = 15
        Assert.assertEquals(BigInteger.valueOf(349), Problem_254.function_g(BigInteger.valueOf(21)));                // sg(i) = 16
        Assert.assertEquals(BigInteger.valueOf(1349), Problem_254.function_g(BigInteger.valueOf(22)));               // sg(i) = 17
        Assert.assertEquals(BigInteger.valueOf(2349), Problem_254.function_g(BigInteger.valueOf(23)));               // sg(i) = 18
        Assert.assertEquals(BigInteger.valueOf(49), Problem_254.function_g(BigInteger.valueOf(24)));                 // sg(i) = 13
        Assert.assertEquals(BigInteger.valueOf(149), Problem_254.function_g(BigInteger.valueOf(25)));                // sg(i) = 14
        Assert.assertEquals(BigInteger.valueOf(249), Problem_254.function_g(BigInteger.valueOf(26)));                // sg(i) = 15
        Assert.assertEquals(BigInteger.valueOf(9), Problem_254.function_g(BigInteger.valueOf(27)));                  // sg(i) = 9
        Assert.assertEquals(BigInteger.valueOf(19), Problem_254.function_g(BigInteger.valueOf(28)));                 // sg(i) = 10
        Assert.assertEquals(BigInteger.valueOf(29), Problem_254.function_g(BigInteger.valueOf(29)));                 // sg(i) = 11
        Assert.assertEquals(BigInteger.valueOf(129), Problem_254.function_g(BigInteger.valueOf(30)));                // sg(i) = 12
        Assert.assertEquals(BigInteger.valueOf(229), Problem_254.function_g(BigInteger.valueOf(31)));                // sg(i) = 13
        Assert.assertEquals(BigInteger.valueOf(1229), Problem_254.function_g(BigInteger.valueOf(32)));               // sg(i) = 14
        Assert.assertEquals(BigInteger.valueOf(39), Problem_254.function_g(BigInteger.valueOf(33)));                 // sg(i) = 12
        Assert.assertEquals(BigInteger.valueOf(139), Problem_254.function_g(BigInteger.valueOf(34)));                // sg(i) = 13
        Assert.assertEquals(BigInteger.valueOf(239), Problem_254.function_g(BigInteger.valueOf(35)));                // sg(i) = 14
        Assert.assertEquals(BigInteger.valueOf(1239), Problem_254.function_g(BigInteger.valueOf(36)));               // sg(i) = 15
        Assert.assertEquals(BigInteger.valueOf(13339), Problem_254.function_g(BigInteger.valueOf(37)));              // sg(i) = 19
        Assert.assertEquals(BigInteger.valueOf(23599), Problem_254.function_g(BigInteger.valueOf(38)));              // sg(i) = 28
        Assert.assertEquals(BigInteger.valueOf(4479), Problem_254.function_g(BigInteger.valueOf(39)));               // sg(i) = 24
        Assert.assertEquals(BigInteger.valueOf(14479), Problem_254.function_g(BigInteger.valueOf(40)));              // sg(i) = 25
        Assert.assertEquals(BigInteger.valueOf(2355679), Problem_254.function_g(BigInteger.valueOf(41)));            // sg(i) = 37
        Assert.assertEquals(BigInteger.valueOf(344479), Problem_254.function_g(BigInteger.valueOf(42)));             // sg(i) = 31
        Assert.assertEquals(BigInteger.valueOf(1344479), Problem_254.function_g(BigInteger.valueOf(43)));            // sg(i) = 32
        Assert.assertEquals(BigInteger.valueOf(2378889), Problem_254.function_g(BigInteger.valueOf(44)));            // sg(i) = 45
        Assert.assertEquals(BigInteger.valueOf(12378889), Problem_254.function_g(BigInteger.valueOf(45)));           // sg(i) = 46
        Assert.assertEquals(BigInteger.valueOf(133378889), Problem_254.function_g(BigInteger.valueOf(46)));          // sg(i) = 50
        /*
46 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1061} "47" -> "2356888899"
47 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1062} "48" -> "12356888899"
48 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1063} "49" -> "133356888899"
49 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1064} "50" -> "12245677888899"
50 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1065} "51" -> "34446666888899"
51 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1066} "52" -> "134446666888899"
52 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1067} "53" -> "12245578899999999"
53 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1068} "54" -> "123345578899999999"
54 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1069} "55" -> "1333666799999999999"
55 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1070} "56" -> "12245556666799999999999"
56 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1071} "57" -> "123345556666799999999999"
57 = {java.util.concurrent.ConcurrentHashMap$MapEntry@1072} "58" -> "1333579999999999999999999"

                                                             60  ->  1233456679999999999999999999999
                                                             61  ->  13444667779999999999999999999999
                                                             62  ->  12245555588888999999999999999999999999999
                                                             63  ->  123345555588888999999999999999999999999999
                                                             64  ->
        * */
    }

    enum Factorial {
        F9(9, 362880),
        F8(8, 40320),
        F7(7, 5040),
        F6(6, 720),
        F5(5, 120),
        F4(4, 24),
        F3(3, 6),
        F2(2, 2),
        F1(1, 1),
        F0(0, 1);

        private final int num;
        private final int value;

        Factorial(int num, int value) {
            this.num = num;
            this.value = value;
        }

        public int getNum() {
            return num;
        }

        public int getValue() {
            return value;
        }
    }

    private static class SumRestrictedEnumerationsSpliterator extends MultipleElementSpliterator<List<Factorial>> {

        private final List<Factorial> seed = Arrays.asList(Factorial.F9, Factorial.F8, Factorial.F7, Factorial.F6, Factorial.F5, Factorial.F4, Factorial.F3, Factorial.F2, Factorial.F1);
        private final int expectResult;

        public SumRestrictedEnumerationsSpliterator(final int expectResult) {
            super(Long.MAX_VALUE, Spliterator.NONNULL);
            this.expectResult = expectResult;
        }

        @Override
        protected boolean tryAdvanceMultiple(Consumer<? super List<Factorial>> action) {
            AtomicLong bestLength = new AtomicLong(expectResult); // to prevent ridiculously long numbers ... best guess is half the size of the expected
            if(expectResult > 55) {
                // need a kick in the pants ...
                int i = 11;
                int newBest = expectResult - i;
                /*if(expectResult > 61) {
                    i = expectResult / 2;
                }*/
                List<Factorial> start = IntStream.range(0, i).mapToObj(ignore -> Factorial.F9)
                                                 .collect(Collectors.toList());
                BigInteger newSum = BigInteger.valueOf(i * Factorial.F9.getValue());
                bestLength.set(newBest);
                recursiveConsumer(start, newSum, seed, bestLength, action);

            } else {
                recursiveConsumer(Collections.emptyList(), BigInteger.ZERO, seed, bestLength, action);
            }
            return false;
        }

        private void recursiveConsumer(List<Factorial> head, BigInteger sum, List<Factorial> allowed, AtomicLong bestLength, Consumer<? super List<Factorial>> action) {
            if(head.size() <= bestLength.get()) {

                int digitSum = sum.toString().chars().map(Character::getNumericValue).sum();
                if(digitSum == expectResult) {
                    bestLength.set(head.size());
                    action.accept(head);
                } else if(digitSum < expectResult) {
                    if(!allowed.isEmpty()) {
                        long bestPossible = digitSum + (allowed.get(0).getNum() * (bestLength.get() - head.size() + 1));

                        if(bestPossible > expectResult) {
                            for (Factorial token : allowed) {
                                final List<Factorial> newAllowed = allowed.stream().filter(m -> token.compareTo(m) <= 0).collect(Collectors.toList());
                                recursiveConsumer(
                                        Stream.concat(head.stream(), Stream.of(token)).collect(Collectors.toList()),
                                        sum.add(BigInteger.valueOf(token.getValue())), newAllowed, bestLength, action
                                );
                            }
                        }
                    }
                }
            }
        }

    }

    @Test
    public void determineMinimumSum() {
        BigInteger min = StreamSupport.stream(new SumRestrictedEnumerationsSpliterator(64), false)
                                      .map(set -> {
                                          String value = set.stream().map(i -> Integer.toString(i.getNum())).reduce("", (l, r) -> r + l);
                                          return new BigInteger(value);
                                      }).reduce(BigInteger.ZERO, (l, r) -> {
                                            if(BigInteger.ZERO.equals(l)) {
                                                return r;
                                            } else if(BigInteger.ZERO.equals(r)) {
                                                return l;
                                            }
                                            return l.min(r);
                                      });

        System.out.println("min: " + min);
    }



    /*@Test
    @Ignore
    public void manual_test_enumeration() {
        Problem_254.enumerationsLimited(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 15)
                .forEach(System.out::println);
    }*/
}
