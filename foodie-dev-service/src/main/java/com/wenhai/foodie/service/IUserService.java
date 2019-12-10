package com.wenhai.foodie.service;

import com.wenhai.pojo.Users;
import com.wenhai.pojo.bo.UserBO;

/**
*@Author:谢文海
*@Description: 用户接口
*@Date:2019/12/5_0:03
*/
public interface IUserService {
    /**
     * 判断用户是否存在
     * @param username 用户名
     * @return
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 新增用户
     * @param userBo
     * @return
     */
    Users createUser(UserBO userBo);

    /**
     *  to login
     * @return
     */
    Users login(UserBO userBo);
}
