package cn.swu.pigeon.entity;

<<<<<<< HEAD
import java.util.Date;


=======
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
>>>>>>> ysw-dev
public class Activity {
    private int id;
    private String activityName;
    private String applicant;
    private String approver;
    private Date startTime;
    private Date endTime;
    private String status;
    private Date submitTime;
<<<<<<< HEAD
=======

>>>>>>> ysw-dev
}
