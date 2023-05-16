package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(reader.readLine());
        FileOutputStream fileOutput = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        if (fileInput.available() > 0 && fileInput.available() % 2 == 0)
        {
            byte[] buffer = new byte[fileInput.available() / 2];
            int count = fileInput.read(buffer);
            fileOutput.write(buffer, 0, count);
            count = fileInput.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }

        if (fileInput.available() > 0 && fileInput.available() % 2 != 0)
        {
            byte[] buffer = new byte[fileInput.available() / 2 + 1];
            int count = fileInput.read(buffer);
            fileOutput.write(buffer, 0, count);
            count = fileInput.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }

        reader.close();
        fileInput.close();
        fileOutput.close();
        fileOutputStream.close();

    }
}
