package br.com.eventhorizon.bjcp;

import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@EnableHypermediaSupport(type= {EnableHypermediaSupport.HypermediaType.HAL})
public class AppConfig {
}
