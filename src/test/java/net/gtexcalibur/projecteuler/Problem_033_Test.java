package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 9:12 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_033_Test {

    @Test
    public void test_isCuriousFraction() {
        Assert.assertTrue(Problem_033.isCuriousFraction(Arrays.asList("4", "9", "9", "8")));
    }
}
