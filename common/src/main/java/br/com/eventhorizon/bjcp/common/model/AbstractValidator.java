package br.com.eventhorizon.bjcp.common.model;

import org.springframework.http.HttpMethod;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

public abstract class AbstractValidator<T> implements Validator<T> {

  @Override
  public Errors validate(T obj, HttpMethod method) {
    if (obj == null) {
      throw new IllegalArgumentException("Argument 'obj' cannot be null");
    }

    switch (method) {
      case POST:
        return validatePost(obj);
      case PUT:
        return validatePut(obj);
      case PATCH:
        return validatePatch(obj);
      default:
        throw new IllegalArgumentException("Argument 'method' should be one of: POST, PUT and PATCH");
    }
  }

  protected Errors validatePost(T obj) {
    return new DirectFieldBindingResult(obj, obj.getClass().getName());
  }

  protected Errors validatePut(T obj) {
    return new DirectFieldBindingResult(obj, obj.getClass().getName());
  }

  protected Errors validatePatch(T obj) {
    return new DirectFieldBindingResult(obj, obj.getClass().getName());
  }

}
