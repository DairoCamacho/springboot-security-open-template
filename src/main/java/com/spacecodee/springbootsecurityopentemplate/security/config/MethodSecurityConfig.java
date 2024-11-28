package com.spacecodee.springbootsecurityopentemplate.security.config;

import com.spacecodee.springbootsecurityopentemplate.security.authorization.evaluator.CustomPermissionEvaluator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class MethodSecurityConfig {

    private final CustomPermissionEvaluator customPermissionEvaluator;

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(this.customPermissionEvaluator);
        return expressionHandler;
    }
}