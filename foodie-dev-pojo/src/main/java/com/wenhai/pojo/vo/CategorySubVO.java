package com.wenhai.pojo.vo;

import lombok.Data;

@Data
public class CategorySubVO {
    private Integer subId;
    private String subName;
    private Integer subType;
    private Integer subFatherId;
}
