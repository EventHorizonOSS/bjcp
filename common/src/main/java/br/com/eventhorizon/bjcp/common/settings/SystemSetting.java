package br.com.eventhorizon.bjcp.common.settings;

public class SystemSetting extends Setting {

  public static final SystemSetting MONGO_SERVER_ADDRESS  = new SystemSetting("br.com.eventhorizon.bjcp.mongo.serveraddress",  SettingType.STRING,   "localhost");

  public static final SystemSetting MONGO_SERVER_PORT     = new SystemSetting("br.com.eventhorizon.bjcp.mongo.port",           SettingType.INTEGER,  27017);

  public static final SystemSetting MONGO_DATABASE        = new SystemSetting("br.com.eventhorizon.bjcp.mongo.database",       SettingType.STRING,   "bjcp");

  public static final SystemSetting MONGO_AUTH_DATABASE   = new SystemSetting("br.com.eventhorizon.bjcp.mongo.authdatabase",   SettingType.STRING,   "admin");

  public static final SystemSetting MONGO_AUTH_USERNAME   = new SystemSetting("br.com.eventhorizon.bjcp.mongo.username",       SettingType.STRING,   "root");

  public static final SystemSetting MONGO_AUTH_PASSWORD   = new SystemSetting("br.com.eventhorizon.bjcp.mongo.password",       SettingType.STRING,   "password");

  private SystemSetting(String key, SettingType type, Object defaultValue) {
    super(key, type, defaultValue);
  }

}
