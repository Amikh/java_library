package com.test;

import com.Library;
import org.junit.Test;

import java.io.IOException;

import static com.Constants.PATH_DIR;

public class LibraryTest {
    /**
     * Test List files from path
     * in this test using 'user.dir' for get path
     */
     @Test
     public void isGetListFilesTest(){
       try {
           Library lb= new Library();
           String path = System.getProperty(PATH_DIR);
           lb.isGetListFiles(path);
       }catch (Exception ex){
           ex.getMessage();
       }

     }


}
