package com.example.ReadCSV.controller;

import com.example.ReadCSV.pojo.ZipCode;
import com.example.ReadCSV.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SampleController
{
    private SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }
    @PostMapping("/publishCsv")
    public ResponseEntity<?> readCsv(@RequestParam("file") MultipartFile file)
    {
        if (file.isEmpty())
        {
            return ResponseEntity.badRequest().body("please select a file");
        }
        try {
           List<ZipCode>zipCodes= sampleService.readCSVfile(file.getInputStream());
           return ResponseEntity.ok(zipCodes);
        }catch (IOException ex)
        {
                 return ResponseEntity.internalServerError()
                         .body("Failed to process CSV File: "+ex.getMessage());
        }

    }
}
