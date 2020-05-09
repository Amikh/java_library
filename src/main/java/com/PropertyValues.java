package com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static com.Constants.CONFIG_PROPERTIES;

/**
 * The class - example how get data from config properties file
 * in this example - print two parameters : user and password
 */
public class PropertyValues {


    InputStream inputStream;
    public void  getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + CONFIG_PROPERTIES + "' not found in the classpath");
            }

          // get the property value and print it out
           String user = prop.getProperty("user");
           String pass = prop.getProperty("pass");
           System.out.println("User : "+user + " Password : "+pass);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }

    }
}
