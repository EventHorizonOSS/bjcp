package br.com.eventhorizon.bjcp.common.settings;

public class InvalidSettingException extends Exception {

  public InvalidSettingException() {
  }

  public InvalidSettingException(String message) {
    super(message);
  }

  public InvalidSettingException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidSettingException(Throwable cause) {
    super(cause);
  }

  public InvalidSettingException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
