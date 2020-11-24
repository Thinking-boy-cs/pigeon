package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Company;
import cn.swu.pigeon.entity.Group;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface GroupService {
    List<String> findGroupId(String userId);

    //根据userId找到相应用户的对象
    List<Group> findGroupObject(String userId);

    //根据groupId找到对应的用户对象
    List<User> findUserByGroupId(String groupId);

    //添加企业字段
    void addCompany(Company company);
    //添加group字段
    void addGroup(Group group);

    //void addUser_group()
}
