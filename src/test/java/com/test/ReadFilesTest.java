package com.test;

import com.Constants;
import com.ReadFiles;
import com.Utils;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import java.io.IOException;

public class ReadFilesTest {
    private static final Logger log = Logger.getLogger(ReadFilesTest.class);
    Utils ut = new Utils();
    ReadFiles rf = new ReadFiles();


    /**
     * The test for print text out from file
     * throws IOException
     */
    @Ignore
    @Test
    public void isReadStringFromFileTest() throws IOException {

        String txt = ut.isGetPathToFile(Constants.JSON_FILE_TEST);
        rf.isReadStringFromFile(txt);
    }

    /**
     * The test check reading text from file
     * it's only print text.
     */
    @Test
    public void isReadTextFromFileTest(){
        String pathFile = ut.isGetPathToFile(Constants.JSON_FILE_TEST);
        ut.isReadTextFromFile(pathFile);
    }


    /**
     * The test Jayway JsonPath
     * https://github.com/json-path/JsonPath
     * throws IOException
     */
    @Test
    public void isJsonPathTest() throws IOException {
        String pathFile = ut.isGetPathToFile(Constants.JSON_FILE_TEST);
        String result = rf.isReadStringFromFile(pathFile);
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(result);
        String author = JsonPath.read(document, "$.store.book[3].author");
        log.info("author: "+author);
    }




}
