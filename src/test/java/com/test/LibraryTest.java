package com.test;
import com.Library;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import static com.Constants.PATH_DIR;
@Log4j
public class LibraryTest {
     Library lb= new Library();
    /**
     * The test List files from path
     * in this test using 'user.dir' for get path
     */
     @Test
     public void isGetListFilesTest() throws IOException {
       String path = System.getProperty(PATH_DIR);
       lb.isGetListFiles(path);
     }
    /**
     * The test is check current date
     * for running this test - need to write an expected date
     */
    @Test
     public void isCurrentDateTest(){
       String actual = lb.isCurrentDate();
       log.info(actual);
//       String expected = "";
//       Assert.assertEquals(expected,actual);
     }
    /**
     * The test - check convert a format stamp date
     * throws ParseException
     */
    @Test
    public void isStampConvertTest() throws ParseException {
       String index = "10/10/2000";
       String inputFormat = "dd/MM/yyyy";
       String outputFormat = "MMM d, yyyy hh:mm:ss aa";
       String actual = lb.isStampConvert(inputFormat,index,outputFormat);
       String expected = "Oct 10, 2000 12:00:00 AM";
       Assert.assertEquals(actual,expected);
     }
    /**
     * The test - check method random number
     */
    @Test
    public void isRandomNumberTest(){
        double actual = lb.isRandomNumber(5,7);
        double expected =6.0;
        Assert.assertEquals(actual,expected,2.0);
    }
    /**
     * The test - check method parse string to integer
     */
    @Test
    public void isConvertStringToIntegerTest(){
        int actual = lb.isConvertStringToInteger("13");
        int expected = 13;
        Assert.assertEquals(actual,expected);
    }
    /**
     * The test - check method parse integer to string
     */
    @Test
    public void isConvertIntegerToStringTest(){
        String actual = lb.isConvertIntegerToString(13);
        String expected = "13";
        Assert.assertEquals(actual,expected);
    }
    /**
     * The test - check method if object is Integer
     */
    @Test
    public void isCheckObjectIntegerTest(){
        Object ob = 13;
        boolean actual =  lb.isCheckObjectInteger(ob);
        Assert.assertTrue(actual);
    }
    /**
     * The test - check method if object is String
     */
    @Test
    public void isCheckValueStringTest(){
        Object ob = "13";
        boolean actual =  lb.isCheckValueString(ob);
        Assert.assertTrue(actual);
    }
    /**
     * The test - create file with text
     */
    @Test
    public void isCreateFileTest() throws IOException {
        String path = System.getProperty(PATH_DIR);
        lb.isCreateFile(path+"/file.txt","Ho ho ho !!!");
    }
    /**
     * The test - print from map
     */
    @Test
    public void isPrintMapTest(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2,"Python");
        map.put(3,"Scala");
        map.put(4,"Go");
        map.put(5,"JavaScript");
        lb.isPrintMap(map);
    }
    /**
     * The test - print repair number in array
     */
    @Test
    public void isPrintRepeatingNumberTest(){
        int [] arr= {1,2,3,4,4,5,6,7,7,8,9};
        lb.isPrintRepeatingNumber(arr);
    }
    /**
     * The test - print new array without repair number in array
     */
    @Test
    public void isPrintArrayWithOutRepeatingNumberTest() {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9};
        lb.isPrintArrayWithOutRepeatingNumber(arr);
    }
    /**
     * The test - print new array without repair number in array
     */
    @Test
    public void isDeleteRepeatingValueFromArrayTest() {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9};
        lb.isDeleteRepeatingValueFromArray(arr);
    }
<<<<<<< HEAD

    @Test
    public void isDifferenceNumberDaysTest()throws ParseException{
        int actual = lb.isDifferenceNumberDays("31/12/2021","dd/MM/yyyy");
        int expected = lb.isExpectedNumber();
        Assert.assertEquals(actual,expected);
    }

=======
>>>>>>> 92c568361a6556ec15a1642cc86b65b12f895466
}
