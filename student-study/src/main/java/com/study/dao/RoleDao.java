package com.study.dao;

import com.study.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface RoleDao extends BaseMapper<RoleEntity> {

    Integer queryCount(RoleVo roleVo);

    List<HashMap> queryData(RoleVo roleVo);
}
