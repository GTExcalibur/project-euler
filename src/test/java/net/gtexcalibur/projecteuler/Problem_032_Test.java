package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 8:40 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_032_Test {

    @Test
    public void test_isMultiplicandMultiplierAndProduct_isPandigital() {
        Assert.assertTrue(Problem_032.isMultiplicandMultiplierAndProduct_isPandigital(7254));
    }

    @Test
    public void test_isMultiplicandMultiplierAndProduct_isPandigital_987654321() {
        Assert.assertFalse(Problem_032.isMultiplicandMultiplierAndProduct_isPandigital(987654321));
    }
}
