package com.wenhai.foodie.service;

import com.wenhai.pojo.Category;
import com.wenhai.pojo.vo.CategoryVO;

import java.util.List;

/**
*@Author:谢文海
*@Description: 分类
*@Date:2019/12/9_23:22
*/
public interface ICategoryService {
    /**
     *
     * @return the root cats
     */
    List<Category> queryAllRootLevelCats();

    /**
     *
     * @param rootCatId father id
     * @return the Sub Cats by fatherId
     */
    List<CategoryVO> querySubCatsByFatherId(Integer rootCatId);

    List querySixNewItems(Integer rootCatId);
}
