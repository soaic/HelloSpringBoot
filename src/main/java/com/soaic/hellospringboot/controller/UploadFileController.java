package com.soaic.hellospringboot.controller;


import com.soaic.hellospringboot.common.ResponseResult;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/upload")
@Api(description = "上传文件")
public class UploadFileController {

    @RequestMapping(value = "/file", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public ResponseResult<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        try {
            String filePath = "/Users/soaic/"+multipartFile.getOriginalFilename();
            FileUtils.writeByteArrayToFile(new File(filePath), multipartFile.getBytes());
            return new ResponseResult<>(200, "upload success" , filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(501, "upload failure", e.getMessage());
        }
    }

    @RequestMapping(value = "/batchFile", method = RequestMethod.POST)
    public ResponseResult<String> uploadFiles(HttpServletRequest request) {
        try {
            String content = request.getParameter("content");
            System.out.println("content=" + content);
            //获取上传的文件数组
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            for (MultipartFile file:files) {
                FileUtils.writeByteArrayToFile(new File("/Users/soaic/"+file.getOriginalFilename()), file.getBytes());
            }
            return new ResponseResult<>(200, "upload success",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(501, "upload failure", e.getMessage());
        }
    }
}
