package br.com.eventhorizon.bjcp.common.model;

import org.springframework.http.HttpMethod;
import org.springframework.validation.Errors;

public interface Validator<T> {

  Errors validate(T obj, HttpMethod method);

}
