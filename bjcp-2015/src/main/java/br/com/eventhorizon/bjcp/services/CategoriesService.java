package br.com.eventhorizon.bjcp.services;

import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

  public List<Category> findCategories() {
    List<Category> categories = new ArrayList<>();

    categories.add(new Category(){{
      setId("1");
      setName("Category 1");
    }});
    categories.add(new Category(){{
      setId("2");
      setName("Category 2");
    }});

    return categories;
  }

}
