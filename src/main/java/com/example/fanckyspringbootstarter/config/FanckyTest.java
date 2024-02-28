package com.example.fanckyspringbootstarter.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
#配置文件不要用駝峰写法 单词全小写或者用短横线连接 如：config.configmodel 或config.config-model
#在竖线位置粘贴


警告：Spring Boot Configuration Annotation Processor not configured
解决：启动类添加@EnableConfigurationProperties
 */
@Data
//@Configuration//不能用@Configuration，不然依赖项目找不到该类,需要@EnableConfigurationProperties
//@Component
@ConfigurationProperties(prefix = "fanckytest")//配置必须全部小写
//引用module报异常
//@ConditionalOnProperty(value = "spring.fanckytest", havingValue = "true")
public class FanckyTest {
    private String host="127.0.0.1";
    private String port="8888";
}
