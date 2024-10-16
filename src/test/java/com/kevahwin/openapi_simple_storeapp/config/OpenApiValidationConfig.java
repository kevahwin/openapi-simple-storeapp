package com.kevahwin.openapi_simple_storeapp.config;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OpenApiValidationConfig {

  @Bean
  public Filter validationFilter() {
    return new OpenApiValidationFilter(
        true, // enables request validation
        true // enables response validation
        );
  }

  @Bean
  public WebMvcConfigurer openAPIValidationInterceptor() {
    OpenApiInteractionValidator validator =
        OpenApiInteractionValidator.createForSpecificationUrl(
                "https://api.redocly.com/registry/bundle/kevahwin/API%20First%20Simple%20Store%20App%20-%20Development/v1/openapi.yaml?branch=development")
            .build();

    OpenApiValidationInterceptor interceptor = new OpenApiValidationInterceptor(validator);

    return new WebMvcConfigurer() {
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
      }
    };
  }
}
