package com;

import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class Utils {
    private static final Logger log = Logger.getLogger(Utils.class);
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

    /**
     * The method for reading text from file
     * param fileName
     */
    public void  isReadTextFromFile(String fileName){
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
              stream.forEach(System.out::print);
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }


}
