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
public class Message implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;
    private String message;
    private Date addTime;
    private Date modifyTime;
}
