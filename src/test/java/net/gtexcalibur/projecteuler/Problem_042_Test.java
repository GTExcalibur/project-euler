package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 8:17 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_042_Test {

    @Test
    public void test_isTriangleNumber() {
        Assert.assertTrue(Problem_042.isTriangleNumber(1));
        Assert.assertTrue(Problem_042.isTriangleNumber(3));
        Assert.assertTrue(Problem_042.isTriangleNumber(6));
        Assert.assertTrue(Problem_042.isTriangleNumber(10));
        Assert.assertTrue(Problem_042.isTriangleNumber(15));
        Assert.assertTrue(Problem_042.isTriangleNumber(21));
        Assert.assertTrue(Problem_042.isTriangleNumber(28));
        Assert.assertTrue(Problem_042.isTriangleNumber(36));
        Assert.assertTrue(Problem_042.isTriangleNumber(45));
        Assert.assertTrue(Problem_042.isTriangleNumber(55));

        Assert.assertFalse(Problem_042.isTriangleNumber(1+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(3+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(6+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(10+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(15+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(21+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(28+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(36+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(45+1));
        Assert.assertFalse(Problem_042.isTriangleNumber(55+1));
    }
}
