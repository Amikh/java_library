package com.test;

import com.PropertyValues;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;


public class PropertiesTest {
    PropertyValues pv = new PropertyValues();

    /**
     * The test for check data in the properties file
     * throws IOException
     */

    @Test
    public void isPropValuesTest() throws IOException {
        pv.getPropValues();
    }


}
