package com.study.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.common.Result;
import com.study.vo.UserClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.UserClassEntity;
import com.study.service.UserClassService;


/**
 * 用户班级控制器
 */
@RestController
@RequestMapping("study/userClass")
public class UserClassController {
    @Autowired
    private UserClassService userClassService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public Result list(@RequestBody  UserClassVo userClassVo) {
        // 计算分页起始位置
        userClassVo.setPage((userClassVo.getPage() - 1) * userClassVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = userClassService.queryPage(userClassVo);
        return Result.success(page);
    }

    /**
     * 列表查询
     */
    @RequestMapping("/findList")
    public Result findList(@RequestBody  UserClassVo userClassVo) {
        // 查询列表并返回结果
        List<HashMap> data = userClassService.findList(userClassVo);
        return Result.success(data);
    }


    /**
     * 查询信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        // 根据id查询用户班级信息
        UserClassEntity userClass = userClassService.getById(id);
        return Result.success(userClass);
    }

    /**
     * 保存信息
     */
    @RequestMapping("/save")
    public Result save(@RequestBody UserClassEntity userClass) {
        // 保存用户班级信息并返回结果
        boolean save = userClassService.save(userClass);
        if (save){
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 修改信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody UserClassEntity userClass) {
        // 修改用户班级信息并返回结果
        boolean b = userClassService.updateById(userClass);
        if (b){
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 删除信息
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody UserClassEntity userClass) {
        // 根据用户ID删除用户班级信息
        QueryWrapper<UserClassEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userClass.getUserId());
        boolean remove = userClassService.remove(queryWrapper);
        if (remove){
            return Result.successCode();
        }
        return Result.failureCode();
    }

}
