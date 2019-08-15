package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.common.http.ErrorCode;
import br.com.eventhorizon.bjcp.common.http.HttpResponse;
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
public class StyleController {

  private StyleService styleService;

  @Autowired
  public StyleController(StyleService styleService) {
    this.styleService = styleService;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity getCategories(@RequestParam Map<String, String> query) {
    try {
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
          .body(HttpResponse.Builder.create(HttpResponse.Status.SUCCESS)
              .data(styles)
              .build());
    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(HttpResponse.Builder.create(HttpResponse.Status.SERVER_ERROR)
              .errorCode(ErrorCode.UNKNOWN_ERROR)
              .errorMessage("Unknown error")
              .build());
    }
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
          .body(HttpResponse.Builder.create(HttpResponse.Status.SUCCESS)
              .data(style)
              .build());
    } catch (ResourceNotFoundException e) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(HttpResponse.Builder.create(HttpResponse.Status.CLIENT_ERROR)
              .errorCode(ErrorCode.RESOURCE_NOT_FOUND)
              .errorMessage("Resource not found")
              .build());
    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(HttpResponse.Builder.create(HttpResponse.Status.SERVER_ERROR)
              .errorCode(ErrorCode.UNKNOWN_ERROR)
              .errorMessage("Unknown error")
              .build());
    }
  }

}
