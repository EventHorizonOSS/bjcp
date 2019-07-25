package br.com.eventhorizon.bjcp.services;

import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

  public List<Category> findCategories() {
    Category c = new Category();
    c.setName("My Category");

    List<Category> categories = new ArrayList<>();
    categories.add(c);

    return categories;
  }

}
