package br.com.eventhorizon.bjcp.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Arrays;

@Configuration
@Lazy
public class MongoConfig extends AbstractMongoClientConfiguration {

  private static final String MONGO_SERVER_ADDRESS = "mongo.eventhorizon.com.br";

  private static final int MONGO_SERVER_PORT = 27017;

  private static final String MONGO_DATABASE = "bjcp";

  private static final String MONGO_AUTH_DATABASE = "admin";

  private static final String MONGO_AUTH_USERNAME = "root";

  private static final String MONGO_AUTH_PASSWORD = "password";

  @Override
  public MongoClient mongoClient() {
    MongoCredential credential = MongoCredential.createScramSha1Credential(MONGO_AUTH_USERNAME,
        MONGO_AUTH_DATABASE, MONGO_AUTH_PASSWORD.toCharArray());
    return MongoClients.create(
        MongoClientSettings.builder()
            .credential(credential)
            .applyToSslSettings(builder -> builder.enabled(false))
            .applyToClusterSettings(builder -> builder.hosts(
                Arrays.asList(new ServerAddress(MONGO_SERVER_ADDRESS, MONGO_SERVER_PORT))))
            .build());
  }

  @Override
  protected String getDatabaseName() {
    return MONGO_DATABASE;
  }

}
