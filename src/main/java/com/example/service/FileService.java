package com.example.service;

/**
 * Created by Knight of k9 on 23/11/2015.
 */

import com.example.model.FileObject;
import com.example.model.ImgObject;
import com.example.model.VidObject;
import com.example.repository.FileRepository;
import com.example.repository.ImgRepository;
import com.example.repository.VidRepository;
import com.example.util.DemoConstant;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class FileService
{
    FileRepository fileRepository;
    ImgRepository imgRepository;
    VidRepository vidRepository;
    @Autowired
    public FileService(FileRepository fileRepository, ImgRepository imgRepository, VidRepository vidRepository) {
        this.fileRepository = fileRepository;
        this.imgRepository = imgRepository;
        this.vidRepository = vidRepository;
    }

    public int uploadFile(MultipartFile file)
    {
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
                    imgRepository.save(new ImgObject(path+"\\"+file.getOriginalFilename()));
                }
                else if(fileExt.compareTo("mkv")==0||fileExt.compareTo("mp4")==0||fileExt.compareTo("wmv")==0)
                {
                    path = videoPath;
                    vidRepository.save(new VidObject(path+"\\"+file.getOriginalFilename()));
                }
                else
                {
                    fileRepository.save(new FileObject(path+"\\"+file.getOriginalFilename()));
                }
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + file.getOriginalFilename() )));
                stream.write(bytes);
                stream.close();

                return DemoConstant.OK;
            } catch (Exception e) {
                return DemoConstant.FAILED;
            }
        } else {
            return DemoConstant.FILEEMTY;
        }
    }
}
