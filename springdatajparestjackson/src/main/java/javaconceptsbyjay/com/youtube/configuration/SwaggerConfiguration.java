package javaconceptsbyjay.com.youtube.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket myApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("javaconceptsbyjay.com.youtube"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(apiEndPointInfo());
    }
    private ApiInfo apiEndPointInfo()
    {
        return new ApiInfoBuilder()
                .title("SPRING BOOT + REST + DATA JPA + JACKSON")
                .description("Singers Management REST API")
                .contact(new Contact("Michael Odumosu","www.youtube.com/javaconceptsbyjay.com","michaelodumosu57@gmail.com"))
                .license("Apache 2.0")
                .version("1.0.0")
                .build();

    }
}
