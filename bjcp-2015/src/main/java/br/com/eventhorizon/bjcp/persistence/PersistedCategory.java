package br.com.eventhorizon.bjcp.persistence;

import br.com.eventhorizon.bjcp.common.persistence.BasePersistedModel;
import br.com.eventhorizon.bjcp.domain.model.Category;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringJoiner;

@Document(collection = "categories")
public class PersistedCategory extends BasePersistedModel implements Category {

  private String name;

  private String description;

  public PersistedCategory() {
    super();
  }

  public PersistedCategory(String id) {
    super(id);
  }

  public PersistedCategory(PersistedCategory persistedCategory) {
    super(persistedCategory);
    this.name = persistedCategory.name;
    this.description = persistedCategory.description;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public PersistedCategory clone() {
    return new PersistedCategory(this);
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

    private PersistedCategory persistedCategory;

    public Builder(String id) {
      this.persistedCategory = new PersistedCategory(id);
    }

    public static PersistedCategory.Builder create(String id) {
      return new PersistedCategory.Builder(id);
    }

    public PersistedCategory.Builder name(String name) {
      this.persistedCategory.name = name;
      return this;
    }

    public PersistedCategory.Builder description(String description) {
      this.persistedCategory.description = description;
      return this;
    }

    public PersistedCategory build() {
      return this.persistedCategory.clone();
    }

  }

}
