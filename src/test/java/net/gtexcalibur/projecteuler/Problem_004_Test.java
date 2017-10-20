package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/19/2017, Time: 10:26 PM
 * <br> To change this template use File | Settings | File Templates.
 * @author George Turner
 */
public class Problem_004_Test {

    @Test
    public void test_isPalindromic_oddDigits() {
        Assert.assertTrue(Problem_004.isPalindromic(BigInteger.valueOf(232)));
    }

    @Test
    public void test_isPalindromic_evenDigits() {
        Assert.assertTrue(Problem_004.isPalindromic(BigInteger.valueOf(22)));
    }

    @Test
    public void test_isPalindromic_failure() {
        Assert.assertFalse(Problem_004.isPalindromic(BigInteger.valueOf(12)));
    }
}
