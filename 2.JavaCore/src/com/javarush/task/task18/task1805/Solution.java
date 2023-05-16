package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0){
            list.add(fileInputStream.read());
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i: list) {
           if (!temp.contains(i)){
               temp.add(i);
           }
        }
        Collections.sort(temp);
        for (int i: temp) {
            System.out.println(i + " ");
        }
        fileInputStream.close();
    }
}
