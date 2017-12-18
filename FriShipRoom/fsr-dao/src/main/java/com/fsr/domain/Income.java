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
public class Income implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private Integer type;
    private Integer actualProj;
    private Double price;
    private Integer count;
    private Double fiscalCharge;
    private String userName;
    private Date time;
    private String certificate;
    private String description;
    private Long homeId;
}
