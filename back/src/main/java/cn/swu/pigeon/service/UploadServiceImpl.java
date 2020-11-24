package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.UploadDao;
import cn.swu.pigeon.entity.Upload;
import cn.swu.pigeon.utils.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
@Slf4j
public class UploadServiceImpl implements UploadService {

    private static final String UPLOAD_DIR= "webapp\\upload";
    //不建议用new UploadUtils，因为要低耦合，建议把UploadUtils类的upload方法换成静态的方法
    private UploadUtils uploadUtils = new UploadUtils();
    @Resource
    UploadDao uploadDao;

    //存上传的文件
    @Override
    public int saveFile(MultipartFile multipartFile, Upload upload) {
        String newPath = uploadUtils.upload(UPLOAD_DIR, multipartFile);
        System.out.println("UploadServiceImpl" + newPath);
        //设置存到数据库的img路径
        upload.setImgPath(newPath);
        log.info("此时的图片路径[{}]",upload.getImgPath());
        uploadDao.upload(upload);
        try {
//            bookDao.addBook(book);

            uploadDao.upload(upload);
            return 1; //添加数据库成功
        }catch (Exception e){
            e.printStackTrace();
            return -1; //添加数据库失败
        }
    }

    @Override
    public List<Upload> findFile(String userId) {
        return uploadDao.findFile(userId);
    }
}
