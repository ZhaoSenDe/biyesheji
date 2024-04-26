package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.KnowledgePointEntity;
import com.study.vo.KnowledgePointVo;

import java.util.Map;


public interface KnowledgePointService extends IService<KnowledgePointEntity> {

    Map<String, Object> queryPage(KnowledgePointVo knowledgePointVo);
}

