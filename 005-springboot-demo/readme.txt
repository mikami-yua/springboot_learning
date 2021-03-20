1.首页配置
    所有页面的静态资源都需要thymeleaf接管
    h:src="@{/img/bootstrap-solid.svg}"

2.页面国际化
    1.需要配置i18n文件
    2.需要在项目中自动按钮切换，需要自定义一个国际化组件
    3.把组件注册到spring容器中（bean）
    4.使用