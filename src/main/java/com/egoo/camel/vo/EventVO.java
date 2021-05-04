package com.egoo.camel.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author mash
 * @date 2021/4/22
 */
@Data
@NoArgsConstructor
public class EventVO implements Serializable {
    private String engine = "rabbit";
    private Long cusId;
    private Long shareId;
    private String tenantId;
    private Date operateTime;
    private String eventCode;
    private Map<String, String> data;
}
