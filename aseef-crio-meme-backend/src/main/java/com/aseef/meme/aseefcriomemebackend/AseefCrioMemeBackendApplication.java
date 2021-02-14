package com.aseef.meme.aseefcriomemebackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Controller
@SpringBootApplication
@EnableSwagger2
public class AseefCrioMemeBackendApplication {

	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
	@Value("${server.port}")
    private int serverPort;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:" + serverPort);
    }
	public static void main(String[] args) {
		SpringApplication.run(AseefCrioMemeBackendApplication.class, args);
	}

}
