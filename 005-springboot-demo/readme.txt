1.首页配置
    所有页面的静态资源都需要thymeleaf接管
    h:src="@{/img/bootstrap-solid.svg}"

2.页面国际化
    1.需要配置i18n文件
    2.需要在项目中自动按钮切换，需要自定义一个国际化组件
    3.把组件注册到spring容器中（bean）
    4.使用

3.添加拦截器
    拦截器必须implements HandlerInterceptor
    重写public boolean preHandle决定是否放行
    在controller中注册拦截器，重写 addInterceptors方法参数填自己创建的拦截器对象
