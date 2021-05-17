package com.test;
import com.Constants;
import com.ReadFiles;
import com.Utils;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
@Log4j
public class ReadFilesTest {
    Utils ut = new Utils();
    ReadFiles rf = new ReadFiles();
    /**
     * The test for print text out from file
     * throws IOException
     */
    @Test
    public void isReadStringFromFileTest(){
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
     * The test 'Jay_way' JsonPath
     * https://github.com/json-path/JsonPath
     * throws IOException
     */
    @Test
    public void isJsonPathTest(){
        String pathFile = ut.isGetPathToFile(Constants.JSON_FILE_TEST);
        String result = rf.isReadStringFromFile(pathFile);
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(result);
        String author = JsonPath.read(document, "$.store.book[3].author");
        log.info("author: "+author);
    }
}
