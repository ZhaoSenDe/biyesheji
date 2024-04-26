package com.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// 声明该类为配置类
@Configuration
public class MyWebMvnConfig implements WebMvcConfigurer {
    // 重写WebMvcConfigurer接口的addResourceHandlers方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加静态资源映射，将指定路径下的文件映射为URL
        registry.addResourceHandler("file/videoFile/**").addResourceLocations("file:C:\\Users\\12465\\Desktop\\s\\file\\video\\");
        registry.addResourceHandler("file/imageFile/**").addResourceLocations("file:C:\\Users\\12465\\Desktop\\s\\file\\image\\");
    }
}
