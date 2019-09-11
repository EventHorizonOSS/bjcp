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
        .body(HttpResponse.Builder.create(HttpResponse.Status.SERVER_ERROR)
            .errorCode(ErrorCode.UNKNOWN_ERROR)
            .errorMessage("Unexpected error: " + exception.getMessage())
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
          .body(HttpResponse.Builder.create(HttpResponse.Status.CLIENT_ERROR)
              .errorCode(ErrorCode.INVALID_RESOURCE)
              .errorMessage("Validation error")
              .errorDetails(errors)
              .build());
    }

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(HttpResponse.Builder.create(HttpResponse.Status.CLIENT_ERROR)
            .errorCode(ErrorCode.INVALID_RESOURCE)
            .errorMessage("Validation error")
            .errorDetails(exception.getMessage())
            .build());
  }

}
