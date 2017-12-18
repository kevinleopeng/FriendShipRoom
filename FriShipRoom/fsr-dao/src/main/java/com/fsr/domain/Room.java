package com.fsr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Xiaoyue Xiao
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Room implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Integer order;
    private Long homeId;
    private String roomAddress;
    private Integer isEmpty;
    private Integer emptyDays;
    private String actualArea;
    private Integer roomClass;
    private Integer isBalcony;
    private Integer isBathRoom;
    private String electricalAppliances;
    private String furnitureAppliances;
    private String bathroomAppliances;
    private String wifiAppliances;
    private String roomPics;
}
