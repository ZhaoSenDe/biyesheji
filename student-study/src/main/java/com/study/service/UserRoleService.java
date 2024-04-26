package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.UserRoleEntity;
import com.study.vo.UserRoleVo;

import java.util.Map;


public interface UserRoleService extends IService<UserRoleEntity> {


    Map<String, Object> queryPage(UserRoleVo userRoleVo);
}

