package com.test;

import com.GeneratorJson;
import com.PropertyValues;
import org.junit.Test;
import java.io.IOException;

public class PropertiesTest {
    PropertyValues pv = new PropertyValues();
    GeneratorJson jj = new GeneratorJson();
    /**
     * The test for check data in the properties file
     * throws IOException
     */
    @Test
    public void isPropValuesTest() throws IOException {
        pv.getPropValues();
    }
    @Test
    public void isTestisCreateJSON(){
        jj.isCreateJSON();
    }

}
