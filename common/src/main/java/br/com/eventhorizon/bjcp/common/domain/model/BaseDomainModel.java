package br.com.eventhorizon.bjcp.common.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface BaseDomainModel extends Cloneable {

  @JsonProperty("id")
  String getId();

  void setId(String id);

  @JsonProperty("createdAt")
  Long getCreatedAt();

  void setCreatedAt(Long createdAt);

  @JsonProperty("updatedAt")
  Long getUpdatedAt();

  void setUpdatedAt(Long updatedAt);

}
