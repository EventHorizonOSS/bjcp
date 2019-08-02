package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.common.http.HttpBaseResponse;
import br.com.eventhorizon.bjcp.common.http.HttpResponse;
import br.com.eventhorizon.bjcp.model.Category;
import br.com.eventhorizon.bjcp.resources.CategoryResourceAssembler;
import br.com.eventhorizon.bjcp.services.CategoryService;
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
@RequestMapping("/v1/categories")
public class CategoriesController {

  private CategoryService categoryService;

  @Autowired
  public CategoriesController(CategoryService categoryService) {
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

      return ResponseEntity.ok()
          .headers(responseHeaders)
          .body(new CategoryResourceAssembler().toResources(categories));
    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new HttpBaseResponse(HttpResponse.Status.SERVER_ERROR));
    }
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getCategory(@PathVariable String id) {
    try {
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("x-my-custom-header", "x-my-custom-header-value");

      Category category = categoryService.findById(id);

      return ResponseEntity.ok()
          .headers(responseHeaders)
          .body(new CategoryResourceAssembler().toResource(category));
    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new HttpBaseResponse(HttpResponse.Status.SERVER_ERROR));
    }
  }

}
