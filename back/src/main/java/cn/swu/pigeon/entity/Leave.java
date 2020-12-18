package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Leave {

    private int id;
    private String reason;
    private String userId;
    private String approveUser;
    private Date startTime;
    private Date endTime;
    private String state;
    private Date submitTime;
    private String companyId;
}
