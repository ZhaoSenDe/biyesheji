package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.SubjectEntity;
import com.study.vo.SubjectVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface SubjectService extends IService<SubjectEntity> {

    Map<String, Object> queryPage(SubjectVo subjectVo);

    List<HashMap> queryList(SubjectVo subjectVo);

    Map<String, Object> findPage(SubjectVo subjectVo);
}

