package br.com.eventhorizon.bjcp.config;

import br.com.eventhorizon.bjcp.common.settings.SystemSetting;
import br.com.eventhorizon.bjcp.common.settings.SystemSettingProvider;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Arrays;

@Configuration
@Lazy
public class MongoConfig extends AbstractMongoClientConfiguration {

  private SystemSettingProvider systemSettingProvider;

  @Autowired
  public MongoConfig(SystemSettingProvider systemSettingProvider) {
    this.systemSettingProvider = systemSettingProvider;
  }

  @Override
  public MongoClient mongoClient() {
    String username = systemSettingProvider.getSettingValue(SystemSetting.MONGO_AUTH_USERNAME);
    String authDatabase = systemSettingProvider.getSettingValue(SystemSetting.MONGO_AUTH_DATABASE);
    String password = systemSettingProvider.getSettingValue(SystemSetting.MONGO_AUTH_PASSWORD);
    String serverAddress = systemSettingProvider.getSettingValue(SystemSetting.MONGO_SERVER_ADDRESS);
    int serverPort = systemSettingProvider.getSettingValue(SystemSetting.MONGO_SERVER_PORT);
    MongoCredential credential =
        MongoCredential.createScramSha1Credential(username, authDatabase, password.toCharArray());
    return MongoClients.create(
        MongoClientSettings.builder()
            .credential(credential)
            .applyToSslSettings(builder -> builder.enabled(false))
            .applyToClusterSettings(builder -> builder.hosts(
                Arrays.asList(new ServerAddress(serverAddress, serverPort))))
            .build());
  }

  @Override
  protected String getDatabaseName() {
    return systemSettingProvider.getSettingValue(SystemSetting.MONGO_DATABASE);
  }

}
