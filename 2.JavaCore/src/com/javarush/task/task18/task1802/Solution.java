package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        long max = Integer.MAX_VALUE;;
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if(max > data){
                max = data;
            }
        }
        System.out.println(max);
        fileInputStream.close();
    }
}