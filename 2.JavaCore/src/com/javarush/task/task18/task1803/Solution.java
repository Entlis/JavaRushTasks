package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileInput.available() > 0)
        {
            list.add(fileInput.read());
        }
        int count = 1;
        String s = "";
        for (int i = list.size() - 1; i >= 0; i--)
        {
            int sum = 1;
            for (int j = 0; j < i; j++)
            {
                if (list.get(j) == list.get(i))
                    sum++;
            }
            if (count < sum)
            {
                count = sum;
                s = list.get(i) + " ";
            }
            else if (count == sum)
                s += list.get(i) + " ";
        }
        System.out.println(s);
        fileInput.close();
    }
}

