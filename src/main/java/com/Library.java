package com;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
     * Example
     * input : param arr - {1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9};
     * input : param size
     * output: 4 , 7
     */
    public void isPrintRepeatingNumber(int[] arr){
        int i, j;
        int size = arr.length;
        for (i = 0; i < size; i++)  {
            for (j = i + 1; j < size; j++){
                if (arr[i] == arr[j]) {
                    int number = arr[i];
                    System.out.print(number +" ");
                }
            }
        }
    }
    /**
     * The method for print new array without a repeating number
     * Example
     * input : param arr - {1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9};
     * input : param size
     * output: {1, 2, 3, 4, 5, 6, 7, 8, 9}
     */
    public void isPrintArrayWithOutRepeatingNumber(int[] arr){
        int i, j;
        int size = arr.length;
        boolean index = false;
        List<Integer> list = new ArrayList<>();
        for (i = 0; i < size; i++)  {
            for (j = i + 1; j < size; j++){
                if (arr[i] == arr[j]) {
                    index = true;
                }
            }
            int number = arr[i];
            if(!index){
                list.add(number);
            }
            index = false;
        }
        System.out.println(Collections.singletonList(list));
    }
    /**
     * The method for print new array
     * Where delete all repeating number
     * Example
     * input : param arr - {1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9};
     * 4 and 7 - the repeating number - delete form array
     * output: {1, 2, 3, 5, 6, 8, 9}
     */
    public void isDeleteRepeatingValueFromArray(int[] arr){
        int size = arr.length; //get size array
        int i, j;
        boolean index = false;

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    int number = arr[i];
                    list1.add(number);
                    index = true;
                }
            }
            int number = arr[i];
            if (!index) {
                list.add(number);
            }
            index = false;
        }

        System.out.println("before");
        System.out.println(Collections.singletonList(list));
        isDeleteValueFromArray(list,list1);
        System.out.println("Modified ArrayList"+Collections.singletonList(list));
    }
    public static void isDeleteValueFromArray(List<Integer> list,List<Integer> list1){
        for (int num : list1)
            for (int j = 0; j < list.size(); j++) {
                int n = list.get(j);
                if (n == num) {
                    list.remove(j);
                }
            }
    }



   }



