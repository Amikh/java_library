package com.test;

import com.Constants;
import com.ReadFiles;
import com.Utils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ReadFilesTest {
    Utils ut = new Utils();
    ReadFiles rf = new ReadFiles();


    /**
     * The test for print text out from file
     * throws IOException
     */
    @Test
    public void isReadStringFromFileTest() throws IOException {

        String txt = ut.isGetPathToFile(Constants.JSON_FILE_TEST);
        rf.isReadStringFromFile(txt);

    }
}
