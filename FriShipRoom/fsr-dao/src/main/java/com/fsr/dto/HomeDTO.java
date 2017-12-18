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
public class HomeDTO implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Long landlordId;
    private String landlordName;
    private Long landlordPhoneNum;
    private String area;
    private String village;
    private String address;
    private String homeStatus;
    private String structure;
    private String propertyArea;
    private String actualArea;
    private String isLivingRoomBalcony;
    private String isLifeBalcony;
    private String electricalAppliances;
    private String furnitureAppliances;
    private String bathroomAppliances;
    private String wifiAppliances;
    private String kitchenAppliances;
    private String homePics;
}
