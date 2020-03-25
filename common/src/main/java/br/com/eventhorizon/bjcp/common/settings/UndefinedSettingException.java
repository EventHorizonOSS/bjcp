package br.com.eventhorizon.bjcp.common.settings;

public class UndefinedSettingException extends Exception {

  public UndefinedSettingException() {
  }

  public UndefinedSettingException(String message) {
    super(message);
  }

  public UndefinedSettingException(String message, Throwable cause) {
    super(message, cause);
  }

  public UndefinedSettingException(Throwable cause) {
    super(cause);
  }

  public UndefinedSettingException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
