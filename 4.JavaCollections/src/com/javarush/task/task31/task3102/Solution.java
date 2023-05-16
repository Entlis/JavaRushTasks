package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> filePaths = new ArrayList<>();

        // Создаем очередь и добавляем корневую директорию в нее
        Queue<Path> queue = new LinkedList<>();
        queue.add(Paths.get(root));

        while (!queue.isEmpty()) {
            Path current = queue.poll();

            // Если текущий элемент является файлом, добавляем его путь в список
            if (Files.isRegularFile(current)) {
                filePaths.add(current.toAbsolutePath().toString());
            } else if (Files.isDirectory(current)) {
                // Если текущий элемент является каталогом, добавляем все его дочерние элементы в очередь
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(current)) {
                    for (Path path : stream) {
                        queue.add(path);
                    }
                }
            }
        }

        return filePaths;
    }

    public static void main(String[] args) {

    }
}
