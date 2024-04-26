package com.study.dao;

import com.study.entity.AskQuestionsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.AskQuestionsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;



@Mapper
public interface AskQuestionsDao extends BaseMapper<AskQuestionsEntity> {

    Integer queryCount(AskQuestionsVo askQuestionsVo);

    List<HashMap> queryData(AskQuestionsVo askQuestionsVo);
	
}
