package com.trainingapp.trainingapp.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class WebMVCConfig implements WebMvcConfigurer{
    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
    }
}