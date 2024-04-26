package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.study.entity.VideosEntity;
import com.study.vo.VideosVo;

import java.util.Map;


public interface VideosService extends IService<VideosEntity> {


    Map<String, Object> queryPage(VideosVo videosVo);
}

