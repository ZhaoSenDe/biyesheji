package com.study.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.common.Result;
import com.study.entity.UserClassEntity;
import com.study.service.UserClassService;
import com.study.vo.ApplicantVo;
import com.study.vo.AskQuestionsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.ApplicantEntity;
import com.study.service.ApplicantService;


//申请人控制器
@RestController
@RequestMapping("study/applicant")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;


    @Autowired
    private UserClassService userClassService;

    //列表查询
    @RequestMapping("/list")
    public Result list(@RequestBody ApplicantVo applicantVo) {
        // 计算分页起始位置
        applicantVo.setPage((applicantVo.getPage() - 1) * applicantVo.getPageSize());
        // 查询并返回结果
        Map<String, Object> page = applicantService.queryPage(applicantVo);
        return Result.success(page);
    }

    //查询用户是否已加入班级
    @RequestMapping("/joinTrueOrFalse")
    public Result joinTrueOrFalse(@RequestBody ApplicantVo applicantVo) {
        // 查询用户是否已经加入班级
        QueryWrapper<UserClassEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", applicantVo.getUserId());
        List<UserClassEntity> list = userClassService.list(queryWrapper);
        // 查询用户是否已提交申请
        List<ApplicantEntity> list1 = applicantService.list(new QueryWrapper<ApplicantEntity>().
                eq("user_id", applicantVo.getUserId())
                .eq("status", 1));
        // 如果用户已经加入班级或已提交申请，返回true；否则返回false
        return Result.success((list.size() + list1.size()) != 0);
    }

    //查询申请人信息
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        // 根据id查询申请人信息
        ApplicantEntity applicant = applicantService.getById(id);
        return Result.success(applicant);
    }

    //保存申请人信息
    @RequestMapping("/save")
    public Result save(@RequestBody ApplicantEntity applicant) {
        // 保存申请人信息并返回结果
        boolean save = applicantService.save(applicant);
        if (save) {
            return Result.successCode();
        }
        return Result.failureCode();
    }

    //更新申请人信息
    @RequestMapping("/update")
    public Result update(@RequestBody ApplicantVo applicantVo) {
        // 更新申请人状态
        ApplicantEntity applicantEntity = new ApplicantEntity();
        applicantEntity.setStatus(applicantVo.getStatus());
        applicantEntity.setId(applicantVo.getId());
        boolean b = applicantService.updateById(applicantEntity);
        if (b) {
            // 如果状态为通过（2），则将用户加入班级
            if (applicantVo.getStatus() == 2) {
                QueryWrapper<UserClassEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("user_id", applicantVo.getUserId());
                List<UserClassEntity> list = userClassService.list(queryWrapper);
                // 判断用户是否已经加入班级
                if (list.size() > 0) {
                    return Result.failure("该学生已经加入了班级");
                }
                // 添加用户到班级
                UserClassEntity userClassEntity = new UserClassEntity();
                userClassEntity.setClassId(applicantVo.getClassId());
                userClassEntity.setUserId(applicantVo.getUserId());
                userClassService.save(userClassEntity);
            }
            return Result.successCode();
        }
        return Result.failureCode();
    }

    //删除申请人信息
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids) {
        // 根据id批量删除申请人信息
        applicantService.removeByIds(Arrays.asList(ids));
        return Result.successCode();
    }

}
