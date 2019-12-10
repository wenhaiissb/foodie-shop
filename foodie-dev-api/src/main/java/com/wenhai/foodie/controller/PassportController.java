package com.wenhai.foodie.controller;

import com.wenhai.foodie.enums.Sex;
import com.wenhai.foodie.service.IUserService;
import com.wenhai.foodie.util.CookieUtils;
import com.wenhai.foodie.util.JsonUtils;
import com.wenhai.foodie.util.Result;
import com.wenhai.pojo.Users;
import com.wenhai.pojo.bo.UserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Api(tags = "认证模块")
@RestController
@Validated
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "用户名验证",notes = "验证用户名是否存在",httpMethod = "GET",response = Result.class,
    produces = "application/json")
    @GetMapping("/usernameIsExist")
    public Result queryUsernameIsExist(@RequestParam @NotBlank(message = "用户名不能为null")@ApiParam(name = "username",
            value = "用户名",required = true,example = "wenhai") String username) {
        boolean result = userService.queryUsernameIsExist(username);
        if (!result) {
            return Result.ok();
        }
        return Result.errorMsg("用户已存在");
    }

    @ApiOperation(value = "用户注册",notes="用户注册接口",httpMethod = "POST",response = Result.class)
    @PostMapping("/register")
    public Result register(@Validated @RequestBody UserBO userBO) {
        if (!userBO.getConfirmPassword().equals(userBO.getPassword())) {
            return Result.errorMsg("两次输入密码不一致");
        }
        boolean existResult = userService.queryUsernameIsExist(userBO.getUsername());
        if (existResult) {
            return Result.errorMsg("用户名已存在");
        }
        userService.createUser(userBO);
        return Result.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public Result login(@RequestBody UserBO userBO, HttpServletRequest request,HttpServletResponse response) {
        Users user = userService.login(userBO);
        user.setPassword(null);
        user.setNickname(null);
        user.setBirthday(null);
        user.setRealname(null);
        user.setSex(Sex.SECRECY.type);
        user.setMobile(null);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user),true);
        if (Objects.isNull(user)) {
            return Result.errorMsg("用户或者密码输入错误");
        }
        return Result.ok(user);
    }

    @ApiOperation(value = "用户退出", notes = "用户退出接口", httpMethod = "POST")
    @PostMapping
    public Result logout(@NotBlank(message = "用户不能为空") String userId,HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");
        return Result.ok();
    }
}
