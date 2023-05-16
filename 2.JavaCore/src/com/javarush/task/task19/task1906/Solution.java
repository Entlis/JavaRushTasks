package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        FileWriter writer = new FileWriter(bufferedReader.readLine());
        int har;
        int count = 1;
        while ((har = reader.read()) != -1) {
            count++;
            if (count % 2 != 0) {
                writer.write(har);
            }
        }
        bufferedReader.close();
        reader.close();
        writer.close();
    }
}
