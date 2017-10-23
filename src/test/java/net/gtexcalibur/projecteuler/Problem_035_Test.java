package net.gtexcalibur.projecteuler;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * <br> Date: 10/22/2017, Time: 9:32 PM
 * <br> To change this template use File | Settings | File Templates.
 *
 * @author George Turner
 */
public class Problem_035_Test {

    @Test
    @Ignore
    public void manualTest_rotations() {
        Problem_035.rotations("012")
                   .forEach(System.out::println);
    }
}
