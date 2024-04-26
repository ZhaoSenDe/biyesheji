package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.RoleEntity;
import com.study.vo.RoleVo;

import java.util.Map;


public interface RoleService extends IService<RoleEntity> {


    Map<String, Object> queryPage(RoleVo roleVo);
}

