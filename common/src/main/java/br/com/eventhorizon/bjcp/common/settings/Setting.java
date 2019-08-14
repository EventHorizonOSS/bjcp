package br.com.eventhorizon.bjcp.common.settings;

public abstract class Setting {

  private String key;

  private SettingType type;

  private Object defaultValue;

  protected Setting(String key, SettingType type, Object defaultValue) {
    this.key = key;
    this.type = type;
    this.defaultValue = defaultValue;
  }

  public String getKey() {
    return key;
  }

  public SettingType getType() {
    return type;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

  public Object parse(String value) throws InvalidSettingException {
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

    throw new InvalidSettingException();
  }

}
