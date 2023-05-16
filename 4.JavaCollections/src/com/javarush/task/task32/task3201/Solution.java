package com.javarush.task.task32.task3201;

import java.io.*;
import java.util.Scanner;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args)  {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
            long number = Long.parseLong(args[1]);
            long length = raf.length();
            number = number > length ? length : number;
            raf.seek(number);
            raf.write(args[2].getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
