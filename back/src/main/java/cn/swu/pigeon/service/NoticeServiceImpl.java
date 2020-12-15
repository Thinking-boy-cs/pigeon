package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.NoticeDAO;
import cn.swu.pigeon.entity.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Transactional
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDAO noticeDAO;
    @Override
    public void addContent(Notice content) {
        noticeDAO.addContent(content);

    }

    @Override
    public List<Notice> queryContent() {
        return noticeDAO.queryContent();
    }
}
