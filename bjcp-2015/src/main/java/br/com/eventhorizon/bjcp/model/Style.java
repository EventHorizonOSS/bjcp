package br.com.eventhorizon.bjcp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Style {

  @JsonProperty("id")
  private String id;

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

  private Style(Builder builder) {
    this.id = builder.id;
    this.overallImpression = builder.overallImpression;
    this.aroma = builder.aroma;
    this.appearance = builder.appearance;
    this.flavor = builder.flavor;
    this.mouthfeel = builder.mouthfeel;
    this.comments = builder.comments;
    this.history = builder.history;
    this.characteristicIngredients = builder.characteristicIngredients;
    this.styleComparison = builder.styleComparison;
    this.vitalStatistics = builder.vitalStatistics;
    this.commercialExamples = builder.commercialExamples;
    this.tags = builder.tags;
  }

  public String getId() {
    return id;
  }

  public String getOverallImpression() {
    return overallImpression;
  }

  public String getAroma() {
    return aroma;
  }

  public String getAppearance() {
    return appearance;
  }

  public String getFlavor() {
    return flavor;
  }

  public String getMouthfeel() {
    return mouthfeel;
  }

  public String getComments() {
    return comments;
  }

  public String getHistory() {
    return history;
  }

  public String getCharacteristicIngredients() {
    return characteristicIngredients;
  }

  public String getStyleComparison() {
    return styleComparison;
  }

  public VitalStatistics getVitalStatistics() {
    return vitalStatistics;
  }

  public List<String> getCommercialExamples() {
    return commercialExamples;
  }

  public List<String> getTags() {
    return tags;
  }

  public static class Builder {

    private String id;

    private String overallImpression;

    private String aroma;

    private String appearance;

    private String flavor;

    private String mouthfeel;

    private String comments;

    private String history;

    private String characteristicIngredients;

    private String styleComparison;

    private VitalStatistics vitalStatistics;

    private List<String> commercialExamples;

    private List<String> tags;

    private Builder() {
    }

    public static Builder create() {
      return new Builder();
    }

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public Builder withOverallImpression(String overallImpression) {
      this.overallImpression = overallImpression;
      return this;
    }

    public Builder withArona(String aroma) {
      this.aroma = aroma;
      return this;
    }

    public Builder withAppearance(String appearance) {
      this.appearance = appearance;
      return this;
    }

    public Builder withFlavor(String flavor) {
      this.flavor = flavor;
      return this;
    }

    public Builder withMouthfeel(String mouthfeel) {
      this.mouthfeel = mouthfeel;
      return this;
    }

    public Builder withComments(String comments) {
      this.comments = comments;
      return this;
    }

    public Builder withHistory(String history) {
      this.history = history;
      return this;
    }

    public Builder withCharacteristicIngredients(String characteristicIngredients) {
      this.characteristicIngredients = characteristicIngredients;
      return this;
    }

    public Builder withStyleComparison(String styleComparison) {
      this.styleComparison = styleComparison;
      return this;
    }

    public Builder withVitalStatistics(VitalStatistics vitalStatistics) {
      this.vitalStatistics = vitalStatistics;
      return this;
    }

    public Builder withCommercialExamples(List<String> commercialExamples) {
      this.commercialExamples = commercialExamples;
      return this;
    }

    public Builder withTags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    public Style build() {
      return new Style(this);
    }

  }

}
