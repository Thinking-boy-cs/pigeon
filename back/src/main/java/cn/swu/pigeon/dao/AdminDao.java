package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    User findById(String id);
}
