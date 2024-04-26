package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.ApplicantEntity;
import com.study.vo.ApplicantVo;

import java.util.Map;


public interface ApplicantService extends IService<ApplicantEntity> {

    Map<String, Object> queryPage(ApplicantVo applicantVo);
}

