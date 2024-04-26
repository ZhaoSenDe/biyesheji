package com.study.dao;

import com.study.entity.ClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.ClassVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface ClassDao extends BaseMapper<ClassEntity> {

    Integer queryCount(ClassVo classVo);

    List<HashMap> queryData(ClassVo classVo);

    List<HashMap> findList(ClassVo classVo);
}
