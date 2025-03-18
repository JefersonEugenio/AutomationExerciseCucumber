package framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private static final String BASE_DIR = "src";

    private static Path buildPath(String directory, String folderName) {
        return Paths.get(BASE_DIR, directory, "resources", folderName);
    }

    public static void createFolder(String directory, String folderName) {
        Path folderPath = buildPath(directory, folderName);

        try {
            Files.createDirectories(folderPath);
        } catch (IOException e) {
            System.out.println("Erro ao criar a pasta '" + folderPath + "': " + e.getMessage());
        }
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