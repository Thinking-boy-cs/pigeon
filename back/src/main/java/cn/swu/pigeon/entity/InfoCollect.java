package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Data
@Accessors(chain = true)
public class InfoCollect {
    private int id;
    private String colName;
    private String initiator;
    private String taker;
    private Date startTime;
    private Date endTime;
    private String info1;
    private String info2;
    private String info3;
    private String info4;
    private String info5;
    private String info6;
    private String info7;
    private String info8;
    private String info9;
    private String info11;
    private String info12;
    private String info13;
    private String info14;
    private String info15;
    private String info16;
    private String info17;
    private String info18;
    private String info19;
    private String info20;
}
