package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream
{
    private FileOutputStream fileOutputStream;

    public static String fileName = "C:/tmp/result.txt";


    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public void close()
    {
        try
        {
            fileOutputStream.flush();

            String s = "JavaRush © 2012-2013 All rights reserved.";

            fileOutputStream = new FileOutputStream(fileName, true);
            fileOutputStream.write(s.getBytes());

            fileOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        new AmigoOutputStream(new FileOutputStream(fileName)).close();
    }

}