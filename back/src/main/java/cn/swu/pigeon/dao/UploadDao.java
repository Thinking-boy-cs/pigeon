package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Upload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadDao {
    //上传的文件
    void upload(Upload upload);
    //用户查看上传的文件
    List<Upload> findFile(String userId);
}
