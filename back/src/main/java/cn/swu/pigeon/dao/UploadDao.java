package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Upload;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadDao {
    //上传的文件
    void upload(Upload upload);
}
