package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.common.http.Controller;
import br.com.eventhorizon.bjcp.common.http.Response;
import br.com.eventhorizon.bjcp.common.http.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
public class HealthCheckController extends Controller {

  @GetMapping
  @ResponseBody
  public ResponseEntity<Response> get() {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(Response.Builder.create(ResponseStatus.SUCCESS)
            .data("{status:\"Running\",version:\"0.0.1\"}")
            .build());
  }

}
