/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testConstructorFromBadArrays() {
        assertThrows(IllegalArgumentException.class, ()-> new Dip(new int[]{0, 10, 20, 30, 40}, new int[]{2,4}));
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

}
