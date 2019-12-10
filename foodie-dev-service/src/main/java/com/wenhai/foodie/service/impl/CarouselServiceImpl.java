package com.wenhai.foodie.service.impl;

import com.wenhai.foodie.service.ICarouselService;
import com.wenhai.mapper.CarouselMapper;
import com.wenhai.pojo.Carousel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarouselServiceImpl implements ICarouselService {

    private final CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAllCarousel(Integer isShow) {
        Example carouselExample = new Example(Carousel.class);
        carouselExample.orderBy("sort").desc();
        Example.Criteria carouselCriteria = carouselExample.createCriteria();
        carouselCriteria.andEqualTo("isShow", isShow);
        return carouselMapper.selectByExample(carouselExample);
    }
}
