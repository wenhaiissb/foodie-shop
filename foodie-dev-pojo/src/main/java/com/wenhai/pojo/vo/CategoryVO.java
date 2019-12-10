package com.wenhai.pojo.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private Integer type;
    private Integer fatherId;
    private List<CategorySubVO> subCatList;
}
