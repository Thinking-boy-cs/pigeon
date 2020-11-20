package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.ChangeInfoDAO;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
@Transactional
public class ChangeInfoServiceImpl implements ChangeInfoService{

    @Resource
    ChangeInfoDAO changeInfoDAO;

    public static final String UPLOAD_DIR = "webapp\\upload";

    private UploadUtils uploadUtils = new UploadUtils();


    @Override
    public void changeUserInfo(MultipartFile multipartFile,User user) {
        String newPath = uploadUtils.upload(UPLOAD_DIR,multipartFile);
        System.out.println(newPath);
        user.setIcon(newPath);
        try {
            changeInfoDAO.changeInfo(user);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
