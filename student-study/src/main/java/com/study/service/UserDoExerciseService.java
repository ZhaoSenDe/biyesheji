package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.UserDoExerciseEntity;
import com.study.vo.UserDoExerciseVo;

import java.util.Map;


public interface UserDoExerciseService extends IService<UserDoExerciseEntity> {


    Map<String, Object> queryPage(UserDoExerciseVo userDoExerciseVo);
}

