package com.md.lib.config;

import com.md.lib.service.DemoService;
import com.md.lib.service.OptionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan("com.md.lib.service")
@RequiredArgsConstructor
public class LibAutoConfiguration {

    public final DemoService demoService;

    @Bean
    @ConditionalOnProperty("optional.bean.enabled")
    public OptionalService optionalService() {
        System.out.println("generating optionalService...");
        return new OptionalService();
    }

    @PostConstruct
    public void init() {
        System.out.println("initializing");
    }
}
