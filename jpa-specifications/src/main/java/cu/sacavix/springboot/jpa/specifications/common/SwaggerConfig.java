package cu.sacavix.springboot.jpa.specifications.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by ups on 26/11/17.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cu.sacavix.springboot.jpa.specifications"))
                .build()
                .apiInfo(new ApiInfo("Event APIs",
                        "",
                        "",
                        "",
                        new Contact("", "",""),
                        "",
                        "",
                        Collections.emptyList()));
    }
}
