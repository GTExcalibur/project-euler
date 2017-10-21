package net.gtexcalibur.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by George Turner on 10/20/2017.
 */
public class FactorUtilsTest {

    @Test
    public void test_factors() {
        Stream<BigInteger> factors = FactorUtils.factors(BigInteger.valueOf(28));

        Assert.assertEquals("1,2,4,7,14,28", factors.map(Objects::toString).collect(Collectors.joining(",")));
    }

    @Test
    public void test_factors2() {
        Stream<BigInteger> factors = FactorUtils.factors(BigInteger.valueOf(4));

        Assert.assertEquals("1,2,4", factors.map(Objects::toString).collect(Collectors.joining(",")));
    }

    @Test
    public void test_properDivisors() {
        Stream<BigInteger> factors = FactorUtils.properDivisors(BigInteger.valueOf(28));

        Assert.assertEquals("1,2,4,7,14", factors.map(Objects::toString).collect(Collectors.joining(",")));
    }

    @Test
    public void test_properDivisors2() {
        Stream<BigInteger> factors = FactorUtils.properDivisors(BigInteger.valueOf(12));

        Assert.assertEquals("1 + 2 + 3 + 4 + 6", factors.map(Objects::toString).collect(Collectors.joining(" + ")));
    }

    @Test
    public void test_properDivisors3() {
        Stream<BigInteger> factors = FactorUtils.properDivisors(BigInteger.valueOf(4));

        Assert.assertEquals("1,2", factors.map(Objects::toString).collect(Collectors.joining(",")));
    }
}
