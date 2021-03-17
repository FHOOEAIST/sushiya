package science.aist.sushiya.external.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Created by Christoph Praschl on 05/12/2019</p>
 * <p>Configuration of the swagger ui</p>
 *
 * @author Christoph Praschl christoph.praschl@fh-hagenberg.at
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("science.aist.sushiya.external.rest"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }
}
