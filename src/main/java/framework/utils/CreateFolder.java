package framework.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class CreateFolder {

    public static void deleteDirectoryRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        Files.delete(file.toPath());
    }

    public static void createDirectory(String path) throws IOException {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        } else {
            deleteDirectoryRecursively(new File(path));
            createDirectory(path);
        }
    }

}