package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.InfoCollect;

import java.util.Date;
import java.util.List;

public interface InfoCollectService {
    //查看当前用户的信息收集事项
    List<InfoCollect> findInfoCollect(Date theTime);
    //提交信息收集
    void submitInfoCollect(InfoCollect infoCollect);
}
