package br.com.eventhorizon.bjcp.domain.model;

import br.com.eventhorizon.bjcp.common.domain.model.BaseDomainModel;
import br.com.eventhorizon.bjcp.common.domain.validation.CreateValidation;
import br.com.eventhorizon.bjcp.common.domain.validation.UpdateValidation;
import br.com.eventhorizon.bjcp.persistence.PersistedCategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(as = PersistedCategory.class)
public interface Category extends BaseDomainModel {

  @NotBlank(message = "Name cannot be null, empty or blank", groups = CreateValidation.class)
  @NotBlank(message = "Name cannot be null, empty or blank", groups = UpdateValidation.class)
  @JsonProperty("name")
  String getName();

  void setName(String name);

  @NotBlank(message = "Description cannot be null, empty or blank", groups = CreateValidation.class)
  @NotBlank(message = "Description cannot be null, empty or blank", groups = UpdateValidation.class)
  @JsonProperty("description")
  String getDescription();

  void setDescription(String description);

}
