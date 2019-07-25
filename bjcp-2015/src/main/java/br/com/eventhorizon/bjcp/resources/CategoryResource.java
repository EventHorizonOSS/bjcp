package br.com.eventhorizon.bjcp.resources;

import org.springframework.hateoas.ResourceSupport;

public class CategoryResource extends ResourceSupport {

  private String categoryId;

  private Integer number;

  private String name;

  private String description;

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
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

}
