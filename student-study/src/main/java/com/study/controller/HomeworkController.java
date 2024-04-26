package com.study.controller;

import java.sql.Wrapper;
import java.util.*;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.common.Result;
import com.study.entity.UserClassEntity;
import com.study.entity.UserDoHomeworkEntity;
import com.study.service.UserClassService;
import com.study.service.UserDoHomeworkService;
import com.study.vo.HomeworkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.HomeworkEntity;
import com.study.service.HomeworkService;


/**
 * 作业控制器
 */
@RestController
@RequestMapping("study/homework")
public class HomeworkController {

    @Autowired
    private UserClassService userClassService;

    @Autowired
    private UserDoHomeworkService userDoHomeworkService;

    @Autowired
    private HomeworkService homeworkService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public Result list(@RequestBody HomeworkVo homeworkVo) {
        // 计算分页起始位置
        homeworkVo.setPage((homeworkVo.getPage() - 1) * homeworkVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = homeworkService.queryPage(homeworkVo);
        return Result.success(page);
    }


    /**
     * 查询未做作业列表
     */
    @RequestMapping("/findNotDoHomework")
    public Result findNotDoHomework(@RequestBody HomeworkVo homeworkVo) {
        // 计算分页起始位置
        homeworkVo.setPage((homeworkVo.getPage() - 1) * homeworkVo.getPageSize());
        // 查询未做作业列表并返回结果
        Map<String, Object> page = homeworkService.findNotDoHomework(homeworkVo);
        return Result.success(page);
    }

    /**
     * 查询信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        // 根据id查询作业信息
        HomeworkEntity homework = homeworkService.getById(id);
        return Result.success(homework);
    }

    /**
     * 保存信息
     */
    @RequestMapping("/save")
    public Result save(@RequestBody HomeworkEntity homework) {
        // 保存作业信息并返回结果
        boolean save = homeworkService.save(homework);
        if (save) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 修改信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody HomeworkEntity homework) {
        // 修改作业信息并返回结果
        boolean b = homeworkService.updateById(homework);
        if (b) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 删除信息
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody HomeworkEntity homework) {
        // 根据id删除作业信息
        boolean b = homeworkService.removeById(homework.getId());
        if (b){
            // 删除对应作业的用户作业信息
            QueryWrapper<UserDoHomeworkEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("homework_id",homework.getId());
            boolean remove = userDoHomeworkService.remove(queryWrapper);
            return Result.successCode();
        }
        return Result.failureCode();
    }

}
