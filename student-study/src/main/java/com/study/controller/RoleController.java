package com.study.controller;

import java.util.Arrays;
import java.util.Map;


import com.study.common.Result;
import com.study.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.RoleEntity;
import com.study.service.RoleService;


/**
 * 角色控制器
 */
@RestController
@RequestMapping("study/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 列表查询
     */
    @RequestMapping("/list")
    public Result list(@RequestBody  RoleVo roleVo) {
        // 计算分页起始位置
        roleVo.setPage((roleVo.getPage() - 1) * roleVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = roleService.queryPage(roleVo);
        return Result.success(page);
    }

    /**
     * 查询信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        // 根据id查询角色信息
        RoleEntity role = roleService.getById(id);
        return Result.success(role);
    }

    /**
     * 保存信息
     */
    @RequestMapping("/save")
    public Result save(@RequestBody RoleEntity role) {
        // 保存角色信息并返回结果
        boolean save = roleService.save(role);
        if (save){
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 修改信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody RoleEntity role) {
        // 修改角色信息并返回结果
        boolean b = roleService.updateById(role);
        if (b){
            return Result.successCode();
        }
        return Result.failureCode();
    }

    /**
     * 删除信息
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids) {
        // 根据id列表删除角色信息
        roleService.removeByIds(Arrays.asList(ids));
        return Result.successCode();
    }

}
