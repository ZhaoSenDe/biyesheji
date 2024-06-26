package com.study.dao;

import com.study.entity.HomeworkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.vo.HomeworkVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface HomeworkDao extends BaseMapper<HomeworkEntity> {

    Integer queryCount(HomeworkVo homeworkVo);

    List<HashMap> queryData(HomeworkVo homeworkVo);

    List<HashMap> findNotDoHomeworkData(HomeworkVo homeworkVo);

    Integer findNotDoHomeworkCount(HomeworkVo homeworkVo);
}
