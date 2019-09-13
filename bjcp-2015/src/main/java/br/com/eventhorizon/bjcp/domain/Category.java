package br.com.eventhorizon.bjcp.domain;

import br.com.eventhorizon.bjcp.common.domain.BaseModel;

import br.com.eventhorizon.bjcp.common.domain.validation.CreateValidation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringJoiner;

import javax.validation.constraints.NotBlank;

@Document(collection = "categories")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category extends BaseModel {

  @NotBlank(message = "Name cannot be null, empty or blank", groups = CreateValidation.class)
  @JsonProperty("name")
  private String name;

  @NotBlank(message = "Description cannot be null, empty or blank", groups = CreateValidation.class)
  @JsonProperty("description")
  private String description;

  public Category() {
    super();
  }

  public Category(String id) {
    super(id);
  }

  public Category(Category category) {
    super(category);
    this.name = category.name;
    this.description = category.description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public Category clone() {
    return new Category(this);
  }

  @Override
  public String toString() {
    StringJoiner str = new StringJoiner(", ", "Category {", "}");

    str.add(String.join(": ", "id", id));
    str.add(String.join(": ", "createdAt", createdAt.toString()));
    str.add(String.join(": ", "updatedAt", updatedAt.toString()));
    str.add(String.join(": ", "name", name));
    str.add(String.join(": ", "description", description));

    return str.toString();
  }

  public static class Builder {

    private Category category;

    public Builder(String id) {
      this.category = new Category(id);
    }

    public static Builder create(String id) {
      return new Builder(id);
    }

    public Builder name(String name) {
      this.category.name = name;
      return this;
    }

    public Builder description(String description) {
      this.category.description = description;
      return this;
    }

    public Category build() {
      return this.category.clone();
    }

  }

}
