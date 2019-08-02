package br.com.eventhorizon.bjcp.common.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HttpBaseResponse implements HttpResponse {

  @JsonProperty("status")
  private HttpResponse.Status status;

  @JsonProperty("data")
  private Object data;

  public HttpBaseResponse(HttpResponse.Status status) {
    this.status = status;
  }

  public HttpBaseResponse(HttpResponse.Status status, Object data) {
    this(status);
    this.data = data;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}
