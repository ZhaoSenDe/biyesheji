package com.study.controller;

import java.util.Arrays;
import java.util.Map;


import com.study.common.Result;
import com.study.vo.AskQuestionsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.AskQuestionsEntity;
import com.study.service.AskQuestionsService;


/**
 * 提问控制器
 */
@RestController
@RequestMapping("study/askQuestions")
public class AskQuestionsController {
    @Autowired
    private AskQuestionsService askQuestionsService;

    /**
     * 查询列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody AskQuestionsVo askQuestionsVo) {
        // 计算分页起始位置
        askQuestionsVo.setPage((askQuestionsVo.getPage() - 1) * askQuestionsVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = askQuestionsService.queryPage(askQuestionsVo);
        return Result.success(page);
    }


    /**
     * 查询详情
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        // 根据id查询提问信息
        AskQuestionsEntity askQuestions = askQuestionsService.getById(id);
        return Result.success(askQuestions);
    }

    /**
     * 保存提问信息
     */
    @RequestMapping("/save")
    public Result save(@RequestBody AskQuestionsEntity askQuestions) {
        // 保存提问信息并返回结果
        boolean save = askQuestionsService.save(askQuestions);
        if (save) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 更新提问信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody AskQuestionsVo askQuestionsVo) {
        // 更新提问信息并返回结果
        AskQuestionsEntity askQuestionsEntity = new AskQuestionsEntity();
        askQuestionsEntity.setStatus(askQuestionsVo.getStatus());
        askQuestionsEntity.setId(askQuestionsVo.getId());
        askQuestionsEntity.setRestore(askQuestionsVo.getRestore());
        boolean b = askQuestionsService.updateById(askQuestionsEntity);
        if (b) {
            return Result.successCode();
        }
        return Result.failureCode();
    }


    /**
     * 删除提问信息
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody AskQuestionsEntity askQuestionsEntity) {
        // 根据id删除提问信息并返回结果
        boolean remove = askQuestionsService.removeById(askQuestionsEntity.getId());
        if (remove) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

}
