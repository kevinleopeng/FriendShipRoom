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
public class Contract implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Long landlordId;
    private String landlordName;
    private Long renterId;
    private String renterName;
    private Integer type;
    private Long homeId;
    private String homeAddress;
    private Long roomId;
    private String roomAddress;
    private Integer  deposit;
    private Integer rental;
    private Integer payMode;
    private Integer isIncrement;
    private Integer whichYear;
    private Integer incrementPercent;
    private Date rentStartTime;
    private Date rentEndTime;
    private Integer freeRentDays;
    private Date signDate;
    private String rentContract;
    private Date nextPayDate;
    private Long landlordPhoneNum;
    private Long renterPhoneNum;
}
