## 图书管理系统

**基于springboot+mybatisPlus+semantic-ui**

### 一.简单使用

1.创建数据库blog,并设置好数据源

```xml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql:///library?useSSL=false
    username: root
    password: 123456
```

2.运行数据库脚本 library.sql

3.打开启动类 LibraryApplication运行

4.localhost:8080访问主页,localhost:8080/manager进入管理登录页



### 二.主要功能

1.管理员登录,及修改密码

2.图书管理,分类管理,用户管理,管理员管理

3.用户登录,及修改密码

4.图书首页展示,图书按库存展示,图书按分类展示

5.图书搜索,图书分页

6.用户借阅,逾期提醒

7.考虑了特殊情况保证系统的稳定性,比如删除用户可以查看其借阅,且未归还不能删除


### 三.示例图片

用户管理页面
  
![image](https://user-images.githubusercontent.com/101373229/159661400-1717219f-a434-42aa-ae42-0615a715e092.png)

图书借阅页面

![image](https://user-images.githubusercontent.com/101373229/159661569-9c198cb7-a663-4eb5-99e7-34a437e37047.png)


