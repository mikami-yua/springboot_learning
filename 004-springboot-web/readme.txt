什么是webjars
    1.在springboot中可以采用以下放式处理静态资源
        -webjars 这下面放的映射到localhost：8080/webjars
        -public，static，resources，根目录。这下面放的映射到localhost：8080/
    2.优先级
        resource>static>public

模板引擎
Thymeleaf
    写在templates下面

    只要需要使用Thymeleaf，只需要导入对应的依赖即可。将html页面放在templates目录下即可

    基本语法
