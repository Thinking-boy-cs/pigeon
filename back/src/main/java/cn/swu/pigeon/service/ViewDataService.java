package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.StatisticsCount;

import java.util.Date;
import java.util.List;

public interface ViewDataService {
    //统计各个部门的人数
    List<StatisticsCount> viewDeptNumber(String companyId);
    //统计公司男女人数情况
    List<StatisticsCount> viewSexNumber(String companyId);
    //统计员工的家乡
    List<StatisticsCount> viewHometownNumber(String companyId);
    //统计员工的薪资情况
    List<Float> viewSalaryNumber(String companyId);
    //统计员工在离职情况
    List<StatisticsCount> viewStatusNumber(String companyId, String time1,String time2);
}
