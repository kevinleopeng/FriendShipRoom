package com.fsr.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Xiaoyue Xiao
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private String roomType;
    private Long homeId;
    private String roomAddress;
    private String emptyStatus;
    private Integer emptyDays;
    private String actualArea;
    private String hasBalcony;
    private String hasBathRoom;
}
