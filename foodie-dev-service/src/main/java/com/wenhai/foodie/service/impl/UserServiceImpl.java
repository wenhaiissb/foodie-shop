package com.wenhai.foodie.service.impl;

import com.wenhai.foodie.enums.Sex;
import com.wenhai.foodie.service.IUserService;
import com.wenhai.foodie.util.DateUtil;
import com.wenhai.foodie.util.MD5Utils;
import com.wenhai.mapper.UsersMapper;
import com.wenhai.pojo.Users;
import com.wenhai.pojo.bo.UserBO;
import lombok.RequiredArgsConstructor;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
*@Author:谢文海
*@Description: 用户service 实现
*@Date:2019/12/5_0:05
*/
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements IUserService {

    private final Sid sid;

    private final UsersMapper usersMapper;

    /**
     * 判断用户是否存在
     *
     * @param username 用户名
     * @return
     */
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users == null ? false : true;
    }

    @Override
    public Users createUser(UserBO userBo) {
        Users user = new Users();
        user.setUsername(userBo.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setFace("//////");
        user.setNickname(userBo.getUsername());
        user.setSex(Sex.SECRECY.type);
        user.setId(sid.nextShort());
        user.setBirthday(DateUtil.stringToDate("1970-01-01"));
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    /**
     * to login
     * @return
     */
    @Override
    public Users login(UserBO userBo) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", userBo.getUsername());
        try {
            criteria.andEqualTo("password", MD5Utils.getMD5Str(userBo.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersMapper.selectOneByExample(userExample);
    }
}
