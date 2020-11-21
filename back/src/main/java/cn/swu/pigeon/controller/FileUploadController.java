package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Upload;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.UploadService;
import cn.swu.pigeon.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//import static java.lang.System.currentTimeMillis;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("upload")   
@Slf4j

public class FileUploadController {
    @Resource
    private UploadService uploadService;

    @RequestMapping("uploadFile")
    public Result uploadFile(MultipartFile multipartFile, Upload upload,HttpServletRequest request){
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try{
            if (multipartFile.isEmpty()){
                return Result.error();
            }
            upload.setUsername(thisUser.getUsername());
            int rows =uploadService.saveFile(multipartFile,upload);
            System.out.println(rows);

            return Result.success(rows);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
