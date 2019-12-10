package com.wenhai.foodie.service;

import com.wenhai.pojo.Carousel;

import java.util.List;

/**
*@Author:谢文海
*@Description: 首页
*@Date:2019/12/9_22:20
*/
public interface ICarouselService {

    List<Carousel> queryAllCarousel(Integer isShow);
}
