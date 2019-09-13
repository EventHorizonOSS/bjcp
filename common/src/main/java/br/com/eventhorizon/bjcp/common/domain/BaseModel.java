package br.com.eventhorizon.bjcp.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel implements Cloneable {

  @Id
  @JsonProperty("id")
  protected String id;

  @JsonProperty("createdAt")
  protected Long createdAt;

  @JsonProperty("updatedAt")
  protected Long updatedAt;

  public BaseModel() {
  }

  public BaseModel(String id) {
    this.id = id;
  }

  public BaseModel(String id, Long createdAt, Long updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  protected BaseModel(BaseModel baseModel) {
    this.id = baseModel.id;
    this.createdAt = baseModel.createdAt;
    this.updatedAt = baseModel.updatedAt;
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
  public BaseModel clone() {
    return new BaseModel(this);
  }

}
