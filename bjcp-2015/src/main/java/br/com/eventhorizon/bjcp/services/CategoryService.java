package br.com.eventhorizon.bjcp.services;

import br.com.eventhorizon.bjcp.data.CategoryRepository;
import br.com.eventhorizon.bjcp.data.StaticData;
import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryService {

  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> find() {
    return categoryRepository.findAll();
    //return StaticData.categories;
  }

  public Category findById(String id) {
    return StaticData.categories.stream().filter(c -> c.getId().equals(id)).findFirst().get();
  }

  public Category findByNumber(Integer number) {
    return StaticData.categories.stream().filter(c -> c.getNumber().equals(number)).findFirst().get();
  }

  public Category findByName(String name) {
    return StaticData.categories.stream().filter(c -> c.getName().equals(name)).findFirst().get();
  }

  public List<Category> find(Map<String, String> query) {
    Stream<Category> stream = StaticData.categories.stream();

    if (query.containsKey("number")) {
      stream = stream.filter(c -> c.getNumber().equals(Integer.parseInt(query.get("number"))));
    }
    if (query.containsKey("name")) {
      stream = stream.filter(c -> c.getName().equals(query.get("name")));
    }

    return stream.collect(Collectors.toList());
  }

}
