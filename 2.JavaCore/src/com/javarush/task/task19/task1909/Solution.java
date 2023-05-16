package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        FileWriter writer = new FileWriter(bufferedReader.readLine());
        while (reader.ready()) {
            int fileReader = reader.read();
            if (fileReader == 46)writer.write(33);
            else writer.write(fileReader);
        }

        bufferedReader.close();
        reader.close();
        writer.close();
    }
}
