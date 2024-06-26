package com.study.dao;

import com.study.entity.VideosEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.VideosVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface VideosDao extends BaseMapper<VideosEntity> {

    Integer queryCount(VideosVo videosVo);

    List<HashMap> queryData(VideosVo videosVo);
}
