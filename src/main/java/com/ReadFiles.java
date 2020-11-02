package com;


import org.apache.log4j.Logger;

import java.io.*;

public class ReadFiles {
    private static final Logger log = Logger.getLogger(ReadFiles.class);

    /**
     * The method for print text from a file
     *  pathFile - Path location a file
     *  return text from a file
     */
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
                log.error(exception.getMessage());
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
            log.info("reading text from file is ok");
        return sb.toString();
        }


}
