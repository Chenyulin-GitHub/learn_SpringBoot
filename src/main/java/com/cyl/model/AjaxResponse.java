package com.cyl.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

@ApiModel(value = "通用响应数据结构")
public class AjaxResponse {
    @ApiModelProperty(value = "是否请求成功")
    private boolean isok;
    private int code; //200 400 500  成功 前台错误  后台错误
    private String message;
    private Object data;

    public AjaxResponse (){};

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIsok(true);
        ajaxResponse.setMessage("理论上成功，无值");
        return ajaxResponse;
    }

    public  static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(obj);
        return  ajaxResponse;
    }

    public  static  AjaxResponse error(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(false);
        ajaxResponse.setCode(400);
        ajaxResponse.setMessage("前台错误");
        return  ajaxResponse;
    }

    public  static  AjaxResponse erroeBackstage(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(false);
        ajaxResponse.setCode(500);
        ajaxResponse.setMessage("后台错误");
        return  ajaxResponse;
    }
}
