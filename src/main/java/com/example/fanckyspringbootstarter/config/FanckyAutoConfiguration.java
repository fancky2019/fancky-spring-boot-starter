package com.example.fanckyspringbootstarter.config;

import com.example.fanckyspringbootstarter.service.ToolService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 1、pom引入相关依赖，定义字段配置文件类
 2、定义自动配置类：启用配置属性加入IOC、starter业务类通过bean加入IOC
 3、添加spring.factories文件配置自动装配
 4、pom配置无main类启动 install到本地仓库
 5、其他工程引入依赖，并配置配置项


 SpringApplication.run()
 ├── 1. 准备环境
 ├── 2. 创建 ApplicationContext
 ├── 3. 刷新上下文 (refreshContext)
 │   ├── 3.1 解析配置类 (parse)
 │   │   ├── 处理 @Import 注解
 │   │   │   ├── 发现 @Import(AutoConfigurationImportSelector.class)
 │   │   │   ├── 调用 selectImports() → 读取 spring.factories
 │   │   │   └── 返回配置类全限定名数组
 │   │   └── 注册配置类定义
 │   └── 3.2 实例化 Bean (finishBeanFactoryInitialization)
 │       └── 创建配置类中的 Bean
 └── 4. 启动完成

 1. 实例化 (Constructor)
 2. 依赖注入 (populateBean) - @Autowired
 3. 初始化前 (postProcessBeforeInitialization)
 4. 初始化方法 (invokeInitMethods)
 ├─ @PostConstruct
 ├─ afterPropertiesSet() ：InitializingBean 接口的方法。 在所有属性注入完成后执行
 └─ init-method  ： @Bean(initMethod = "customInit")
 5. 初始化后 (postProcessAfterInitialization) - AOP代理在此阶段创建
 6. Bean 准备就绪
 */



/**
 *
 * Spring Boot 2.x
 *
 * resources/META-INF/spring.factories
 *
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
 * com.xxx.FanckyAutoConfiguration
 * Spring Boot 3.x
 *
 * resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
 *
 * com.xxx.FanckyAutoConfiguration
 *
 *springboot3 @AutoConfiguration 代替2.0 的@Configuration
 *
 * Spring Boot 会自动加载所有依赖 jar 包里的 spring.factories（或 Boot3 的 AutoConfiguration.imports）文件。
 *
 *
 *
 *
 *
 *
 *
 *
 * @Configuration // 指定这个类是个配置类
 * @ConditionalOnXXX // 在指定条件成立的情况下自动配置类生效
 * @AutoConfigureOrder //配置类顺序
 * @AutoConfigureAfter // 在哪个配置类之后
 * @Bean //给容器中添加组件
 *
 * @ConfigurationProperties //结合相关的XXXProperties类 来绑定相关的配置
 * @EnableConfigurationProperties // 让XXXProperties加入到容器中，别人就可以自动装配
 *
 *
 *spring.factories ：要将此配置类加入自动配置项中。
 * 此配置类作用 ：starter的自动配置类
 * 1、@EnableConfigurationProperties({FanckyTest.class}) 将配置类加入IOC
 * 2、配置starter内的bean 加入IOC
 */
@Configuration
@EnableConfigurationProperties({FanckyTest.class})
public class FanckyAutoConfiguration {

    @Bean
   public ToolService toolService()
   {
       return new ToolService();
   }
}
