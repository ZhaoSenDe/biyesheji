package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.AskQuestionsEntity;
import com.study.vo.AskQuestionsVo;

import java.util.Map;


public interface AskQuestionsService extends IService<AskQuestionsEntity> {

    Map<String, Object> queryPage(AskQuestionsVo askQuestionsVo);
}

