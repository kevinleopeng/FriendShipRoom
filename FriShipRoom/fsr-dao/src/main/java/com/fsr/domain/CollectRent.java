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
public class CollectRent implements Serializable {

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
    private Date payDate;
    private Integer countDown;
    private Integer overDue;
    private Long renterPhoneNum;
    private Long landlordPhoneNum;
    private Integer isPay;
    private Date actualPayDate;
    private Integer status;
    private Integer amount;
}
