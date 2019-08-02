package br.com.eventhorizon.bjcp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category {

  @JsonProperty("id")
  private String id;

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  private Category(Builder builder) {
    this.id = builder.id;
    this.number = builder.number;
    this.name = builder.name;
    this.description = builder.description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
