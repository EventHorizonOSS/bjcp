package br.com.eventhorizon.bjcp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VitalStatistics {

  @JsonProperty("ibu")
  private int ibu;

  @JsonProperty("srm")
  private int srm;

  @JsonProperty("og")
  private double og;

  @JsonProperty("fg")
  private double fg;

  @JsonProperty("abv")
  private double abv;

  public VitalStatistics() {
  }

  public VitalStatistics(int ibu, int srm, double og, double fg, double abv) {
    this.ibu = ibu;
    this.srm = srm;
    this.og = og;
    this.fg = fg;
    this.abv = abv;
  }

  public VitalStatistics(Builder builder) {
    this.ibu = builder.ibu;
    this.srm = builder.srm;
    this.og = builder.og;
    this.fg = builder.fg;
    this.abv = builder.abv;
  }

  public int getIbu() {
    return ibu;
  }

  public int getSrm() {
    return srm;
  }

  public double getOg() {
    return og;
  }

  public double getFg() {
    return fg;
  }

  public double getAbv() {
    return abv;
  }

  public static class Builder {

    private int ibu;

    private int srm;

    private double og;

    private double fg;

    private double abv;

    private Builder() {
    }

    public static Builder create() {
      return new Builder();
    }

    public static Builder create(int ibu, int srm, double og, double fg, double abv) {
      Builder builder = new Builder();

      builder.ibu = ibu;
      builder.srm = srm;
      builder.og = og;
      builder.fg = fg;
      builder.abv = abv;

      return builder;
    }

    public Builder withIbu(int ibu) {
      this.ibu = ibu;
      return this;
    }

    public Builder withSrm(int srm) {
      this.srm = srm;
      return this;
    }

    public Builder withOg(double og) {
      this.og = og;
      return this;
    }

    public Builder withFg(double fg) {
      this.fg = fg;
      return this;
    }

    public Builder withAbv(double abv) {
      this.abv = abv;
      return this;
    }

    public VitalStatistics build() {
      return new VitalStatistics(this);
    }

  }

}
