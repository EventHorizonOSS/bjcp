package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.common.http.Controller;
import br.com.eventhorizon.bjcp.common.http.ErrorCode;
import br.com.eventhorizon.bjcp.common.http.Response;
import br.com.eventhorizon.bjcp.common.http.ResponseStatus;
import br.com.eventhorizon.bjcp.common.model.PostValidator;
import br.com.eventhorizon.bjcp.model.Category;
import br.com.eventhorizon.bjcp.services.CategoryService;
import br.com.eventhorizon.bjcp.services.ResourceAlreadyExist;
import br.com.eventhorizon.bjcp.services.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public class CategoryController extends Controller {

  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity getCategories(@RequestParam Map<String, String> query) {
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
        .body(Response.Builder.create(ResponseStatus.SUCCESS)
            .data(categories)
            .build());
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
          .body(Response.Builder.create(ResponseStatus.SUCCESS)
              .data(category)
              .build());
    } catch (ResourceNotFoundException e) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(Response.Builder.create(ResponseStatus.CLIENT_ERROR)
              .addError(ErrorCode.RESOURCE_NOT_FOUND, "Resource not found")
              .build());
    }
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity postCategory(
      @Validated(PostValidator.class) @RequestBody Category category) {
    try {
      Category createdCategory = this.categoryService.create(category);

      return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(Response.Builder.create(ResponseStatus.SUCCESS)
              .data(createdCategory)
              .build());
    } catch (ResourceAlreadyExist e) {
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .body(Response.Builder.create(ResponseStatus.CLIENT_ERROR)
              .addError(ErrorCode.RESOURCE_ALREADY_EXIST, "Resource already exist")
              .build());
    }
  }

  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity putCategory(@PathVariable String id, @RequestBody Category category) {
    category.setId(id);
    Category updatedCategory = this.categoryService.update(category);

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(Response.Builder.create(ResponseStatus.SUCCESS)
            .data(updatedCategory)
            .build());
  }

}
