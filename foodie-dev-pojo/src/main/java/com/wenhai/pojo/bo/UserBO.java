package com.wenhai.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
public class UserBO {
    @ApiModelProperty(value = "用户名",name="username",required = true,position = 2)
    @NotBlank(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码",name="password",required = true,position = 1)
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty(value = "确认密码",name="confirmPassword",required = false,position = 0)
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}
