package cn.swu.pigeon.controller;

import cn.swu.pigeon.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("redis")
    public Object getRedis(){
        redisUtil.set("r","aaaaaa");
        return redisUtil.get("r");
    }

}