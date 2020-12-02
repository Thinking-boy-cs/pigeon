package cn.swu.pigeon.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {

    public static String getUuid(int length){
        length = (length>32)?32:length;
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,length);
    }

}
