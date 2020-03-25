package br.com.eventhorizon.bjcp.common.http;

public enum ResponseStatus {

  SUCCESS("Success"),
  CLIENT_ERROR("ClientError"),
  SERVER_ERROR("ServerError");

  private String value;

  ResponseStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
