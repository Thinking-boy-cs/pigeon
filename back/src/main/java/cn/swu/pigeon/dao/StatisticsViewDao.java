package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.StatisticsCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsViewDao {
    //统计各个部门的人数
    List<StatisticsCount> dept_userNumber(String company);
    //统计公司男女人数情况
    List<StatisticsCount> sex_userNumber(String company);
}
