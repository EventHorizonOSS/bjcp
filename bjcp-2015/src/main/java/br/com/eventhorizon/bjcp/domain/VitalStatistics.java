package br.com.eventhorizon.bjcp.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VitalStatistics implements Cloneable {

  @JsonProperty("minIbu")
  private int minIbu;

  @JsonProperty("maxIbu")
  private int maxIbu;

  @JsonProperty("minSrm")
  private double minSrm;

  @JsonProperty("maxSrm")
  private double maxSrm;

  @JsonProperty("minOg")
  private double minOg;

  @JsonProperty("maxOg")
  private double maxOg;

  @JsonProperty("minFg")
  private double minFg;

  @JsonProperty("maxFg")
  private double maxFg;

  @JsonProperty("minAbv")
  private double minAbv;

  @JsonProperty("maxAbv")
  private double maxAbv;

  public VitalStatistics() {
  }

  private VitalStatistics(VitalStatistics vitalStatistics) {
    this.minIbu = vitalStatistics.minIbu;
    this.maxIbu = vitalStatistics.maxIbu;
    this.minSrm = vitalStatistics.minSrm;
    this.maxSrm = vitalStatistics.maxSrm;
    this.minOg = vitalStatistics.minOg;
    this.maxOg = vitalStatistics.maxOg;
    this.minFg = vitalStatistics.minFg;
    this.maxFg = vitalStatistics.maxFg;
    this.minAbv = vitalStatistics.minAbv;
    this.maxAbv = vitalStatistics.maxAbv;
  }

  public int getMinIbu() {
    return minIbu;
  }

  public int getMaxIbu() {
    return maxIbu;
  }

  public double getMinSrm() {
    return minSrm;
  }

  public double getMaxSrm() {
    return maxSrm;
  }

  public double getMinOg() {
    return minOg;
  }

  public double getMaxOg() {
    return maxOg;
  }

  public double getMinFg() {
    return minFg;
  }

  public double getMaxFg() {
    return maxFg;
  }

  public double getMinAbv() {
    return minAbv;
  }

  public double getMaxAbv() {
    return maxAbv;
  }

  @Override
  public VitalStatistics clone() {
    return new VitalStatistics(this);
  }

  public static class Builder {

    private VitalStatistics vitalStatistics = new VitalStatistics();

    private Builder() {
    }

    public static Builder create() {
      return new Builder();
    }

    public Builder minIbu(int minIbu) {
      this.vitalStatistics.minIbu = minIbu;
      return this;
    }

    public Builder maxIbu(int maxIbu) {
      this.vitalStatistics.maxIbu = maxIbu;
      return this;
    }

    public Builder minSrm(double minSrm) {
      this.vitalStatistics.minSrm = minSrm;
      return this;
    }

    public Builder maxSrm(double maxSrm) {
      this.vitalStatistics.maxSrm = maxSrm;
      return this;
    }

    public Builder minOg(double minOg) {
      this.vitalStatistics.minOg = minOg;
      return this;
    }

    public Builder maxOg(double maxOg) {
      this.vitalStatistics.maxOg = maxOg;
      return this;
    }

    public Builder minFg(double minFg) {
      this.vitalStatistics.minFg = minFg;
      return this;
    }

    public Builder maxFg(double maxFg) {
      this.vitalStatistics.maxFg = maxFg;
      return this;
    }

    public Builder minAbv(double minAbv) {
      this.vitalStatistics.minAbv = minAbv;
      return this;
    }

    public Builder maxAbv(double maxAbv) {
      this.vitalStatistics.maxAbv = maxAbv;
      return this;
    }

    public VitalStatistics build() {
      return this.vitalStatistics.clone();
    }

  }

}
