package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 4:46 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_104_Test {

    @Test
    public void test_isPandigital() {
        Assert.assertTrue(Problem_104.isPandigital("123456789"));
        Assert.assertFalse(Problem_104.isPandigital("123442589"));
    }
}
