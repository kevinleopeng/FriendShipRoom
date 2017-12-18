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
public class StatusResult implements Serializable {

    private static final long serialVersionUID = 6191745064790884707L;

    private String code; // Current page number
    private String message; // Number of total pages
    private Object data; // Paginated resources

}
