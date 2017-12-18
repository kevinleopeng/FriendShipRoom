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
public class IncomeDTO implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private String incomeType;
    private String incomeActualProj;
    private Double price;
    private Integer count;
    private Double fiscalCharge;
    private String userName;
    private String incomeTime;
    private String certificate;
    private String description;
    private String homeAddress;
}
