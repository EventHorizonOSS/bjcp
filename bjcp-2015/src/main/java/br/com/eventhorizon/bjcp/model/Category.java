package br.com.eventhorizon.bjcp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.StringJoiner;

@Document(collection = "categories")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category extends BaseModel {

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  public Category() throws NoSuchAlgorithmException {
    super();
  }

  public Category(Integer number, String name, String description) throws NoSuchAlgorithmException {
    this.number = number;
    this.name = name;
    this.description = description;
  }

  public Category(String id, Integer number, String name, String description) {
    super(id);
    this.number = number;
    this.name = name;
    this.description = description;
  }

  public Category(String id, Date createdAt, Date updatedAt,
      Integer number, String name, String description) {
    super(id, createdAt, updatedAt);
    this.number = number;
    this.name = name;
    this.description = description;
  }

  public Category(Builder builder) {
    super(builder.id);
    this.number = builder.number;
    this.name = builder.name;
    this.description = builder.description;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
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
  public String toString() {
    StringJoiner str = new StringJoiner(", ", "Category {", "}");

    str.add(String.join(": ", "id", id));
    str.add(String.join(": ", "createdAt", createdAt.toString()));
    str.add(String.join(": ", "updatedAt", updatedAt.toString()));
    str.add(String.join(": ", "number", number.toString()));
    str.add(String.join(": ", "name", name));
    str.add(String.join(": ", "description", description));

    return str.toString();
  }

  public static class Builder {

    private String id;

    private Integer number;

    private String name;

    private String description;

    private Builder () {
    }

    public static Builder create() {
      return new Builder();
    }

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public Builder withNumber(Integer number) {
      this.number = number;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withDescription(String description) {
      this.description = description;
      return this;
    }

    public Category build() {
      return new Category(this);
    }

  }

}
