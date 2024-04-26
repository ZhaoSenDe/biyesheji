package com.study.controller;

import java.util.Arrays;
import java.util.Map;


import com.study.common.Result;
import com.study.vo.ExercisesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.ExercisesEntity;
import com.study.service.ExercisesService;





/**
 * 练习控制器
 */
@RestController
@RequestMapping("study/exercises")
public class ExercisesController {
    @Autowired
    private ExercisesService exercisesService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public Result list(@RequestBody  ExercisesVo exercisesVo){
        // 计算分页起始位置
        exercisesVo.setPage((exercisesVo.getPage() - 1) * exercisesVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = exercisesService.queryPage(exercisesVo);
        return Result.success(page);
    }

    /**
     * 查询未做练习列表
     */
    @RequestMapping("/findNotDoExercises")
    public Result findNotDoExercises(@RequestBody  ExercisesVo exercisesVo){
        // 计算分页起始位置
        exercisesVo.setPage((exercisesVo.getPage() - 1) * exercisesVo.getPageSize());
        // 查询未做练习列表并返回结果
        Map<String, Object> page = exercisesService.findNotDoExercises(exercisesVo);
        return Result.success(page);
    }


    /**
     * 查询信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        // 根据id查询练习信息
        ExercisesEntity exercises = exercisesService.getById(id);
        return Result.success(exercises);
    }

    /**
     * 保存信息
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ExercisesEntity exercises){
        // 保存练习信息并返回结果
        boolean save = exercisesService.save(exercises);
        if (save){
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 修改信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ExercisesEntity exercises){
        // 修改练习信息并返回结果
        boolean b = exercisesService.updateById(exercises);
        if (b){
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 删除信息
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody ExercisesEntity exercises){
        // 根据id删除练习信息并返回结果
        boolean remove = exercisesService.removeById(exercises.getId());
        if (remove){
            return  Result.successCode();
        }
        return  Result.failureCode();
    }

}
