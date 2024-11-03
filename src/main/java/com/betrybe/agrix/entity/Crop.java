package com.betrybe.agrix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The type Farm.
 */
@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  /**
   * Instantiates a new Crop.
   */
  public Crop() {}

  /**
   * Instantiates a new Crop.
   *
   * @param name        the name
   * @param plantedArea the plantedArea
   */
  public Crop(String name, Double plantedArea) {
    this.name = name;
    this.plantedArea = plantedArea;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets planted area.
   *
   * @return the plantedArea
   */
  public Double getPlantedArea() {
    return plantedArea;
  }

  /**
   * Sets plantedArea.
   *
   * @param plantedArea the planted area
   */
  public void setplantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Gets farm.
   *
   * @return the farm id
   */
  public Long getFarmId() {
    return farm.getId();
  }

  /**
   * Sets farm.
   *
   * @param farm the farm
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
