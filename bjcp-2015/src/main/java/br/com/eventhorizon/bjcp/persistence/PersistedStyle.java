package br.com.eventhorizon.bjcp.persistence;

import br.com.eventhorizon.bjcp.common.persistence.BasePersistedModel;
import br.com.eventhorizon.bjcp.domain.model.Style;
import br.com.eventhorizon.bjcp.domain.model.VitalStatistics;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "styles")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PersistedStyle extends BasePersistedModel implements Style {

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

  public PersistedStyle() throws NoSuchAlgorithmException {
    super();
  }

  public PersistedStyle(String id) {
    super(id);
  }

  private PersistedStyle(PersistedStyle persistedStyle) {
    super(persistedStyle);
    this.name = persistedStyle.name;
    this.overallImpression = persistedStyle.overallImpression;
    this.aroma = persistedStyle.aroma;
    this.appearance = persistedStyle.appearance;
    this.flavor = persistedStyle.flavor;
    this.mouthfeel = persistedStyle.mouthfeel;
    this.comments = persistedStyle.comments;
    this.history = persistedStyle.history;
    this.characteristicIngredients = persistedStyle.characteristicIngredients;
    this.styleComparison = persistedStyle.styleComparison;
    this.vitalStatistics = persistedStyle.vitalStatistics.clone();
    this.commercialExamples = new ArrayList<>(persistedStyle.commercialExamples);
    this.tags = new ArrayList<>(persistedStyle.tags);
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
  public PersistedStyle clone() {
    return new PersistedStyle(this);
  }

  public static class Builder {

    private PersistedStyle persistedStyle;

    public Builder(String id) {
      this.persistedStyle = new PersistedStyle(id);
    }

    public static PersistedStyle.Builder create(String id) {
      return new PersistedStyle.Builder(id);
    }

    public PersistedStyle.Builder name(String name) {
      this.persistedStyle.name = name;
      return this;
    }

    public PersistedStyle.Builder overallImpression(String overallImpression) {
      this.persistedStyle.overallImpression = overallImpression;
      return this;
    }

    public PersistedStyle.Builder aroma(String aroma) {
      this.persistedStyle.aroma = aroma;
      return this;
    }

    public PersistedStyle.Builder appearance(String appearance) {
      this.persistedStyle.appearance = appearance;
      return this;
    }

    public PersistedStyle.Builder flavor(String flavor) {
      this.persistedStyle.flavor = flavor;
      return this;
    }

    public PersistedStyle.Builder mouthfeel(String mouthfeel) {
      this.persistedStyle.mouthfeel = mouthfeel;
      return this;
    }

    public PersistedStyle.Builder comments(String comments) {
      this.persistedStyle.comments = comments;
      return this;
    }

    public PersistedStyle.Builder history(String history) {
      this.persistedStyle.history = history;
      return this;
    }

    public PersistedStyle.Builder characteristicIngredients(String characteristicIngredients) {
      this.persistedStyle.characteristicIngredients = characteristicIngredients;
      return this;
    }

    public PersistedStyle.Builder styleComparison(String styleComparison) {
      this.persistedStyle.styleComparison = styleComparison;
      return this;
    }

    public PersistedStyle.Builder vitalStatistics(VitalStatistics vitalStatistics) {
      this.persistedStyle.vitalStatistics = vitalStatistics;
      return this;
    }

    public PersistedStyle.Builder commercialExamples(List<String> commercialExamples) {
      this.persistedStyle.commercialExamples = commercialExamples;
      return this;
    }

    public PersistedStyle.Builder tags(List<String> tags) {
      this.persistedStyle.tags = tags;
      return this;
    }

    public Style build() {
      return this.persistedStyle.clone();
    }

  }

}
