package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RecordDAO {
    void record(Record record);
    List<Record> find(String userId);
}
