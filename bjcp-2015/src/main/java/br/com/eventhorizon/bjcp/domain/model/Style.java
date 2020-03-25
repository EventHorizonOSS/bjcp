package br.com.eventhorizon.bjcp.domain.model;

import br.com.eventhorizon.bjcp.persistence.PersistedStyle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(as = PersistedStyle.class)
public interface Style {

  @JsonProperty("name")
  String getName();

  @JsonProperty("overallImpression")
  String getOverallImpression();

  @JsonProperty("aroma")
  String getAroma();

  @JsonProperty("appearance")
  String getAppearance();

  @JsonProperty("flavor")
  String getFlavor();

  @JsonProperty("mouthfeel")
  String getMouthfeel();

  @JsonProperty("comments")
  String getComments();

  @JsonProperty("history")
  String getHistory();

  @JsonProperty("characteristicIngredients")
  String getCharacteristicIngredients();

  @JsonProperty("styleComparison")
  String getStyleComparison();

  @JsonProperty("vitalStatistics")
  VitalStatistics getVitalStatistics();

  @JsonProperty("commercialExamples")
  List<String> getCommercialExamples();

  @JsonProperty("tags")
  List<String> getTags();

}
