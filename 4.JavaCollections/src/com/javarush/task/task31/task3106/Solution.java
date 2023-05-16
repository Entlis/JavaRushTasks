package com.javarush.task.task31.task3106;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        try (OutputStream os = new FileOutputStream(resultFileName);
             ZipInputStream zis = new ZipInputStream(new SequenceInputStream(new FileEnumeration(args))))
        {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = zis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.flush();
                zis.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FileEnumeration implements Enumeration<InputStream> {
        private final String[] files;
        private int index;

        FileEnumeration(String[] files) {
            this.files = files;
            this.index = 1;
        }

        @Override
        public boolean hasMoreElements() {
            return index < files.length;
        }

        @Override
        public InputStream nextElement() {
            try {
                return new FileInputStream(files[index++]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}