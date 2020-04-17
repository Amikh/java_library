package com;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Library {
    /**
     * The method for read list a files from any directory
     * using the .walk() method, passing a Paths argument
     * param isPathFile
     */
   public void isGetListFiles(String isPathFile) {
       try (Stream<Path> paths = Files.walk(Paths.get(isPathFile))) {
           paths.filter(Files::isRegularFile).forEach(System.out::println);
          } catch (Exception ignore) {

          }
      }
   }



