package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface ChangeInfoService {
    //修改用户个人信息
    void  changeUserInfo(MultipartFile multipartFile,User user);
}
