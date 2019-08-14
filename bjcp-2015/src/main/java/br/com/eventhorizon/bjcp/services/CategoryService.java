package br.com.eventhorizon.bjcp.services;

import br.com.eventhorizon.bjcp.data.CategoryRepository;
import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {

  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> find() {
    return categoryRepository.findAll();
  }

  public Category findById(String id) throws ResourceNotFoundException {
    Optional<Category> op = categoryRepository.findById(id);
    if (op.isPresent()) {
      return op.get();
    }
    throw new ResourceNotFoundException(id);
  }

  public List<Category> find(Map<String, String> query) {
    // TODO
    return Collections.emptyList();
  }

  public Category create(Category category) throws ResourceAlreadyExist {
    try {
      return this.categoryRepository.insert(category);
    } catch (DuplicateKeyException e) {
      throw new ResourceAlreadyExist(category.getId());
    }
  }

}
