package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/27/2017, Time: 9:40 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_060_Test {

    @Test
    public void test_canWriteAsConcatenatedPrimes() {
        Assert.assertTrue(
                Problem_060.canWriteAsConcatenatedPrimes(Arrays.asList(
                        BigInteger.valueOf(3),
                        BigInteger.valueOf(7),
                        BigInteger.valueOf(109),
                        BigInteger.valueOf(673)
                ))
        );
    }

    @Test
    public void test_canWriteAsConcatenatedPrimes_subSet() {
        Assert.assertTrue(
                Problem_060.canWriteAsConcatenatedPrimes(Arrays.asList(
                        BigInteger.valueOf(3),
                        BigInteger.valueOf(7)
                ))
        );
    }
}
