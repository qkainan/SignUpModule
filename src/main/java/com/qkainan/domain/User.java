package com.qkainan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //根据属性生成set，get方法
@NoArgsConstructor //生成空参构造
@AllArgsConstructor //生成全参构造
public class User {

    private int id;
    private String username;
    private String password;
    private String hobby;

}
