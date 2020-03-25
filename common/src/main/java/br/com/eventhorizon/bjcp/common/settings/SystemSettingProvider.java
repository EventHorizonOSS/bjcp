package br.com.eventhorizon.bjcp.common.settings;

import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class SystemSettingProvider implements SettingProvider<SystemSetting> {

  @Override
  public <V> V get(SystemSetting setting) throws InvalidSettingException,
      UndefinedSettingException {
    String key = setting.getKey();
    Properties properties = System.getProperties();
    if (properties.containsKey(key)) {
      return (V) setting.parse(properties.getProperty(key));
    }

    throw new UndefinedSettingException("Setting " + setting.getKey() + " is undefined");
  }

  @Override
  public <V> V getOrDefault(SystemSetting setting) throws InvalidSettingException {
    String key = setting.getKey();
    Properties properties = System.getProperties();
    if (properties.containsKey(key)) {
      return (V) setting.parse(properties.getProperty(key));
    }

    return (V) setting.getDefaultValue();
  }

}
