package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDAO {

    void addContent(Notice notice);

    List<Notice>queryContent();


}
