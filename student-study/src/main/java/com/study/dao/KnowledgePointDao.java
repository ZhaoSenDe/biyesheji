package com.study.dao;

import com.study.entity.KnowledgePointEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.KnowledgePointVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface KnowledgePointDao extends BaseMapper<KnowledgePointEntity> {

    Integer queryCount(KnowledgePointVo knowledgePointVo);

    List<HashMap> queryData(KnowledgePointVo knowledgePointVo);
}
