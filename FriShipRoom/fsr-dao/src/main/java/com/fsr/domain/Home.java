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
public class Home implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Long landlordId;
    private String landlordName;
    private Long landlordPhoneNum;
    private String area;
    private String village;
    private String address;
    private Integer status;
    private String structure;
    private String propertyArea;
    private String actualArea;
    private Integer livingRoomBalcony;
    private Integer lifeBalcony;
    private String electricalAppliances;
    private String furnitureAppliances;
    private String bathroomAppliances;
    private String wifiAppliances;
    private String kitchenAppliances;
    private String homePics;
}
