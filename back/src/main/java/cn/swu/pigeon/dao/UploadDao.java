package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Upload;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadDao {
    void upload(Upload upload);
}
