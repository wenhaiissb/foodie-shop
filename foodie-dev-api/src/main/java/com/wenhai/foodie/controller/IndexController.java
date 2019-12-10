package com.wenhai.foodie.controller;

import com.wenhai.foodie.enums.YesOrNo;
import com.wenhai.foodie.service.ICarouselService;
import com.wenhai.foodie.service.ICategoryService;
import com.wenhai.foodie.util.Result;
import com.wenhai.pojo.Carousel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Api(tags = "首页接口")
@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private ICarouselService carouselService;

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value="首页轮播图展示",notes = "首页轮播图展示接口",httpMethod = "GET")
    @GetMapping("/carousel")
    public Result  listAllCarousel(){
        List<Carousel> carousels = carouselService.queryAllCarousel(YesOrNo.Yes.type);
        return Result.ok(carousels);
    }

    @ApiOperation(value = "首页根分类", notes = "首页根分类接口", httpMethod = "GET")
    @GetMapping("/cats")
    public Result queryAllRootLevelCats(){
        return Result.ok(categoryService.queryAllRootLevelCats());
    }

    @ApiOperation(value = "查询子分类", notes = "根据父分类id查询子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public Result querySubCats(@ApiParam(name = "rootCatId",value = "父分类id",required = true)
                                   @PathVariable("rootCatId") @NotBlank(message = "父分类id不能为空") Integer rootCatId) {
        return Result.ok(categoryService.querySubCatsByFatherId(rootCatId));
    }
    @ApiOperation(value = "查询主分类最新6个子分类", notes = "查询主分类最新6个子分类", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public Result querySixNewItems(@ApiParam(name = "rootCatId",value = "父分类id",required = true)
                                   @PathVariable("rootCatId") @NotBlank(message = "父分类id不能为空") Integer rootCatId) {
        return Result.ok(categoryService.querySixNewItems(rootCatId));
    }
}
