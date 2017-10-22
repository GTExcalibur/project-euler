package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 3:47 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_125_Test {

    @Test
    public void test_canWriteAsSumOfConsecutiveSquares() {
        Assert.assertTrue(Problem_125.canWriteAsSumOfConsecutiveSquares(595));
    }

    @Test
    public void test_canWriteAsSumOfConsecutiveSquares_with5() {
        Assert.assertTrue(Problem_125.canWriteAsSumOfConsecutiveSquares(5));
    }

    @Test
    public void test_canWriteAsSumOfConsecutiveSquares_with9() {
        Assert.assertFalse(Problem_125.canWriteAsSumOfConsecutiveSquares(9));
    }

    @Test
    public void test_canWriteAsSumOfConsecutiveSquares_with2176712() {
        Assert.assertTrue(Problem_125.canWriteAsSumOfConsecutiveSquares(2176712));
    }
}
