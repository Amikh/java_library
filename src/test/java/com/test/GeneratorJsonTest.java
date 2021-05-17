package com.test;
import com.GeneratorJson;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
@Log4j
public class GeneratorJsonTest {
      GeneratorJson gs = new GeneratorJson();
    @Test
    public void isTestGeneratorJson(){
        gs.isCreateJSON();
    }
}
