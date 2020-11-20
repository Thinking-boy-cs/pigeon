package cn.swu.pigeon.entity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@Accessors(chain = true)
public class Record {
    private String id;
    private float temperature;
    private String nation;
    private String province;
    private String city;
    private Date signTime;
}
