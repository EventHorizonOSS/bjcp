package br.com.eventhorizon.bjcp.resources;

import br.com.eventhorizon.bjcp.controllers.CategoryController;
import br.com.eventhorizon.bjcp.model.Category;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class CategoryResourceAssembler extends ResourceAssemblerSupport<Category, CategoryResource> {

  public CategoryResourceAssembler() {
    super(CategoryController.class, CategoryResource.class);
  }

  @Override
  public CategoryResource toResource(Category category) {
    CategoryResource categoryResource = super.createResourceWithId(category.getId(), category);
    categoryResource.setCategoryId(category.getId());
    categoryResource.setNumber(category.getNumber());
    categoryResource.setName(category.getName());
    categoryResource.setDescription(category.getDescription());
    return categoryResource;
  }

}
