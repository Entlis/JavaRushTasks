package com.javarush.task.task31.task3104;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Поиск скрытых файлов
*/

public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("D:/"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();
    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if(path.toString().endsWith("zip") || path.toString().endsWith("rar")){
            archived.add(path.toString());
        }
        return super.visitFile(path, basicFileAttributes);
    }

    public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
        failed.add(path.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }
}
