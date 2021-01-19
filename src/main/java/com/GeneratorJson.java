package com;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GeneratorJson {

    public static void main(String[] args) {

        FileWriter writer = null;
        JSONParser parser = new JSONParser();
        Object simpleObj = null;

        try {
            writer = new FileWriter("C:/TEMP/test.json");
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
        System.out.println("\nPretty JSON Result:\n" + prettyJson);

    }

    // Prettify JSON Utility
    public static String crucifyPrettyJSONUtility(String simpleJSON) {
        JsonObject json = JsonParser.parseString(simpleJSON).getAsJsonObject();
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(json);
    }
}


