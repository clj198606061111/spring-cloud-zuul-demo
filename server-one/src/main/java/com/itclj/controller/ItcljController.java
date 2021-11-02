package com.itclj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/itclj")
public class ItcljController {

    private Logger logger = LoggerFactory.getLogger(ItcljController.class);

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id) {
        return "Id is " + id;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws UnsupportedEncodingException {
        String fileName = file.getOriginalFilename();
        logger.info(new String(fileName.getBytes(),"UTF-8"));
        String filePath = "/itclj/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功,filename={}", fileName);
            return "上传成功";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }
}
