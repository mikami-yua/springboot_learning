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

松散绑定：
    类中的属性名和配置文件中的写的属性名不同，依然可以成功赋值

JSR303校验：
    @Validated //数据校验
    加到类上面，类中的属性可以使用多种标签（@email等，可以进行email格式的校验）
        如果不是邮箱的格式会报错
        @Email（massge=“邮箱格式错误”）

配置文件的路径：
    项目下新件一个config文件，里面可以存放配置文件
    在项目的根目录下也可以写配置文件
    类路径下（src）的config

    优先级：
        项目路径下的config》项目下的配置文件》resource下的config》resource下单配置文件
        默认的是优先级最低的路径

    多环境切换使用配置文件覆盖的方式
        application-test.properties
        application-dev.properties
        指定配置文件的方法
            在application.properties中配置
                spring.profiles.active=dev/test

    yaml可以实现多文档模块
        spring:
          profiles:
            active: lisi lisi不写就加载zhangsan模块

配置文件能写什么
    以httpEncodingAutoConfiguration为例子（）

        //表示这是一个配置类，都会被spring接管配置
        @Configuration(
            proxyBeanMethods = false
        )
        //自动配置属性：ServerProperties
        @EnableConfigurationProperties({ServerProperties.class})
        //ConditionalOn spring的底层注解：根据不同的条件判断当前配置或者类是否生效
        @ConditionalOnWebApplication(
            type = Type.SERVLET
        )
        @ConditionalOnClass({CharacterEncodingFilter.class})
        @ConditionalOnProperty(
            prefix = "server.servlet.encoding",
            value = {"enabled"},
            matchIfMissing = true
        )

        public class HttpEncodingAutoConfiguration {
            private final Encoding properties;

            public HttpEncodingAutoConfiguration(ServerProperties properties) {
                this.properties = properties.getServlet().getEncoding();
            }

            @Bean
            @ConditionalOnMissingBean
            public CharacterEncodingFilter characterEncodingFilter() {
                CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
                filter.setEncoding(this.properties.getCharset().name());
                filter.setForceRequestEncoding(this.properties.shouldForce(org.springframework.boot.web.servlet.server.Encoding.Type.REQUEST));
                filter.setForceResponseEncoding(this.properties.shouldForce(org.springframework.boot.web.servlet.server.Encoding.Type.RESPONSE));
                return filter;
            }

            @Bean
            public HttpEncodingAutoConfiguration.LocaleCharsetMappingsCustomizer localeCharsetMappingsCustomizer() {
                return new HttpEncodingAutoConfiguration.LocaleCharsetMappingsCustomizer(this.properties);
            }

            static class LocaleCharsetMappingsCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, Ordered {
                private final Encoding properties;

                LocaleCharsetMappingsCustomizer(Encoding properties) {
                    this.properties = properties;
                }

                public void customize(ConfigurableServletWebServerFactory factory) {
                    if (this.properties.getMapping() != null) {
                        factory.setLocaleCharsetMappings(this.properties.getMapping());
                    }

                }

                public int getOrder() {
                    return 0;
                }
            }
        }
    配置文件中能配的，一定是自动配置jar包下的，spring工厂的配置文件中
        由xxxAutoConfiguration自动装配：默认值（给容器添加组件）
            其中的xxxxxproperties和配置文件绑定，就可以使用自定义配置了（封装配置文件中的相关属性）
   【spring帮开发者自动装配，自动装配由默认值，从xxxxxproperties取默认值，如果想要修该默认值，只需要按照默认的规则，在配置文件中配即可】

   通过debug=true可以判断哪些自动配置类生效了哪些没有生效