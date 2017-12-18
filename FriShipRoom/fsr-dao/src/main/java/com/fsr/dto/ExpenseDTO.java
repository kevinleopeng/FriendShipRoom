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
public class ExpenseDTO implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private String payType;
    private String payActualProj;
    private Double price;
    private Integer count;
    private Double total;
    private Double fiscalCharge;
    private Double surplus;
    private String userName;
    private String payTime;
    private String advancePayStatus;
    private String advancePerson;
    private Double advanceAmount;
    private String settledStatus;
    private String certificate;
    private String description;
    private String homeAddress;
}
