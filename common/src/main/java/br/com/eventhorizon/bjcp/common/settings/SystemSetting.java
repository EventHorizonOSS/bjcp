package br.com.eventhorizon.bjcp.common.settings;

public enum SystemSetting {

  MONGO_SERVER_ADDRESS  ("br.com.eventhorizon.bjcp.mongo.serveraddress",  SystemSettingType.STRING,   "localhost"),
  MONGO_SERVER_PORT     ("br.com.eventhorizon.bjcp.mongo.port",           SystemSettingType.INTEGER,  27017),
  MONGO_DATABASE        ("br.com.eventhorizon.bjcp.mongo.database",       SystemSettingType.STRING,   "bjcp"),
  MONGO_AUTH_DATABASE   ("br.com.eventhorizon.bjcp.mongo.authdatabase",   SystemSettingType.STRING,   "admin"),
  MONGO_AUTH_USERNAME   ("br.com.eventhorizon.bjcp.mongo.username",       SystemSettingType.STRING,   "root"),
  MONGO_AUTH_PASSWORD   ("br.com.eventhorizon.bjcp.mongo.password",       SystemSettingType.STRING,   "");

  private String name;

  private SystemSettingType type;

  private Object defaultValue;

  SystemSetting(String name, SystemSettingType type, Object defaultValue) {
    this.name = name;
    this.type = type;
    this.defaultValue = defaultValue;
  }

  public String getName() {
    return name;
  }

  public SystemSettingType getType() {
    return type;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

  public static SystemSetting fromName(String name) {
    switch (name) {
      case "br.com.eventhorizon.bjcp.mongo.serveraddress":
        return MONGO_SERVER_ADDRESS;
      case "br.com.eventhorizon.bjcp.mongo.port":
        return MONGO_SERVER_PORT;
      case "br.com.eventhorizon.bjcp.mongo.database":
        return MONGO_DATABASE;
      case "br.com.eventhorizon.bjcp.mongo.authdatabase":
        return MONGO_AUTH_DATABASE;
      case "br.com.eventhorizon.bjcp.mongo.username":
        return MONGO_AUTH_USERNAME;
      case "br.com.eventhorizon.bjcp.mongo.password":
        return MONGO_AUTH_PASSWORD;
    }

    throw new IllegalArgumentException("Invalid SystemSetting name " + name);
  }

  public Object parseValue(String value) throws Exception {
    switch (type) {
      case STRING:
        return value;
      case INTEGER:
        return Integer.parseInt(value);
      case DOUBLE:
        return Double.parseDouble(value);
      case BOOLEAN:
        Boolean.parseBoolean(value);
        break;
    }

    throw new Exception("Invalid setting type");
  }

}
