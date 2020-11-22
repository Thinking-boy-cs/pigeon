/*
 * @Date: 2020-11-22 03:08:50
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-22 03:36:47
 */
package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class RequestType {
    private User data;
    private String code;
}