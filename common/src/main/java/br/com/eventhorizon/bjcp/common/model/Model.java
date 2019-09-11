package br.com.eventhorizon.bjcp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model implements Cloneable {

  @Id
  @JsonProperty("id")
  protected String id;

  @JsonProperty("createdAt")
  protected Long createdAt;

  @JsonProperty("updatedAt")
  protected Long updatedAt;

  public Model() {
  }

  public Model(String id) {
    this.id = id;
  }

  public Model(String id, Long createdAt, Long updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  protected Model(Model model) {
    this.id = model.id;
    this.createdAt = model.createdAt;
    this.updatedAt = model.updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public Long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public Model clone() {
    return new Model(this);
  }

}
