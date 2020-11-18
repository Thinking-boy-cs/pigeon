package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.UploadDao;
import cn.swu.pigeon.entity.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UploadServiceImpl implements UploadService {

    @Autowired
    UploadDao uploadDao;
    @Override
    public void saveFile(Upload upload) {

        uploadDao.upload(upload);
    }
}
