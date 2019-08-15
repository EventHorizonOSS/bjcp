package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.common.http.ErrorCode;
import br.com.eventhorizon.bjcp.common.http.HttpResponse;
import br.com.eventhorizon.bjcp.model.Category;
import br.com.eventhorizon.bjcp.services.CategoryService;
import br.com.eventhorizon.bjcp.services.ResourceAlreadyExist;
import br.com.eventhorizon.bjcp.services.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity getCategories(@RequestParam Map<String, String> query) {
    try {
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("x-my-custom-header", "x-my-custom-header-value");

      List<Category> categories;
      if (query.isEmpty()) {
        categories = categoryService.find();
      } else {
        categories = categoryService.find(query);
      }

      return ResponseEntity
          .status(HttpStatus.OK)
          .body(HttpResponse.Builder.create(HttpResponse.Status.SUCCESS)
              .data(categories)
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

      Category category = categoryService.findById(id);

      return ResponseEntity
          .status(HttpStatus.OK)
          .body(HttpResponse.Builder.create(HttpResponse.Status.SUCCESS)
              .data(category)
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

  @PostMapping
  @ResponseBody
  public ResponseEntity postCategory(@RequestBody Category category) {
    try {
      Category createdCategory = this.categoryService.create(category);

      return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(HttpResponse.Builder.create(HttpResponse.Status.SUCCESS)
              .data(createdCategory)
              .build());
    } catch (ResourceAlreadyExist e) {
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .body(HttpResponse.Builder.create(HttpResponse.Status.CLIENT_ERROR)
              .errorCode(ErrorCode.RESOURCE_ALREADY_EXIST)
              .errorMessage("Resource already exist")
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

  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity putCategory(@PathVariable String id, @RequestBody Category category) {
    try {
      category.setId(id);
      Category updatedCategory = this.categoryService.update(category);

      return ResponseEntity
          .status(HttpStatus.OK)
          .body(HttpResponse.Builder.create(HttpResponse.Status.SUCCESS)
              .data(updatedCategory)
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
