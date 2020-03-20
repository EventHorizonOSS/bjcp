package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.common.http.Controller;
import br.com.eventhorizon.bjcp.common.http.ErrorCode;
import br.com.eventhorizon.bjcp.common.http.Response;
import br.com.eventhorizon.bjcp.common.http.ResponseStatus;
import br.com.eventhorizon.bjcp.model.Style;
import br.com.eventhorizon.bjcp.services.ResourceNotFoundException;
import br.com.eventhorizon.bjcp.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/styles")
public class StyleController extends Controller {

  private StyleService styleService;

  @Autowired
  public StyleController(StyleService styleService) {
    this.styleService = styleService;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity getCategories(@RequestParam Map<String, String> query) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("x-my-custom-header", "x-my-custom-header-value");

    List<Style> styles;
    if (query.isEmpty()) {
      styles = styleService.find();
    } else {
      styles = styleService.find(query);
    }

    return ResponseEntity
        .status(HttpStatus.OK)
        .headers(responseHeaders)
        .body(Response.Builder.create(ResponseStatus.SUCCESS)
            .data(styles)
            .build());
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getCategory(@PathVariable String id) {
    try {
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("x-my-custom-header", "x-my-custom-header-value");

      Style style = styleService.findById(id);

      return ResponseEntity
          .status(HttpStatus.OK)
          .headers(responseHeaders)
          .body(Response.Builder.create(ResponseStatus.SUCCESS)
              .data(style)
              .build());
    } catch (ResourceNotFoundException e) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(Response.Builder.create(ResponseStatus.CLIENT_ERROR)
              .addError(ErrorCode.RESOURCE_NOT_FOUND, "Resource not found")
              .build());
    }
  }

}
