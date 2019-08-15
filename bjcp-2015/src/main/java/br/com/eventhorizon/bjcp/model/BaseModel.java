package br.com.eventhorizon.bjcp.model;

import br.com.eventhorizon.bjcp.common.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel implements Cloneable {

  @Id
  @JsonProperty("id")
  protected String id;

  @JsonIgnore
  protected Date createdAt;

  @JsonIgnore
  protected Date updatedAt;

  public BaseModel() throws NoSuchAlgorithmException {
    Date now = new Date();
    this.id = IdUtil.generateDocumentId();
    this.createdAt = now;
    this.updatedAt = now;
  }

  public BaseModel(String id) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("id cannot be null or empty");
    }
    Date now = new Date();
    this.id = id;
    this.createdAt = now;
    this.updatedAt = now;
  }

  public BaseModel(String id, Date createdAt, Date updatedAt) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("id cannot be null or empty");
    }
    if (createdAt == null) {
      throw new IllegalArgumentException("createdAt cannot be null");
    }
    if (updatedAt == null) {
      throw new IllegalArgumentException("updatedAt cannot be null");
    }
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public BaseModel clone() {
    return new BaseModel(this);
  }

}
