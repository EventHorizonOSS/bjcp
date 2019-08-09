package br.com.eventhorizon.bjcp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;

@Configuration
@EnableWebMvc
//@EnableHypermediaSupport(type= {EnableHypermediaSupport.HypermediaType.HAL})
@EnableMongoRepositories
public class AppConfig {

  private static final Logger LOGGER = LogManager.getLogger(AppConfig.class);

  static {
    LOGGER.info("START");

    // Logging system properties
    StringJoiner str1 = new StringJoiner(",\n", "System Properties {", "}");
    System.getProperties().forEach((key, value) -> str1.add(String.join(": ", "" + key, "" + value)));
    LOGGER.info(str1.toString());

    // Logging environment variables
    StringJoiner str2 = new StringJoiner(",\n", "Environment Variables {", "}");
    System.getenv().forEach((key, value) -> str2.add(String.join(": ", "" + key, "" + value)));
    LOGGER.info(str2.toString());
  }

}
