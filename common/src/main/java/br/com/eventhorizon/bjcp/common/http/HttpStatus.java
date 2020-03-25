package br.com.eventhorizon.bjcp.common.http;

public enum HttpStatus {

  // Successful responses
  OK(200, "OK"),
  CREATED(201, "Created"),
  ACCEPTED(202, "Accepted"),

  // Client error responses
  BAD_REQUEST(400, "Bad Request"),
  UNAUTHORIZED(401, "Unauthorized"),
  FORBIDDEN(403, "Forbidden"),
  NOT_FOUND(404, "Not Found"),
  METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

  // Server error responses
  INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
  NOT_IMPLEMENTED(501, "Not Implemented");

  private int code;

  private String name;

  HttpStatus(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
