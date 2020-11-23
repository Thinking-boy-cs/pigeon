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
import java.util.List;
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

    /**
     *文件上传
     */
    @RequestMapping("uploadFile")
    public Result uploadFile(MultipartFile multipartFile, Upload upload,HttpServletRequest request){
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try{
            if (multipartFile.isEmpty()){
                log.info("here");
                return Result.error();
            }
            upload.setUsername(thisUser.getId());
            log.info("here:[{}]",upload);
            int rows =uploadService.saveFile(multipartFile,upload);
            System.out.println(rows);

            return Result.success(upload);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Result.error();
    }

    /**
     * 上传文件的查看
     */
    @RequestMapping("findFile")
    public Map<String, Object> findFile(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {

            //得到广播变量
            User thisUser = (User)request.getSession().getAttribute("thisUser");
            List<Upload> thisUploads =  uploadService.findFile(thisUser.getId());

            map.put("status",0);
            map.put("msg","查看成功!");
            map.put("data",thisUploads);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", e.getMessage());
            map.put("data", null);
        }
        return map;
    }


}
