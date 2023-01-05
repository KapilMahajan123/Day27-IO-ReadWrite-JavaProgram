package com.IOprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * Write a program to demonstrate file operations
 * check file exists
 * delete file and removed file or not
 * Create Directory, Created files and listing files 
 * And Directories from.
 */
public class FileOperationsDemo {

    public static void main(String[] args) {
        final String DOWNLOADS_PATH = "C:\\Users\\mahaj\\Desktop\\229\\Day27-IO-JavaProgram\\src\\com\\IOprogram";

        Path path = Paths.get(DOWNLOADS_PATH + "\\Payroll_Service");

        // Checking file existence.
        boolean exists = Files.exists(path);
        System.out.println("File exists? : " + exists);

        if (exists) {
            try {
                Files.delete(path);
                System.out.println("File Deleted!");
                System.out.println("Check File Exist & Removed[true/false]? : " + Files.deleteIfExists(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Path dirPath = Paths.get(DOWNLOADS_PATH + "\\mydir");
        Path filePath = Paths.get(DOWNLOADS_PATH + "\\myfile.txt");
        try {
            System.out.println("Created Directory: " + Files.createDirectory(dirPath));
            System.out.println("Created File: " + Files.createFile(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Path dirDownloads = Paths.get(DOWNLOADS_PATH);

        try (Stream<Path> list = Files.list(dirDownloads)) {
            System.out.println("Listing files and directories from: " + dirDownloads);
            for (Path location :
                    list.toList()) {
                System.out.println(location);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
