package br.com.eventhorizon.bjcp.model;

import br.com.eventhorizon.bjcp.common.model.Model;
import br.com.eventhorizon.bjcp.common.model.PostValidator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.NoSuchAlgorithmException;
import java.util.StringJoiner;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Document(collection = "categories")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category extends Model {

  @NotEmpty(message = "Name cannot be null or empty", groups = PostValidator.class)
  @NotBlank(message = "Name cannot be blank", groups = PostValidator.class)
  @JsonProperty("name")
  private String name;

  @NotEmpty(message = "Description cannot be null or empty", groups = PostValidator.class)
  @NotBlank(message = "Description cannot be blank", groups = PostValidator.class)
  @JsonProperty("description")
  private String description;

  public Category() throws NoSuchAlgorithmException {
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
