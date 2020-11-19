package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Upload {

    private int id;
    private String username;
    private String imgPath;

}
