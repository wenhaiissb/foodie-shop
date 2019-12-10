package com.wenhai.foodie.service.impl;

import com.wenhai.foodie.service.ICategoryService;
import com.wenhai.mapper.CategoryCustomMapper;
import com.wenhai.mapper.CategoryMapper;
import com.wenhai.pojo.Category;
import com.wenhai.pojo.vo.CategoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryCustomMapper categoryMapperCustom;
    @Override
    public List<Category> queryAllRootLevelCats() {
        Example categoryExample = new Example(Category.class);
        Example.Criteria categoryCriteria = categoryExample.createCriteria();
        categoryCriteria.andEqualTo("fatherId", 0);
        return categoryMapper.selectByExample(categoryExample);
    }

    /**
     * @param rootCatId father id
     * @return the Sub Cats by fatherId
     */
    @Override
    public List<CategoryVO> querySubCatsByFatherId(Integer rootCatId) {
        return categoryMapperCustom.querySubCatsByFatherId(rootCatId);
    }

    @Override
    public List querySixNewItems(Integer rootCatId) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("rootCatId", rootCatId);
        return categoryMapperCustom.querySixNewItemsByRootCatId(paramsMap);
    }

}
