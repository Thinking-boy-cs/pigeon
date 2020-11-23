package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    //用户上传文件
    int saveFile(MultipartFile multipartFile, Upload upload);
    //用户查看自己上传的文件
    List<Upload> findFile(String userId);
}
