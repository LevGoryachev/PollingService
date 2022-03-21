package ru.goryachev.pollingservice.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "ru.goryachev.pollingservice")
@EnableJpaRepositories (basePackages = "ru.goryachev.pollingservice")
@EntityScan (basePackages = "ru.goryachev.pollingservice")
public class AppInit extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder appBuilder) {
        return super.configure(appBuilder);
    }
}
