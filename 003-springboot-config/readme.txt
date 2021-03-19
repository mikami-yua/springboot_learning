springboot这个配置文件中可以配置哪些东西呢
官方的配置太多了，了解原理
官方不推荐properties，推荐使用ymal方式（xml使用key=value）

yaml
    key value(以空格分割)
    可以存数组，对象，键值对
    yaml对空格要求极高

    可以注入都配置类中，可以直接给实体类赋值

    '''yaml例子
    server:
      port: 8081 #普通的key value

    #还可以存放对象
    student:
      name: zhangsan
      age: 12

    #行内写法
    student2: {name: lisi,age: 25}

    #数组写法
    pets:
      - cat
      - dog
      - pig
    #行内写法
    dogs: [wang,kk,rule]
    '''


@Component:
    作用把类添加到spring组件中,可以被扫描到

Person和dog都是实体类，原来spring的赋值方式，使用@value。测试方法，在测试类中，因为已经标记了@Component，可以自动注入。声明一个类的成员，在成员上面标记-
@Autowired即可自动装配.Dog{name='旺财', age=3}注入成功
    每个类都这样赋值太复杂了，使用yaml快速赋值
    yaml中定义了一个person的值,使用@ConfigurationProperties标签
        @ConfigurationProperties(prefix = "person")