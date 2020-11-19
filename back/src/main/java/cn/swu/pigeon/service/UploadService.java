package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Upload;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    int saveFile(MultipartFile multipartFile, Upload upload);
}
