package com;


import java.io.*;

public class ReadFiles {

    /**
     * The method for print text from a file
     *  pathFile - Path location a file
     *  return text from a file
     */
    public void  isReadStringFromFile(String pathFile) {
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
        System.out.println(sb.toString());
        }


}
