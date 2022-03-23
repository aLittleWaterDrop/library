## 个人博客

**基于springboot+jpa+semantic-ui**

``参考lrm老师课程``

### 一.简单使用

0.不提供数据库脚本,因为该项目自动建表

1.创建数据库blog,并设置好数据源

```xml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf-8
    username: root
    password: 123456
```

2.打开启动类 BlogApplication运行,jpa逆向工程会自动建表

3.使用Navicat或SQLyog连接好数据库,往表中插入用户,保存MD5(打开工具类)加密以后的密码

```java
 System.out.println(code("123456"));//e10adc3949ba59abbe56e057f20f883e
```

4.localhost:8080访问主页,localhost:8080/admin进入管理登录页

5.注意

​	a.部分页面的js库为cdn引入,需要在联网的情况下访问

​	b.`<!--/*/</th:block>/*/-->`这种注释在thymeleaf模板下生效,不能将其删除



### 二.主要功能

1.后台登录和注销的实现,欢迎页

2.博客管理(引入md编辑器插件)

3.标签和分类管理

4.博客首页展示

5.博客详情页(引入了多种插件,进行了文本美化,代码高亮显示)

6.评论功能

7.博客按分类和标签进行展示

8.全局搜索和归档
![image](https://user-images.githubusercontent.com/101373229/159655763-78d742ba-f0b8-42e6-af5d-84da8345b355.png)
