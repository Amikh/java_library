package com;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

public class Library {
    /**
     * The method for read list a files from any directory
     * using the .walk() method, passing a Paths argument
     * param isPathFile
     */
   public void isGetListFiles(String isPathFile) throws IOException {
       Stream<Path> paths;
       paths = Files.walk(Paths.get(isPathFile));
       paths.filter(Files::isRegularFile).forEach(System.out::println);
      }
    /**
     * The method return the current date
     * using java.util.Date in format "dd.MM.yy"
     */
   public String isCurrentDate() {
        return new SimpleDateFormat("dd.MM.yy").format(new Date());
     }
    /**
     * The method for convert stamp date
     * param inputFormat
     * param inputTimeStamp
     * param outputFormat
     * throws ParseException
     */
   public String isStampConvert(final String inputFormat, String inputTimeStamp, String outputFormat)
            throws ParseException {
        return new SimpleDateFormat(outputFormat, Locale.ENGLISH)
                .format(new SimpleDateFormat(inputFormat).parse(inputTimeStamp));
    }
    /**
     * The method return a number for your choose
     *
     */
    public double  isRandomNumber(int min, int max) {
            return  (int)(Math.random()*((max-min)+1))+min;
        }
    /**
     * The method convert string to Integer
     * param strNumber
     * return
     */
    public int isConvertStringToInteger(String strNumber) {
        return Integer.parseInt(strNumber);
    }
    /**
     * The method convert Integer to string
     * param intNumber
     *
     */
    public String isConvertIntegerToString(int intNumber) {
        return Integer.toString(intNumber);
    }
    /**
     * The method - to check if object is Integer.
     *
     * param obj
     * return
     */
    public boolean isCheckObjectInteger(Object obj) {
        return obj instanceof Integer;
    }
    /**
     * The method - to check if value is String.
     *
     * param obj
     * return
     */
    public boolean isCheckValueString(Object obj){
        return obj instanceof String;
    }
    /**
     * The method for create a file txt  with content.
     *
     * param path
     * param content
     * throws IOException
     */
    public void isCreateFile(String path, String content) throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(path));
        wr.write(content);
        wr.close();
    }
    /**
     * The method for print Map
     * param map
     */
    public void isPrintMap (Map<Integer, String> map) {
        for (Map.Entry<Integer, String> en : map.entrySet()) {
             Integer key = en.getKey();
             String value = en.getValue();
             System.out.println("Key: " + key + "   " + "Value: " + value);
        }
    }

    /**
     * The method for print repeat number from array
     * param arr
     * param size
     */
    public void printRepeatingNumber(int[] arr, int size){
        int i, j;
        for (i = 0; i < size; i++)  {
            for (j = i + 1; j < size; j++){
                if (arr[i] == arr[j]) {
                    int number = arr[i];
                    System.out.print(number +" ");
                }
            }
        }
    }

   }



