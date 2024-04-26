package com.study.dao;

import com.study.entity.UserDoHomeworkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.UserDoHomeworkVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserDoHomeworkDao extends BaseMapper<UserDoHomeworkEntity> {

    Integer queryCount(UserDoHomeworkVo userDoHomeworkVo);

    List<HashMap> queryData(UserDoHomeworkVo userDoHomeworkVo);
}
