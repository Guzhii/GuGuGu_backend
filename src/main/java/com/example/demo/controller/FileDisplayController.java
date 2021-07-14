package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.service.FileDisplayService;
import com.example.demo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class FileDisplayController {
    @Autowired
    private FileDisplayService fileDisplayService;

    @GetMapping("/listFiles")
    public Response<List<String>> listFiles() {
        // Load file as Resource
        return new Response<>(fileDisplayService.getAllFiles());
    }

    @GetMapping("/listFilesInfo")
    public Response<List<String>> listFilesInfo() {
        // Load file as Resource
        return new Response<>(fileDisplayService.getAllFiles());
    }
}
