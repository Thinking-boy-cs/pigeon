package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.StatisticsCount;

import java.util.List;

public interface ViewDataService {
    //统计各个部门的人数
    List<StatisticsCount> viewDeptNumber(String companyId);
    //统计公司男女人数情况
    List<StatisticsCount> viewSexNumber(String companyId);
}
