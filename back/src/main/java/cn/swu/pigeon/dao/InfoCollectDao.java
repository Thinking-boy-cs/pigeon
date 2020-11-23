package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.InfoCollect;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface InfoCollectDao {
    //查看当前的信息收集事项
    List<InfoCollect> findInfoCollect(Date theTime);
    //提交信息收集
    void submitInfoCollect(InfoCollect infoCollect);
}
