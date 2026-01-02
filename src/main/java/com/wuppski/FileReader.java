package com.wuppski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> readFile(String filename) {
        ArrayList<String> inputList = new ArrayList<>();
        try (InputStream is = FileReader.class.getResourceAsStream(filename);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)
        )
        {
            br.lines().forEach(inputList::add);
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        return inputList;
    }


}
