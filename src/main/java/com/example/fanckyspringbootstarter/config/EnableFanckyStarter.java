package com.example.fanckyspringbootstarter.config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * starter 两种方式：2比较灵活可以控制是否启动
 * 1、spring.factories 配置自动配置项
 * 2、@Import实现 ImportSelector 的selectImports方法，方法内添加自动配置类全路径
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import({RabbitListenerConfigurationSelector.class})
@Import(FanckyAutoConfiguration.class)
public @interface EnableFanckyStarter {
}
