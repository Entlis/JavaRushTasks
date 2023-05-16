package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(reader.readLine());

        int count = 0;
        while (fileInput.available() > 0)
        {
            char c = (char) fileInput.read();
            if (c == ',')
                count++;
        }
        System.out.println(count);

        reader.close();
        fileInput.close();
    }
}
