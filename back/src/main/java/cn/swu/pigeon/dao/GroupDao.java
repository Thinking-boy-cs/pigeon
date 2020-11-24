package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Group;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {
    //根据userId找到相应用户的groupId
    List<String> findGroupId(String userId);
    //根据userId找到相应用户的对象
    List<Group> findGroupObject(String userId);

    //根据groupId找到对应的用户对象
    List<User> findUserByGroupId(String groupId);
}
