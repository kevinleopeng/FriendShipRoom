package com.fsr.domain;

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
public class Renter implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Integer type;
    private String name;
    private Integer sex;
    private Integer age;
    private Long phoneNum;
    private Long otherPhoneNum;
    private Long roomId;
    private Long homeId;
    private String roomAddress;
    private String homeAddress;
    private String workAddress;
    private String workCompany;
    private Long companyNum;
    private String industry;
    private String renterPics;
}
