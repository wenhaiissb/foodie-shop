package com.wenhai.mapper;

import com.wenhai.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryCustomMapper {

    List<CategoryVO> querySubCatsByFatherId(Integer fatherId);

    List querySixNewItemsByRootCatId(@Param("paramsMap") Map<String, Object> paramsMap);
}