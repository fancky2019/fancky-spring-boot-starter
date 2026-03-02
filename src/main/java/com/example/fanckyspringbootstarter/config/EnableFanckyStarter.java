package com.example.fanckyspringbootstarter.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 *
 * Spring Boot Starter 主要作用是简化项目的依赖管理和配置。
 *
 * springboot:@SpringBootApplication
 * -->@EnableAutoConfiguration
 * -->@Import({AutoConfigurationImportSelector.class}) 3. AutoConfigurationImportSelector 读取 spring.factories
 *
 *
 * 手动开启型 starter
 *
 * starter 两种方式：2比较灵活，写在启动类上可以控制是否启动。官方推荐方法1
 * 1、spring.factories 配置自动配置项。引入jar 依赖即可自动装配
 * 2、@EnableFanckyStarter写在启动类上可以控制是否启动：@Import实现 ImportSelector 的selectImports方法，方法内添加自动配置类全路径。
 *
 *
 * package：该命令完成了项目编译、单元测试、打包功能三个过程。
 * install：在 package 命令的前提下新增一个步骤，将新打好的包部署到本地 Maven 仓库。
 * deploy：在 install 命令的前提下新增一个步骤，将新打的包部署到远端仓库（相当于本地和远端仓库同时部署一份）。
 *
 *
 * 打包带注释
 * 1、
 *将项目编译并打包到本地仓库，并且打包后会保存注释：
 * mvn clean source:jar install -Dmaven.test.skip=true
 *
 *如果单纯使用 idea 右上角的Lifecycle -> install 工具打包，打包后的 jar 是没有注释的
 *
 * 2、添加插件 maven-source-plugin，见pom
 *
 *
 *
 * @Import：
 * // 1. 导入普通类（没有 @Configuration）
 * @Import(NormalClass.class) // 只会导入这个类本身
 *
 * // 2. 导入配置类（有 @Configuration）
 * @Import(ConfigClass.class) // 会解析该类及其 @Bean 方法
 *
 * // 3. 导入 ImportSelector
 * @Import(MyImportSelector.class) // 执行 selectImports 方法
 *
 * // 4. 导入 ImportBeanDefinitionRegistrar
 * @Import(MyRegistrar.class) // 执行 registerBeanDefinitions 方法
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import({RabbitListenerConfigurationSelector.class})
//通过EnableFanckyStarter 注解Import 导入FanckyAutoConfiguration 配置类
@Import(FanckyAutoConfiguration.class)
public @interface EnableFanckyStarter {
}
