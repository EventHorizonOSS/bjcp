package br.com.eventhorizon.bjcp.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface HttpResponse {

  enum Status {

    SUCCESS("Success"),
    CLIENT_ERROR("ClientError"),
    SERVER_ERROR("ServerError");

    private String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

  }

}
