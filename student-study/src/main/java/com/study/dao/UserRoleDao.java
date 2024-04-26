package com.study.dao;

import com.study.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.UserRoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserRoleDao extends BaseMapper<UserRoleEntity> {

    Integer queryCount(UserRoleVo userRoleVo);

    List<HashMap> queryData(UserRoleVo userRoleVo);
}
