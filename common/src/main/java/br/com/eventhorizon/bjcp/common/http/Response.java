package br.com.eventhorizon.bjcp.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

  @JsonProperty("status")
  private ResponseStatus status;

  @JsonProperty("data")
  private Object data;

  @JsonProperty("errors")
  private List<Error> errors;

  private Response(ResponseStatus status) {
    this.status = status;
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Error {

    @JsonProperty("code")
    private ErrorCode code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("details")
    private Object details;

    private Error(ErrorCode code, String message) {
      this.code = code;
      this.message = message;
    }

    private Error(ErrorCode code, String message, Object details) {
      this.code = code;
      this.message = message;
      this.details = details;
    }

    public ErrorCode getCode() {
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

    private Response response;

    private Builder(ResponseStatus status) {
      this.response = new Response(status);
    }

    public static Builder create(ResponseStatus status) {
      return new Builder(status);
    }

    public Builder data(Object data) {
      this.response.data = data;
      return this;
    }

    public Builder errors(List<Error> errors) {
      this.response.errors = errors;
      return this;
    }

    public Builder addError(Error error) {
      if (this.response.errors == null) {
        this.response.errors = new ArrayList<>();
      }
      this.response.errors.add(error);
      return this;
    }

    public Builder addError(ErrorCode code, String message) {
      if (this.response.errors == null) {
        this.response.errors = new ArrayList<>();
      }
      this.response.errors.add(new Error(code, message));
      return this;
    }

    public Builder addError(ErrorCode code, String message, Object details) {
      if (this.response.errors == null) {
        this.response.errors = new ArrayList<>();
      }
      this.response.errors.add(new Error(code, message, details));
      return this;
    }

    public Response build() {
      return this.response;
    }

  }

}
