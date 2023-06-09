package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File oneFile = new File(reader.readLine());
        File twoFile = new File(reader.readLine());
        Scanner scanner = new Scanner(oneFile);
        while (scanner.hasNextLine())
        {
            allLines.add(scanner.nextLine());
        }
        scanner = new Scanner(twoFile);
        while (scanner.hasNextLine())
        {
            forRemoveLines.add(scanner.nextLine());
        }
        reader.close();
        scanner.close();
        new Solution().joinData();
    }

    public void joinData() throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}