package br.com.eventhorizon.bjcp.config;

import br.com.eventhorizon.bjcp.common.settings.InvalidSettingException;
import br.com.eventhorizon.bjcp.common.settings.SystemSetting;
import br.com.eventhorizon.bjcp.common.settings.SystemSettingProvider;
import br.com.eventhorizon.bjcp.common.settings.UndefinedSettingException;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Arrays;

@Configuration
@Lazy
public class MongoConfig extends AbstractMongoClientConfiguration {

  private static final Logger LOGGER = LogManager.getLogger(MongoConfig.class);

  private SystemSettingProvider systemSettingProvider;

  @Autowired
  public MongoConfig(SystemSettingProvider systemSettingProvider) {
    this.systemSettingProvider = systemSettingProvider;
  }

  @Override
  public MongoClient mongoClient() {

    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      String username = systemSettingProvider.get(SystemSetting.MONGO_AUTH_USERNAME);
      String authDatabase = systemSettingProvider.get(SystemSetting.MONGO_AUTH_DATABASE);
      String password = systemSettingProvider.get(SystemSetting.MONGO_AUTH_PASSWORD);
      String serverAddress = systemSettingProvider.get(SystemSetting.MONGO_SERVER_ADDRESS);
      int serverPort = systemSettingProvider.get(SystemSetting.MONGO_SERVER_PORT);
      MongoCredential credential =
          MongoCredential.createScramSha1Credential(username, authDatabase, password.toCharArray());
      return MongoClients.create(
          MongoClientSettings.builder()
              .credential(credential)
              .applyToSslSettings(builder -> builder.enabled(false))
              .applyToClusterSettings(builder -> builder.hosts(
                  Arrays.asList(new ServerAddress(serverAddress, serverPort))))
              .build());
    } catch (InvalidSettingException e) {
      LOGGER.fatal("Failed to connect to MongoDB server due to invalid settings required to make the connection");
    } catch (UndefinedSettingException e) {
      LOGGER.fatal("Failed to connect to MongoDB server due to missing settings required to make the connection");
    }

    return null;
  }

  @Override
  protected String getDatabaseName() {
    try {
      return systemSettingProvider.get(SystemSetting.MONGO_DATABASE);
    } catch (InvalidSettingException e) {
      LOGGER.fatal("Failed to get the database name, database name setting is invalid");
    } catch (UndefinedSettingException e) {
      LOGGER.fatal("Failed to get the database name, database name setting is undefined");
    }

    return null;
  }

}
