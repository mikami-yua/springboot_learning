springboot
自动装配
    pom.xml
        spring-boot-dependencies：核心依赖在父工程中
        在写或者引入一些springboot依赖的是皇后不需要指定版本，因为有这些版本仓库
        启动器：说白了使springboot的启动场景
        spring-boot-starter-web会帮我们自动导入web环境的所有依赖
        springboot会把所有的功能场景都变成一个个的启动器
        如果要使用什么功能著需要引入启动器即可

    主程序
        @SpringBootApplication标注这个类是一个springboot的应用
        @SpringBootConfiguration springboot的配置
        @EnableAutoConfiguration 自动配置
            里面有自动配置包，导入选择器

        自动装配原理分析:
            在主程序入口上面有个@SpringBootApplication注解（标注这个类是一个springboot的应用）
                @SpringBootApplication下有
                    @SpringBootConfiguration springboot的配置
                        @Configuration
                            @Component
                    @EnableAutoConfiguration 自动导入包配置
                        @AutoConfigurationPackage
                            @Import({Registrar.class}) 自动注册包
                        @Import({AutoConfigurationImportSelector.class}) 自动导入包的核心
                            导入AutoConfigurationImportSelector 自动导入选择器
                                getAutoConfigurationEntry（）获得自动配置实体
                                getCandidateConfigurations（）获取候选的配置
                                    标注了EnableAutoConfiguration这个注解
                                    loadFactoryNames获取所有的加载配置
                                        获取的资源：系统资源+项目和资源
                                            项目资源从“META-INF/spring.factories”中获取
                                        遍历之后封装成一个properties供给使用
                        【总之：核心导入包就走了一个文件“META-INF/spring.factories”】
                        加载了这些自动配置类并没有完全生效，需要导入相关的start才能生效！
                    @ComponentScan：扫描当前主启动类同级的包，扫描到的包在：@Import({Registrar.class}) 自动注册包

            【结论】：springboot中所有的自动配置都在启动类中被扫描被加载，扫描了一个“META-INF/spring.factories”，所有的自动配置类都在这里
                导入对应的start就会生效

                1。在启动时在“META-INF/spring.factories”下获取指定的值
                2.将自动配置的类导入容器，自动配置类就会生效
                3.以前需要手动配置的，springboot帮外面做了
                4.整合javaee，解决方案和自动配置都在spring-boot-autpconfiure
                5.会把所有需要导入的组件，以类名的方式返回，这些组件就会被添加到容器
                6.xxxAutoConfigure的文件，就是这些类容器中导入这个场景所需要的组件，并自动配置
                7.有了自动配置类就省去了我们手动编写配置文件的操作。

        启动：
            SpringApplication.run(Application.class, args);
            SpringApplication作用：
                1.推断这个类是普通的web项目
                2.查找并加载所有可用初始化器，设置到initializers属性中
                3.找出所有的应用程序监听器，设置到initializers属性中
                4.推断并设置main方法的定义类，找到运行的主类

        springboot的理解
            1.自动装配
            2.run方法
                1.推断这个类是普通的web项目
                2.查找并加载所有可用初始化器，设置到initializers属性中
                3.找出所有的应用程序监听器，设置到initializers属性中
                4.推断并设置main方法的定义类，找到运行的主类

