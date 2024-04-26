package com.study.dao;

import com.study.entity.UserDoExerciseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.UserDoExerciseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserDoExerciseDao extends BaseMapper<UserDoExerciseEntity> {

    Integer queryCount(UserDoExerciseVo userDoExerciseVo);

    List<HashMap> queryData(UserDoExerciseVo userDoExerciseVo);
}
