package com.study.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.common.Result;
import com.study.vo.RoleVo;
import com.study.vo.SubjectVo;
import com.study.vo.VideoTotalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.study.entity.SubjectEntity;
import com.study.service.SubjectService;


/**
 * 科目控制器
 */
@RestController
@RequestMapping("study/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public Result list(@RequestBody SubjectVo subjectVo){
        // 计算分页起始位置
        subjectVo.setPage((subjectVo.getPage() - 1) * subjectVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = subjectService.queryPage(subjectVo);
        return Result.success(page);
    }

    /**
     * 分页查询
     */
    @RequestMapping("/findPage")
    public Result findPage(@RequestBody SubjectVo subjectVo){
        // 计算分页起始位置
        subjectVo.setPage((subjectVo.getPage() - 1) * subjectVo.getPageSize());
        // 分页查询并返回结果
        Map<String, Object> page = subjectService.findPage(subjectVo);
        return Result.success(page);
    }

    /**
     * 列表查询
     */
    @RequestMapping("/queryList")
    public Result queryList(@RequestBody SubjectVo SubjectVo) {
        // 查询列表并返回结果
        List<HashMap> page = subjectService.queryList(SubjectVo);
        return Result.success(page);
    }

    /**
     * 列表查询
     */
    @GetMapping("/findList")
    public Result findList() {
        // 查询列表并返回结果
        List<SubjectEntity> list = subjectService.list();
        return Result.success(list);
    }


    /**
     * 查询信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        // 根据id查询科目信息
        SubjectEntity subject = subjectService.getById(id);
        return Result.success(subject);
    }

    /**
     * 保存信息
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SubjectEntity subject){
        // 保存科目信息并返回结果
        boolean save = subjectService.save(subject);
        if (save) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 修改信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SubjectEntity subject){
        // 修改科目信息并返回结果
        boolean update = subjectService.updateById(subject);
        if (update) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 删除信息
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody SubjectEntity subjectEntity){
        // 根据id删除科目信息
        boolean b = subjectService.removeById(subjectEntity.getId());
        if (b) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

}
