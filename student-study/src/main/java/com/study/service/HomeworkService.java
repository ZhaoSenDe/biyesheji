package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.HomeworkEntity;
import com.study.vo.HomeworkVo;

import java.util.Map;

public interface HomeworkService extends IService<HomeworkEntity> {


    Map<String, Object> queryPage(HomeworkVo homeworkVo);

    Map<String, Object> findNotDoHomework(HomeworkVo homeworkVo);
}

