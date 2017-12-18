package com.fsr.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by Hasee on 2017/7/24.
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TemplateVO {
    private String address;
    private Double amount;
    private String month;
    private String day;
}
