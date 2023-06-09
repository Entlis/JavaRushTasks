package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            InputStream inputStream = new FileInputStream(reader.readLine());

            Properties prop = new Properties();
            prop.load(inputStream);

            for (String name : prop.stringPropertyNames())
            {
                properties.put(name, prop.getProperty(name));
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception
    {
        if (properties != null)
        {
            Properties prop = new Properties();

            prop.putAll(properties);

            PrintStream printStream = new PrintStream(outputStream);
            prop.store(printStream, "");

            printStream.close();
        }
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties prop = new Properties();
        prop.load(inputStream);

        for (String name : prop.stringPropertyNames())
        {
            properties.put(name, prop.getProperty(name));
        }
    }
}
