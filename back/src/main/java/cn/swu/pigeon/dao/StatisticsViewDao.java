package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.StatisticsCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StatisticsViewDao {
    //统计各个部门的人数
    List<StatisticsCount> dept_userNumber(String companyId);
    //统计公司男女人数情况
    List<StatisticsCount> sex_userNumber(String companyId);
    //统计员工的家乡
    List<StatisticsCount> hometown_userNumber(String companyId);
    //统计员工的薪资情况
    List<StatisticsCount> salary_userNumber(String companyId);
    //统计员工在离职情况
    List<StatisticsCount> status_userNumber(@Param("companyId") String companyId, @Param("time") String time);
}
