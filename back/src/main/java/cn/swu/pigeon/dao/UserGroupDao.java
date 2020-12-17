package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGroupDao {
    void addUserGroup(UserGroup userGroup);
}
