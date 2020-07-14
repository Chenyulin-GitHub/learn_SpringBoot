package com.cyl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Data //get+set方法
@Slf4j  //日志
@Builder //Builder 赋值  User user=User.builder().id(1).name('张三').builder();
@AllArgsConstructor //全参
@NoArgsConstructor //无参
public class User {
    //private static  final Logger log = LoggerFactory.getLogger(User.class);  //日志 现在直接用注释@slf4j代替

    private Integer id;
    private String name;

}
