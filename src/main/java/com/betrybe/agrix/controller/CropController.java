package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropService cropService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService the crop service
   */
  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   * @throws CropNotFoundException the crop not found exception
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto getCropById(@PathVariable Long id) throws CropNotFoundException {
    return CropDto.fromEntity(cropService.findById(id));
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCrops() {
    return cropService.findAll()
        .stream()
        .map(CropDto::fromEntity)
        .toList();
  }
}
