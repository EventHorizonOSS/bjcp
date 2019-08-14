package br.com.eventhorizon.bjcp.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponse {

  @JsonProperty("status")
  private HttpResponse.Status status;

  @JsonProperty("data")
  private Object data;

  @JsonProperty("error")
  private Error error;

  public HttpResponse(HttpResponse.Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public Object getData() {
    return data;
  }

  public Error getError() {
    return error;
  }

  public enum Status {

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

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Error {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("details")
    private Object details;

    private Error() {
    }

    public String getCode() {
      return code;
    }

    public String getMessage() {
      return message;
    }

    public Object getDetails() {
      return details;
    }

  }

  public static class Builder {

    private HttpResponse httpResponse;

    private Builder(Status status) {
      this.httpResponse = new HttpResponse(status);
    }

    public static Builder create(Status status) {
      return new Builder(status);
    }

    public Builder data(Object data) {
      this.httpResponse.data = data;
      return this;
    }

    public Builder errorCode(String errorCode) {
      if (this.httpResponse.error == null) {
        this.httpResponse.error = new Error();
      }
      this.httpResponse.error.code = errorCode;
      return this;
    }

    public Builder errorMessage(String errorMessage) {
      if (this.httpResponse.error == null) {
        this.httpResponse.error = new Error();
      }
      this.httpResponse.error.message = errorMessage;
      return this;
    }

    public Builder errorDetails(Object errorDetails) {
      if (this.httpResponse.error == null) {
        this.httpResponse.error = new Error();
      }
      this.httpResponse.error.details = errorDetails;
      return this;
    }

    public HttpResponse build() {
      return this.httpResponse;
    }

  }

}
