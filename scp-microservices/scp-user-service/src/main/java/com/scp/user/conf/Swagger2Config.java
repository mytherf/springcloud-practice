package com.scp.user.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev", "local", "test"})//在生产环境不开启
public class Swagger2Config {

  @Value("${swagger.title}")
  private String swaggerTitle;

  @Value("${swagger.description}")
  private String swaggerDescription;

  @Value("${swagger.version}")
  private String swaggerVersion;
  
  @Bean
  public Docket createRestApi() {
      return new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(apiInfo())
              .select()
              .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
              .paths(PathSelectors.any())
              .build();
  }

  private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title(swaggerTitle)
              .description(swaggerDescription)
              .termsOfServiceUrl("http://blog.didispace.com/")
              .version(swaggerVersion)
              .build();
  }
}
