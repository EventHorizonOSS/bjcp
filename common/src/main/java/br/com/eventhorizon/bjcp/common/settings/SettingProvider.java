package br.com.eventhorizon.bjcp.common.settings;

public interface SettingProvider<T1> {

  <T2> T2 getSettingValue(String settingName);

  <T2> T2 getSettingValue(T1 setting);

}
