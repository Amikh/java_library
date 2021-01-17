package com;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.*;
import java.util.*;

public class ExampleJsonPath {


        public static void main(String[] args) {
            ExampleJsonPath m = new ExampleJsonPath();
            m.isTest();

        }


        public  void isTest(){
            String pathFile = isGetPathToFile("data.json");
            String result = isReadStringFromFile(pathFile);
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(result);

            //Get all object from json mdl in LIST
            List<String>  allMdl =  JsonPath.read(document, "$.point.data1[*].mdl");
            //Size list
            int sizeList = allMdl.size();
            //Create MAP with Int. and List
            Map<Integer,List> mapData = new HashMap<>();

            //For example get number mdl and begin to search point number
            String numberForCheck = "140";

            //Loop for out Array and put every one to map with KEY!!!
              for(List ls: Arrays.asList(allMdl)){
                  for(int j=0 ; j<=sizeList-1 ; j++){
                       mapData.put(j, (List) ls.get(j));
                   }
              }

            //   Now Print from Map Value
            for (Map.Entry<Integer, List> en : mapData.entrySet()) {
                Integer key = en.getKey();
                List value = en.getValue();
                System.out.println("Key: " + key + "   " + "Value: " + value);
            // The check if number is present in array
                 for(Object str : value){
                     System.out.println("Value : "+ str.toString());
                     Object num = str.toString();
             //
                      if (numberForCheck.equals(num)){
                          System.out.println("It's equals !!! :"+ num + " and key is "+key);
                          String  point =  JsonPath.read(document, "$.point.data1["+key+"].points");
                          System.out.println("Result  "+ point);
                      }

                 }

            }



        }




        public String  isGetPathToFile(String fileName) {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            return file.getAbsolutePath();
        }


        public String  isReadStringFromFile(String pathFile) {
            InputStream is = null;
            try {
                is = new FileInputStream(pathFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException exception) {

                exception.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                try {
                    line = br.readLine();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

            return sb.toString();
        }
    }




