package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.UserSubjectEntity;
import com.study.vo.UserSubjectVo;

import java.util.Map;

public interface UserSubjectService extends IService<UserSubjectEntity> {

    Map<String, Object> queryPage(UserSubjectVo userSubjectVo);
}

