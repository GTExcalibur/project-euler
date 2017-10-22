package net.gtexcalibur.util;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 11:29 AM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class CombinationUtilsTest {

    @Test
    @Ignore
    public void manual_test() {
        CombinationUtils.combinations(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), 2)
                        .forEach(System.out::println);
    }
}
