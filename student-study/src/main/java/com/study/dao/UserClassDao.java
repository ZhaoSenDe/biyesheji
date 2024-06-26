package com.study.dao;

import com.study.entity.UserClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.UserClassVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;



@Mapper
public interface UserClassDao extends BaseMapper<UserClassEntity> {

    Integer queryCount(UserClassVo userClassVo);

    List<HashMap> queryData(UserClassVo userClassVo);

    List<UserClassEntity> selectByClassId(Integer classId);

    List<HashMap> findList(UserClassVo userClassVo);
}
