package br.com.eventhorizon.bjcp.common.settings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SystemSettingProvider implements SettingProvider<SystemSetting> {

  private static final Logger LOGGER = LogManager.getLogger(SystemSettingProvider.class);

  private Map<SystemSetting, Object> systemSettings = new HashMap<>();

  public SystemSettingProvider() {
    System.getProperties().forEach((k, v) -> {
      try {
        SystemSetting setting = SystemSetting.fromName((String)k);
        systemSettings.put(setting, setting.parseValue((String)v));
      } catch (Exception e) {
        // TODO
      }
    });
    LOGGER.info("System Settings: " + systemSettings);
  }

  @Override
  public <T> T getSettingValue(String settingName) {
    return (T) systemSettings.get(SystemSetting.valueOf(settingName));
  }

  @Override
  public <T2> T2 getSettingValue(SystemSetting setting) {
    return (T2) systemSettings.get(setting);
  }

}
