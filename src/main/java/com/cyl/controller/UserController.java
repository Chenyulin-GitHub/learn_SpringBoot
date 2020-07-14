package com.cyl.controller;

import com.cyl.model.AjaxResponse;
import com.cyl.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/User")
public class UserController {

    @GetMapping("/getuser")
    public String getUser(String name){
        return "你好呀："+name;
    }

    //查询
    //@RequestMapping(value = "/Users/{id}",method = RequestMethod.GET)
    @GetMapping("/Users/{id}")
    public AjaxResponse getUser(@PathVariable("id") Integer id){  //PathVariable解析ID
        User user = User.builder()
                .id(1)
                .name("张三")
                .build();
        log.info("User:"+user);
        return AjaxResponse.success(user);
    }

    //新增
    @RequestMapping(value = "/Users",method = RequestMethod.POST)
    public AjaxResponse saveUser(@RequestBody User user) {

        log.info("saveUser:"+user);
        return AjaxResponse.success();
    }

    //修改
    @RequestMapping(value = "/Users",method = RequestMethod.PUT)
    public AjaxResponse updateUser(@RequestBody User user) {
        if( user.getId() == null){
            return AjaxResponse.error();
        }
        log.info("updateUser:"+user);
        return AjaxResponse.success();
    }
    //删除
    @RequestMapping(value = "/Users/{id}",method = RequestMethod.DELETE)
    public AjaxResponse deleteUser(@PathVariable Integer id) {
        log.info("deleteUser:"+id);
        return AjaxResponse.success();
    }

}
