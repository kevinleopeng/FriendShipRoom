package com.fsr.dto;

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
public class ContractDTO implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Long landlordId;
    private String landlordName;
    private Long renterId;
    private String renterName;
    private String contractType;
    private Long homeId;
    private String homeAddress;
    private Long roomId;
    private String roomAddress;
    private Integer  deposit;
    private Integer rental;
    private String contractPayMode;
    private String isContractIncrement;
    private Integer whichYear;
    private Integer incrementPercent;
    private String contractRentStartTime;
    private String contractRentEndTime;
    private Integer freeRentDays;
    private String contractSignDate;
    private String rentContract;
    private String contractNextPayDate;
    private Long landlordPhoneNum;
    private Long renterPhoneNum;
}
