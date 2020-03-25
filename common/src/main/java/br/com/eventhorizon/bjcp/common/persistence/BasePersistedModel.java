package br.com.eventhorizon.bjcp.common.persistence;

import br.com.eventhorizon.bjcp.common.domain.model.BaseDomainModel;
import org.springframework.data.annotation.Id;

public class BasePersistedModel implements BaseDomainModel {

  @Id
  protected String id;

  protected Long createdAt;

  protected Long updatedAt;

  public BasePersistedModel() {
  }

  public BasePersistedModel(String id) {
    this.id = id;
  }

  public BasePersistedModel(String id, Long createdAt, Long updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  protected BasePersistedModel(BasePersistedModel baseModel) {
    this.id = baseModel.id;
    this.createdAt = baseModel.createdAt;
    this.updatedAt = baseModel.updatedAt;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public Long getCreatedAt() {
    return createdAt;
  }

  @Override
  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public Long getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public BasePersistedModel clone() {
    return new BasePersistedModel(this);
  }

}
