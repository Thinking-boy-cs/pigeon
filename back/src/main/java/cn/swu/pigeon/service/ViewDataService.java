package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.StatisticsCount;

public interface ViewDataService {
    //统计各个部门的人数
    StatisticsCount viewDeptNumber(String companyId);
}
