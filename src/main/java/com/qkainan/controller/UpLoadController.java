package com.qkainan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UpLoadController {


        @RequestMapping("/upload")
        public String upload(MultipartFile uploadFile) throws IOException {
            //文件存储 把上传上来的文件存储下来
            uploadFile.transferTo(new File("test.sql"));
            return "/success.jsp";
        }

}
