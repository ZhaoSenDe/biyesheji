package com.study.dao;

import com.study.entity.SubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.SubjectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SubjectDao extends BaseMapper<SubjectEntity> {

    Integer queryCount(SubjectVo subjectVo);

    List<HashMap> queryData(SubjectVo subjectVo);

    List<HashMap> queryList(SubjectVo subjectVo);

    Integer findPageCount(SubjectVo subjectVo);

    List<HashMap> findPageData(SubjectVo subjectVo);
}
