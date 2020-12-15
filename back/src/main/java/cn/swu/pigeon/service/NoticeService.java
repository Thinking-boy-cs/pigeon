package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Notice;

import java.util.List;

public interface NoticeService {

    void addContent(Notice content);

    List<Notice> queryContent();
}
