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
public class Expense implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Integer type;
    private Integer actualProj;
    private Double price;
    private Integer count;
    private Double total;
    private Double fiscalCharge;
    private Double surplus;
    private String userName;
    private Date time;
    private Integer isAdvancePay;
    private String advancePerson;
    private Double advanceAmount;
    private Integer settlementStatus;
    private String certificate;
    private String description;
    private Long homeId;
}
