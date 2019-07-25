package br.com.eventhorizon.bjcp.controllers;

import br.com.eventhorizon.bjcp.model.Category;
import br.com.eventhorizon.bjcp.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoriesController {

  private CategoriesService categoriesService;

  @Autowired
  public CategoriesController(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }

  @GetMapping
  public ResponseEntity<Resources<Category>> getCategories() {
    try {
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("x-my-custom-header", "x-my-custom-header-value");

      List<Category> categories = categoriesService.findCategories();

      return ResponseEntity.ok()
          .headers(responseHeaders)
          .body(new Resources(categories));
    } catch (Exception e) {
      int a = 10;
      int b = a;

      return ResponseEntity.ok()
          .body(new Resources(categoriesService.findCategories()));
    }
  }

}
