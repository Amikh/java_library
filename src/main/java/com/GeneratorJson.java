package com;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GeneratorJson {
    private static final Logger log = Logger.getLogger(GeneratorJson.class);

  public String isCreateJSON(){
        FileWriter writer = null;
        JSONParser parser = new JSONParser();
        Object simpleObj = null;

        try {
            String p = "C:/TEMP/";
            isCheckIfFolderPresent(p);
            writer = new FileWriter(p+"test.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JsonGenerator to create JSONObject and store it to file location mentioned above
        JsonGenerator generator = Json.createGenerator(writer);
        generator
             .writeStartObject().writeStartArray("Company")
                .writeStartObject()
                    .write("name", "AM")
                    .write("address", "NYC")
                        .writeStartObject("support")
                            .write("JAVA", "text")
                            .write("Node", "JS")
                               .writeStartArray("products")
                                  .write("AA").write("BB").write("CC")
                               .writeEnd()
                        .writeEnd()
                .writeEnd()
             .writeEnd().writeEnd();
        generator.close();

        try {
            simpleObj = parser.parse(new FileReader("C:/TEMP/test.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        assert simpleObj != null;
        String prettyJson = crucifyPrettyJSONUtility(simpleObj.toString());
        return prettyJson;
    }

    //  JSON Utility
    public static String crucifyPrettyJSONUtility(String simpleJSON) {
        JsonObject json = JsonParser.parseString(simpleJSON).getAsJsonObject();
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(json);
    }

   //Function for check if folder is present and make if is not.
     public void isCheckIfFolderPresent(String path){
         System.out.println("Path for check "+ path);
         File f = new File(path);
         if (f.exists() && f.isDirectory()) {
             log.info("Folder is present");
         }else{
             log.info("Folder don't present, start create folder in path :" + path);
              f.mkdirs();
         }
     }

}


