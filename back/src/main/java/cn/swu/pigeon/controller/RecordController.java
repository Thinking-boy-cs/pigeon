package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     * 处理签到
     */
    @PostMapping("sign")
    public boolean sign(@RequestBody Record record){
        if(!ObjectUtils.isEmpty(record)){
            recordService.isSign(record);
            return true;
        }
        return false;
    }
}
