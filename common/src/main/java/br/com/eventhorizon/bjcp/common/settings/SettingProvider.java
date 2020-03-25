package br.com.eventhorizon.bjcp.common.settings;

public interface SettingProvider<S> {

  <V> V get(S setting) throws InvalidSettingException, UndefinedSettingException;

  <V> V getOrDefault(S setting) throws InvalidSettingException;

}
