package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        int count = 0;
        String s = "";
        while (reader.ready())
        {
            char c = (char) reader.read();
            if (Character.toString(c).matches("[a-z]"))
            {
                s += c;
            } else
            {
                if (s.equals("world"))
                    count++;
                s = "";
            }
        }
        bufferedReader.close();
        reader.close();
        System.out.println(count);
    }
}
