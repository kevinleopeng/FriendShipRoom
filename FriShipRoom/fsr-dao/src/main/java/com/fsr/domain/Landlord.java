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
public class Landlord implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private String name;
    private String address;
    private Integer sex;
    private Integer age;
    private Long phoneNum;
    private Long otherPhoneNum;
    private String bankAccount;
    private String bank;
    private String bankAccountName;
    private String landlordPics;
}
