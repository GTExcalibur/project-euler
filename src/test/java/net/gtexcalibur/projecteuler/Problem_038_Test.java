package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/24/2017, Time: 7:36 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_038_Test {

    @Test
    public void test_canCreateConcatenatedProduct_192384576() {
        Assert.assertTrue(Problem_038.canCreateConcatenatedProduct(Arrays.asList("1", "9", "2", "3", "8", "4", "5", "7", "6")));
    }

    @Test
    public void test_canCreateConcatenatedProduct_918273645() {
        Assert.assertTrue(Problem_038.canCreateConcatenatedProduct(Arrays.asList("9", "1", "8", "2", "7", "3", "6", "4", "5")));
    }
}
