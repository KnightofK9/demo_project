package com.example.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.example.service.FileService;
import com.example.util.DemoConstant;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    private FileService fileService;
    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value="/file/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/file/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){

        int code = fileService.uploadFile(file);
        if(code == DemoConstant.OK)
        {
            return "You successfully to upload "+file.getOriginalFilename();
        }
        if(code == DemoConstant.FAILED)
        {
            return "You failed to upload "+file.getOriginalFilename();
        }
        if(code == DemoConstant.FILEEMTY)
        {
            return "You failed to upload "+file.getOriginalFilename()+" . File were emty";
        }
        return "Unknown error";
    }



}