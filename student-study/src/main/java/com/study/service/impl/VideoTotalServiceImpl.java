package com.study.service.impl;

import com.study.vo.LoginVo;
import com.study.vo.VideoTotalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



import com.study.dao.VideoTotalDao;
import com.study.entity.VideoTotalEntity;
import com.study.service.VideoTotalService;


@Service("videoTotalService")
public class VideoTotalServiceImpl extends ServiceImpl<VideoTotalDao, VideoTotalEntity> implements VideoTotalService {

    @Autowired
    private VideoTotalDao videoTotalDao;

    @Override
    public Map<String, Object> queryPage(VideoTotalVo videoTotalVo) {
        Integer total = videoTotalDao.queryCount(videoTotalVo);
        List<HashMap> data = videoTotalDao.queryData(videoTotalVo);
        Map<String, Object> result = new HashMap<>();
        result.put("total",total);
        result.put("data",data);
        return result;
    }

}