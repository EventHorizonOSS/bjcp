package br.com.eventhorizon.bjcp.model;

import br.com.eventhorizon.bjcp.common.model.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "styles")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Style extends Model {

  @JsonProperty("name")
  private String name;

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

  private Style(Style style) {
    super(style);
    this.name = style.name;
    this.overallImpression = style.overallImpression;
    this.aroma = style.aroma;
    this.appearance = style.appearance;
    this.flavor = style.flavor;
    this.mouthfeel = style.mouthfeel;
    this.comments = style.comments;
    this.history = style.history;
    this.characteristicIngredients = style.characteristicIngredients;
    this.styleComparison = style.styleComparison;
    this.vitalStatistics = style.vitalStatistics.clone();
    this.commercialExamples = new ArrayList<>(style.commercialExamples);
    this.tags = new ArrayList<>(style.tags);
  }

  public String getName() {
    return name;
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

  @Override
  public Style clone() {
    return new Style(this);
  }

  public static class Builder {

    private Style style;

    public Builder(String id) {
      this.style = new Style(id);
    }

    public static Builder create(String id) {
      return new Builder(id);
    }

    public Builder name(String name) {
      this.style.name = name;
      return this;
    }

    public Builder overallImpression(String overallImpression) {
      this.style.overallImpression = overallImpression;
      return this;
    }

    public Builder aroma(String aroma) {
      this.style.aroma = aroma;
      return this;
    }

    public Builder appearance(String appearance) {
      this.style.appearance = appearance;
      return this;
    }

    public Builder flavor(String flavor) {
      this.style.flavor = flavor;
      return this;
    }

    public Builder mouthfeel(String mouthfeel) {
      this.style.mouthfeel = mouthfeel;
      return this;
    }

    public Builder comments(String comments) {
      this.style.comments = comments;
      return this;
    }

    public Builder history(String history) {
      this.style.history = history;
      return this;
    }

    public Builder characteristicIngredients(String characteristicIngredients) {
      this.style.characteristicIngredients = characteristicIngredients;
      return this;
    }

    public Builder styleComparison(String styleComparison) {
      this.style.styleComparison = styleComparison;
      return this;
    }

    public Builder vitalStatistics(VitalStatistics vitalStatistics) {
      this.style.vitalStatistics = vitalStatistics;
      return this;
    }

    public Builder commercialExamples(List<String> commercialExamples) {
      this.style.commercialExamples = commercialExamples;
      return this;
    }

    public Builder tags(List<String> tags) {
      this.style.tags = tags;
      return this;
    }

    public Style build() {
      return this.style.clone();
    }

  }

}
