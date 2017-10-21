package net.gtexcalibur.projecteuler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by George Turner on 10/20/2017.
 */
public class Problem_022_Test {

    @Test
    public void test_getAlphabeticalValue() {
        Assert.assertEquals(53, Problem_022.getAlphabeticalValue("COLIN"));
    }
}
