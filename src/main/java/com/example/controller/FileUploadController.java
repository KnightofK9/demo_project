package com.example.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping(value="/file/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/file/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                String filePath="C:\\demo_project\\demo_project\\src\\main\\files";
                String imgPath="C:\\demo_project\\demo_project\\src\\main\\files\\img";
                String videoPath="C:\\demo_project\\demo_project\\src\\main\\files\\video";
                String path = filePath;
                String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
                if(fileExt.compareTo("img")==0||fileExt.compareTo("jpg")==0||fileExt.compareTo("png")==0)
                {
                    path = imgPath;
                }
                else if(fileExt.compareTo("mkv")==0||fileExt.compareTo("mp4")==0||fileExt.compareTo("wmv")==0)
                {
                    path = videoPath;
                }

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + file.getOriginalFilename() )));
                stream.write(bytes);
                stream.close();

                return "You successfully uploaded " + file.getOriginalFilename() + "!";
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
        }
    }


}