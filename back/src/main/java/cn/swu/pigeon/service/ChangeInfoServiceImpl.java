package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.ChangeInfoDAO;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.utils.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class ChangeInfoServiceImpl implements ChangeInfoService{

    @Resource
    ChangeInfoDAO changeInfoDAO;

    HttpServletRequest request;
    //String path = request.getServletPath();
    //public static final String UPLOAD_DIR = httpServletRequest.getServletPath()+"../../../resources/static/photos";
//    public static final String UPLOAD_DIR = "../../../resources/static/photos";
    //public static final String UPLOAD_DIR = request.getServletContext().getRealPath("/photos");
    public static final String UPLOAD_DIR = "./back/src//main/resources/static/photos";

    private UploadUtils uploadUtils = new UploadUtils();


    @Override
    public void changeUserInfo(MultipartFile multipartFile,User user) {
        String newPath = uploadUtils.upload(UPLOAD_DIR,multipartFile);
        System.out.println(newPath);
        //System.out.println(path);
        user.setIcon(newPath);
        try {
            changeInfoDAO.changeInfo(user);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
