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
public class CellectRentDTO implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Integer type;
    private Long homeId;
    private String homeAddress;
    private Long roomId;
    private String roomAddress;
    private Long renterId;
    private String renterName;
    private Long landlordId;
    private String landlordName;
    private String payDateStr;
    private Integer countDown;
    private Integer overDue;
    private Long landlordPhoneNum;
    private Long renterPhoneNum;
    private String payStatus;
    private Date actualPayDate;
    private String messageStatus;
    private Integer amount;
}
