package br.com.eventhorizon.bjcp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Style extends BaseModel {

  @JsonProperty("overallImpression")
  private String overallImpression;

  @JsonProperty("aroma")
  private String aroma;

  @JsonProperty("appearance")
  private String appearance;

  @JsonProperty("flavor")
  private String flavor;

  @JsonProperty("mouthfeel")
  private String mouthfeel;

  @JsonProperty("comments")
  private String comments;

  @JsonProperty("history")
  private String history;

  @JsonProperty("characteristicIngredients")
  private String characteristicIngredients;

  @JsonProperty("styleComparison")
  private String styleComparison;

  @JsonProperty("vitalStatistics")
  private VitalStatistics vitalStatistics;

  @JsonProperty("commercialExamples")
  private List<String> commercialExamples;

  @JsonProperty("tags")
  private List<String> tags;

  public Style() throws NoSuchAlgorithmException {
    super();
  }

  public Style(String id) {
    super(id);
  }

  public String getOverallImpression() {
    return overallImpression;
  }

  public void setOverallImpression(String overallImpression) {
    this.overallImpression = overallImpression;
  }

  public String getAroma() {
    return aroma;
  }

  public void setAroma(String aroma) {
    this.aroma = aroma;
  }

  public String getAppearance() {
    return appearance;
  }

  public void setAppearance(String appearance) {
    this.appearance = appearance;
  }

  public String getFlavor() {
    return flavor;
  }

  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }

  public String getMouthfeel() {
    return mouthfeel;
  }

  public void setMouthfeel(String mouthfeel) {
    this.mouthfeel = mouthfeel;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  public String getCharacteristicIngredients() {
    return characteristicIngredients;
  }

  public void setCharacteristicIngredients(String characteristicIngredients) {
    this.characteristicIngredients = characteristicIngredients;
  }

  public String getStyleComparison() {
    return styleComparison;
  }

  public void setStyleComparison(String styleComparison) {
    this.styleComparison = styleComparison;
  }

  public VitalStatistics getVitalStatistics() {
    return vitalStatistics;
  }

  public void setVitalStatistics(VitalStatistics vitalStatistics) {
    this.vitalStatistics = vitalStatistics;
  }

  public List<String> getCommercialExamples() {
    return commercialExamples;
  }

  public void setCommercialExamples(List<String> commercialExamples) {
    this.commercialExamples = commercialExamples;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

}
