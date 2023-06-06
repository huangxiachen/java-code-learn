package com.chx.controller;

import com.chx.vo.ImageVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {

    @RequestMapping("pic/upload")
    public ImageVo file(MultipartFile fileImage) throws IOException {
        String originalFilename = fileImage.getOriginalFilename();
        File file = new File("c:/testFile");
        if (!file.exists()){
            file.mkdir();
        }
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File imgFile = new File("c:/testFile/" + fileName);
        try {
            fileImage.transferTo(imgFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedImage read = ImageIO.read(fileImage.getInputStream());

        ImageVo imageVo = new ImageVo(0,"http://localhost:8080/img/" + fileName,read.getWidth(),read.getHeight());
        return imageVo;
    }
}
