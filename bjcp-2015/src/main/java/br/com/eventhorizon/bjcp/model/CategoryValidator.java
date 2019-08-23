package br.com.eventhorizon.bjcp.model;

import br.com.eventhorizon.bjcp.common.model.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CategoryValidator extends AbstractValidator<Category> {

  @Override
  protected Errors validatePost(Category category) {
    Errors errors = super.validatePost(category);

    String name = category.getName();
    if (CategoryField.NAME.isRequired() && (name == null || name.isEmpty())) {
      errors.reject(CategoryField.NAME.getName(), "null_or_empty");
    }

    String description = category.getDescription();
    if (CategoryField.DESCRIPTION.isRequired() && (description == null || description.isEmpty())) {
      errors.reject(CategoryField.DESCRIPTION.getName(), "null_or_empty");
    }

    return errors;
  }

}

