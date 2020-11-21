package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Leave {

    private int id;
    private String leaveReason;
    private String userId;
    private String approve;
    private Date startTime;
    private Date endTime;
    private String status;
    private Date submitTime;
}
