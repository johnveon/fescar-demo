package com.example.fescardemo.common.web;

import lombok.Data;

@Data
public class BaseResult<T> {

    private Integer code;
    private String desc;
    private T data;

    public BaseResult(Integer code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }


    public static <T> BaseResult<T> success(T data){
        return new BaseResult<T>(2000, "成功", data);
    }

    public static <T> BaseResult<T> success(String desc){
        return new BaseResult<T>(4000, desc, null);
    }



}
