package br.com.eventhorizon.bjcp.common.http;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Controller {

  @ExceptionHandler
  public ResponseEntity handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(Response.Builder.create(ResponseStatus.SERVER_ERROR)
            .addError(ErrorCode.UNKNOWN_ERROR, "Unknown error")
            .build());
  }

  @ExceptionHandler
  public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    List<String> errors = exception.getBindingResult().getFieldErrors().stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .collect(Collectors.toList());
    if (errors != null && !errors.isEmpty()) {
      return ResponseEntity
          .status(org.springframework.http.HttpStatus.BAD_REQUEST)
          .body(Response.Builder.create(ResponseStatus.CLIENT_ERROR)
              .addError(ErrorCode.INVALID_RESOURCE, "Validation error", errors)
              .build());
    }

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(Response.Builder.create(ResponseStatus.CLIENT_ERROR)
            .addError(ErrorCode.INVALID_RESOURCE, "Validation error", exception.getMessage())
            .build());
  }

}
