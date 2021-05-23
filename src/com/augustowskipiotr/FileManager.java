package com.augustowskipiotr;

import java.io.*;
import java.util.stream.Collectors;

public class FileManager {

    public static String read(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path));

        String fileText = bufferedReader.lines().collect(Collectors.joining());
        bufferedReader.close();

        return fileText;
    }

    public static void write(String path, String data) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(data);

        bufferedWriter.close();
    }
}
