package com.fsr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Hasee on 2017/4/25.
 */
@SpringBootApplication
public class ExpenseApplication extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExpenseApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExpenseApplication.class, args);
    }
}
