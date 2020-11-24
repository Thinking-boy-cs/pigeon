package cn.swu.pigeon.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {
    List<String> findGroupId(String id);
}
