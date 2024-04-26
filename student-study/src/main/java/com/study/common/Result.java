package com.study.common;

import java.util.List;
import java.util.Map;
// 定义一个通用的结果类，用于封装接口返回的结果数据和状态码
public class Result {
    // 定义常量，表示不同的状态码
    private static final int FAILRE_CODE = 504;// 失败状态码
    private static final int SUCCESS_CODE = 200;// 成功状态码
    private static final int OTHER_CODE = 250;// 其他状态码

    private Object resultData;// 结果数据
    private int code;// 状态码

    // 成功的静态工厂方法，返回一个成功的Result对象
    public static Result success(Object data){
        return new Result(data,SUCCESS_CODE);
    }

    // 失败的静态工厂方法，返回一个失败的Result对象
    public static Result failure(Object data){
        return new Result(data,FAILRE_CODE);
    }

    // 仅返回状态码的成功结果的静态工厂方法
    public static Result successCode(){
        return new Result(SUCCESS_CODE);
    }
    // 仅返回状态码的失败结果的静态工厂方法
    public static Result failureCode(){
        return new Result(FAILRE_CODE);
    }

    // 构造函数，接受结果数据和状态码
    public Result(Object resultData, int code) {
        this.resultData = resultData;
        this.code = code;
    }
    // 构造函数，接受状态码
    public Result(int code) {
        this.code = code;
    }
    // 获取结果数据
    public Object getResultData() {
        return resultData;
    }
    // 设置结果数据
    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
    // 获取状态码
    public int getCode() {
        return code;
    }
    // 设置状态码
    public void setCode(int code) {
        this.code = code;
    }
}
