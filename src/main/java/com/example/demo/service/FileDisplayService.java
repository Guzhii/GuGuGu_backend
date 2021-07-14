package com.example.demo.service;

import com.example.demo.exception.FileStorageException;
import com.example.demo.property.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

@Service
public class FileDisplayService {

    private final Path fileStorageLocation;

    @Autowired
    public FileDisplayService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public List<String> getAllFiles() {
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        String pathName = this.fileStorageLocation.toString();
        File f = new File(pathName);

        // Populates the array with names of files and directories
        List<String> fileNames;
        String[] fileNamesTmp = f.list();
        fileNames = Arrays.asList(fileNamesTmp);

        return fileNames;
    }
}
