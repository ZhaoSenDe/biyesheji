package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.ClassEntity;
import com.study.vo.ClassVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ClassService extends IService<ClassEntity> {

    Map<String, Object> queryPage(ClassVo classVo);

    List<HashMap> findList(ClassVo classVo);
}

