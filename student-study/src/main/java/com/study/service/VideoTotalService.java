package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.VideoTotalEntity;
import com.study.vo.LoginVo;
import com.study.vo.VideoTotalVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface VideoTotalService extends IService<VideoTotalEntity> {

    Map<String, Object> queryPage(VideoTotalVo videoTotalVo);

}

