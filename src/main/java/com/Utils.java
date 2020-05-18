package com;

import java.io.File;
import java.util.Objects;

public class Utils {

    /**
     * The method return file path to file
     * param fileName
     * return
     */
      public String  isGetPathToFile(String fileName) {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return file.getAbsolutePath();
    }

}
