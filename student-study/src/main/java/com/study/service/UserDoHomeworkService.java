package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.UserDoHomeworkEntity;
import com.study.vo.UserDoHomeworkVo;

import java.util.Map;


public interface UserDoHomeworkService extends IService<UserDoHomeworkEntity> {


    Map<String, Object> queryPage(UserDoHomeworkVo userDoHomeworkVo);
}

