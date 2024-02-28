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
 */


/**
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
