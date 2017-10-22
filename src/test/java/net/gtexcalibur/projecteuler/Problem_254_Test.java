package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

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
        Assert.assertEquals(BigInteger.valueOf(1), Problem_254.function_g(BigInteger.valueOf(1)));
        Assert.assertEquals(BigInteger.valueOf(2), Problem_254.function_g(BigInteger.valueOf(2)));
        Assert.assertEquals(BigInteger.valueOf(5), Problem_254.function_g(BigInteger.valueOf(3)));
        Assert.assertEquals(BigInteger.valueOf(15), Problem_254.function_g(BigInteger.valueOf(4)));
        Assert.assertEquals(BigInteger.valueOf(25), Problem_254.function_g(BigInteger.valueOf(5)));
        Assert.assertEquals(BigInteger.valueOf(3), Problem_254.function_g(BigInteger.valueOf(6)));
        Assert.assertEquals(BigInteger.valueOf(13), Problem_254.function_g(BigInteger.valueOf(7)));
        Assert.assertEquals(BigInteger.valueOf(23), Problem_254.function_g(BigInteger.valueOf(8)));
        Assert.assertEquals(BigInteger.valueOf(6), Problem_254.function_g(BigInteger.valueOf(9)));
        Assert.assertEquals(BigInteger.valueOf(16), Problem_254.function_g(BigInteger.valueOf(10)));
        Assert.assertEquals(BigInteger.valueOf(26), Problem_254.function_g(BigInteger.valueOf(11)));
        Assert.assertEquals(BigInteger.valueOf(44), Problem_254.function_g(BigInteger.valueOf(12)));
        Assert.assertEquals(BigInteger.valueOf(144), Problem_254.function_g(BigInteger.valueOf(13)));
        Assert.assertEquals(BigInteger.valueOf(256), Problem_254.function_g(BigInteger.valueOf(14)));
        Assert.assertEquals(BigInteger.valueOf(36), Problem_254.function_g(BigInteger.valueOf(15)));
        Assert.assertEquals(BigInteger.valueOf(136), Problem_254.function_g(BigInteger.valueOf(16)));
        Assert.assertEquals(BigInteger.valueOf(236), Problem_254.function_g(BigInteger.valueOf(17)));
        Assert.assertEquals(BigInteger.valueOf(67), Problem_254.function_g(BigInteger.valueOf(18)));
        Assert.assertEquals(BigInteger.valueOf(167), Problem_254.function_g(BigInteger.valueOf(19)));
        Assert.assertEquals(BigInteger.valueOf(267), Problem_254.function_g(BigInteger.valueOf(20)));
        Assert.assertEquals(BigInteger.valueOf(349), Problem_254.function_g(BigInteger.valueOf(21)));
        Assert.assertEquals(BigInteger.valueOf(1349), Problem_254.function_g(BigInteger.valueOf(22)));
        Assert.assertEquals(BigInteger.valueOf(2349), Problem_254.function_g(BigInteger.valueOf(23)));
        Assert.assertEquals(BigInteger.valueOf(49), Problem_254.function_g(BigInteger.valueOf(24)));
        Assert.assertEquals(BigInteger.valueOf(149), Problem_254.function_g(BigInteger.valueOf(25)));
        Assert.assertEquals(BigInteger.valueOf(249), Problem_254.function_g(BigInteger.valueOf(26)));
        Assert.assertEquals(BigInteger.valueOf(9), Problem_254.function_g(BigInteger.valueOf(27)));
        Assert.assertEquals(BigInteger.valueOf(19), Problem_254.function_g(BigInteger.valueOf(28)));
        Assert.assertEquals(BigInteger.valueOf(29), Problem_254.function_g(BigInteger.valueOf(29)));
        Assert.assertEquals(BigInteger.valueOf(129), Problem_254.function_g(BigInteger.valueOf(30)));
        Assert.assertEquals(BigInteger.valueOf(229), Problem_254.function_g(BigInteger.valueOf(31)));
        Assert.assertEquals(BigInteger.valueOf(1229), Problem_254.function_g(BigInteger.valueOf(32)));
        Assert.assertEquals(BigInteger.valueOf(39), Problem_254.function_g(BigInteger.valueOf(33)));
        Assert.assertEquals(BigInteger.valueOf(139), Problem_254.function_g(BigInteger.valueOf(34)));
        Assert.assertEquals(BigInteger.valueOf(239), Problem_254.function_g(BigInteger.valueOf(35)));
        Assert.assertEquals(BigInteger.valueOf(1239), Problem_254.function_g(BigInteger.valueOf(36)));
        Assert.assertEquals(BigInteger.valueOf(13339), Problem_254.function_g(BigInteger.valueOf(37)));
        Assert.assertEquals(BigInteger.valueOf(23599), Problem_254.function_g(BigInteger.valueOf(38)));
        Assert.assertEquals(BigInteger.valueOf(4479), Problem_254.function_g(BigInteger.valueOf(39)));
        Assert.assertEquals(BigInteger.valueOf(14479), Problem_254.function_g(BigInteger.valueOf(40)));
        Assert.assertEquals(BigInteger.valueOf(2355679), Problem_254.function_g(BigInteger.valueOf(41)));
        Assert.assertEquals(BigInteger.valueOf(344479), Problem_254.function_g(BigInteger.valueOf(42)));
        Assert.assertEquals(BigInteger.valueOf(1344479), Problem_254.function_g(BigInteger.valueOf(43)));
        Assert.assertEquals(BigInteger.valueOf(2378889), Problem_254.function_g(BigInteger.valueOf(44)));
        Assert.assertEquals(BigInteger.valueOf(12378889), Problem_254.function_g(BigInteger.valueOf(45)));
        Assert.assertEquals(BigInteger.valueOf(133378889), Problem_254.function_g(BigInteger.valueOf(46)));
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
        * */
    }

    /*@Test
    @Ignore
    public void manual_test_enumeration() {
        Problem_254.enumerationsLimited(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 15)
                .forEach(System.out::println);
    }*/
}
