package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.UserClassEntity;
import com.study.vo.UserClassVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface UserClassService extends IService<UserClassEntity> {


    Map<String, Object> queryPage(UserClassVo userClassVo);

    List<UserClassEntity> selectByClassId(Integer classId);

    List<HashMap> findList(UserClassVo userClassVo);
}

